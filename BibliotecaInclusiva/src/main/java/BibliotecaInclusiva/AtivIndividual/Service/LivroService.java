package BibliotecaInclusiva.AtivIndividual.Service;

import BibliotecaInclusiva.AtivIndividual.DTO.Livro.LivroDTORequest;
import BibliotecaInclusiva.AtivIndividual.DTO.Livro.LivroDTOResponse;
import BibliotecaInclusiva.AtivIndividual.Domain.Livro;
import BibliotecaInclusiva.AtivIndividual.Exception.DuplicateEntryException;
import BibliotecaInclusiva.AtivIndividual.Exception.ResourceNotFoundException;
import BibliotecaInclusiva.AtivIndividual.Repository.LivroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LivroService {

    @Autowired
    private LivroRepository livroRepository;

    public List<LivroDTOResponse> buscar(){
        return livroRepository.findAll()
                .stream()
                .map(LivroDTOResponse::new)
                .toList();
    }

    public LivroDTOResponse buscarId(Long id){
        return livroRepository.findById(id)
                .map(LivroDTOResponse::new)
                .orElseThrow(() -> new ResourceNotFoundException("Usuário não encontrado com id: "+id));
    }

    public LivroDTOResponse adicionar(LivroDTORequest livro){

        if(livroRepository.findByIsbn(livro.getIsbn()) != null){
            throw new DuplicateEntryException("Livro já cadastrado.");
        }

        Livro livros = new Livro();
        livros.setTitulo(livro.getTitulo());
        livros.setAutor(livro.getAutor());
        livros.setIsbn(livro.getIsbn());
        livros.setIdioma(livro.getIdioma());
        livros.setAnoPublicacao(livro.getAnoPublicacao());
        livros.setDisponivelBraille(livro.isDisponivelBraille());
        livros.setDisponivelAudioLivro(livro.isDisponivelAudioLivro());
        livros.setDisponivelEbook(livro.isDisponivelEbook());
        livros.setDisponivelLibras(livro.isDisponivelLibras());
        livros.setExemplaresTotal(livro.getExemplaresTotal());

        livroRepository.save(livros);
        return new LivroDTOResponse(livros);
    }

    public LivroDTOResponse atualizar(Long id, LivroDTORequest livro){
        Livro livros = livroRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Usuário não encontrado com id: "+id));

        livros.setTitulo(livros.getTitulo());
        livros.setAutor(livro.getAutor());
        livros.setIsbn(livro.getIsbn());
        livros.setIdioma(livro.getIdioma());
        livros.setAnoPublicacao(livro.getAnoPublicacao());
        livros.setDisponivelBraille(livro.isDisponivelBraille());
        livros.setDisponivelAudioLivro(livro.isDisponivelAudioLivro());
        livros.setDisponivelEbook(livro.isDisponivelEbook());
        livros.setDisponivelLibras(livro.isDisponivelLibras());
        livros.setExemplaresTotal(livro.getExemplaresTotal());

        livroRepository.save(livros);
        return new LivroDTOResponse(livros);
    }

    public void deletar(Long id){
        if(!livroRepository.existsById(id)){
            throw new ResourceNotFoundException("Usuário não encontrado com id: "+id);
        }
        livroRepository.deleteById(id);
    }
}
