package BibliotecaInclusiva.AtivIndividual.Service;

import BibliotecaInclusiva.AtivIndividual.DTO.Categoria.CategoriaDTORequest;
import BibliotecaInclusiva.AtivIndividual.DTO.Categoria.CategoriaDTOResponse;
import BibliotecaInclusiva.AtivIndividual.Domain.Categoria;
import BibliotecaInclusiva.AtivIndividual.Domain.Livro;
import BibliotecaInclusiva.AtivIndividual.Exception.ResourceNotFoundException;
import BibliotecaInclusiva.AtivIndividual.Repository.CategoriaRepository;
import BibliotecaInclusiva.AtivIndividual.Repository.LivroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoriaService {

    @Autowired
    private CategoriaRepository categoriaRepository;

    @Autowired
    private LivroRepository livroRepository;

    public List<CategoriaDTOResponse> buscar(){
        return categoriaRepository.findAll()
                .stream()
                .map(CategoriaDTOResponse::new)
                .toList();
    }

    public CategoriaDTOResponse buscarId(Long id){
        return categoriaRepository.findById(id)
                .map(CategoriaDTOResponse::new)
                .orElseThrow(() -> new ResourceNotFoundException("Categoria não encontrada"));
    }

    public CategoriaDTOResponse adicionar(CategoriaDTORequest categoriaDTORequest){

        Categoria categoria = new Categoria();
        categoria.setNome(categoriaDTORequest.getNome());
        categoria.setDescricao(categoriaDTORequest.getDescricao());

        categoriaRepository.save(categoria);

        if (categoriaDTORequest.getLivrosIds()!= null ) {
            List<Livro> livros = livroRepository.findAllById(categoriaDTORequest.getLivrosIds());

            for (Livro livro:livros){
                livro.getCategorias().add(categoria);
                livroRepository.save(livro);
            }

            categoria.setLivros(livros);
        }

        categoriaRepository.save(categoria);
        return new CategoriaDTOResponse(categoria);
    }

    public CategoriaDTOResponse atualizar(Long id,CategoriaDTORequest categoriaDTORequest){

        Categoria categoria = categoriaRepository.findById(id)
                        .orElseThrow(() -> new ResourceNotFoundException("Categoria não encontrada."));

        categoria.setNome(categoriaDTORequest.getNome());
        categoria.setDescricao(categoriaDTORequest.getDescricao());

        if (categoriaDTORequest.getLivrosIds()!= null ) {
            for (Livro livro:categoria.getLivros()){
                livro.getCategorias().remove(categoria);
                livroRepository.save(livro);
            }

            List<Livro> livros = livroRepository.findAllById(categoriaDTORequest.getLivrosIds());

            for (Livro livro : livros){
                livro.getCategorias().add(categoria);
                livroRepository.save(livro);
            }


            categoria.setLivros(livros);
        }

        categoriaRepository.save(categoria);
        return new CategoriaDTOResponse(categoria);
    }

    public void deletar(Long id){
        if (!categoriaRepository.existsById(id)){
            throw new ResourceNotFoundException("Categoria não encontrada.");
        }

        categoriaRepository.deleteById(id);
    }
}
