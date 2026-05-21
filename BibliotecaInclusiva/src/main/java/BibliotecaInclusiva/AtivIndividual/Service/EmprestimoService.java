package BibliotecaInclusiva.AtivIndividual.Service;

import BibliotecaInclusiva.AtivIndividual.DTO.Emprestimo.EmprestimoDTORequest;
import BibliotecaInclusiva.AtivIndividual.DTO.Emprestimo.EmprestimoDTOResponse;
import BibliotecaInclusiva.AtivIndividual.Domain.Emprestimo;
import BibliotecaInclusiva.AtivIndividual.Domain.Livro;
import BibliotecaInclusiva.AtivIndividual.Domain.Usuario;
import BibliotecaInclusiva.AtivIndividual.Exception.ResourceNotFoundException;
import BibliotecaInclusiva.AtivIndividual.Repository.EmprestimoRepository;
import BibliotecaInclusiva.AtivIndividual.Repository.LivroRepository;
import BibliotecaInclusiva.AtivIndividual.Repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmprestimoService {

    @Autowired
    private EmprestimoRepository emprestimoRepository;

    @Autowired
    private LivroRepository livroRepository;

    @Autowired
    private UsuarioRepository usuarioRepository;

    public List<EmprestimoDTOResponse> buscar(){
        return emprestimoRepository.findAll()
                .stream()
                .map(EmprestimoDTOResponse::new)
                .toList();
    }

    public EmprestimoDTOResponse buscarId(Long id){
        return emprestimoRepository.findById(id)
                .map(EmprestimoDTOResponse::new)
                .orElseThrow(() -> new ResourceNotFoundException("Empréstimo não encontrado com id: "+id));
    }

    public EmprestimoDTOResponse adicionar(EmprestimoDTORequest newEmprestimo){

        Livro livro = livroRepository.findById(newEmprestimo.getLivroId())
                .orElseThrow(() -> new ResourceNotFoundException("Livro não encontrado."));

        Usuario usuario = usuarioRepository.findById(newEmprestimo.getUsuarioId())
                .orElseThrow(() -> new ResourceNotFoundException("Usuário não encontrado."));

        Emprestimo emprestimo = new Emprestimo();
        emprestimo.setDataEmprestimo(newEmprestimo.getDataEmprestimo());
        emprestimo.setDataPrevista(newEmprestimo.getDataPrevista());
        emprestimo.setDataDevolucao(newEmprestimo.getDataDevolucao());
        emprestimo.setFormatoEmprestado(newEmprestimo.getFormatoEmprestado());
        emprestimo.setStatus(newEmprestimo.getStatus());
        emprestimo.setLivro(livro);
        emprestimo.setUsuario(usuario);

        emprestimoRepository.save(emprestimo);
        return new EmprestimoDTOResponse(emprestimo);
    }

    public EmprestimoDTOResponse atualizar(Long id, EmprestimoDTORequest emprestimo){

        Emprestimo emprestimos = emprestimoRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Empréstimo não encontrado com id: "+id));

        Livro livro = livroRepository.findById(emprestimo.getLivroId())
                .orElseThrow(() -> new ResourceNotFoundException("Livro não encontrado."));

        Usuario usuario = usuarioRepository.findById(emprestimo.getUsuarioId())
                .orElseThrow(() -> new ResourceNotFoundException("Usuário não encontrado."));

        emprestimos.setDataEmprestimo(emprestimo.getDataEmprestimo());
        emprestimos.setDataPrevista(emprestimo.getDataPrevista());
        emprestimos.setDataDevolucao(emprestimo.getDataDevolucao());
        emprestimos.setFormatoEmprestado(emprestimo.getFormatoEmprestado());
        emprestimos.setStatus(emprestimo.getStatus());
        emprestimos.setLivro(livro);
        emprestimos.setUsuario(usuario);

        emprestimoRepository.save(emprestimos);
        return new EmprestimoDTOResponse(emprestimos);
    }

    public void deletar(Long id){
        if(!emprestimoRepository.existsById(id)){
            throw new ResourceNotFoundException("Empréstimo não encontrado com id: "+id);
        }

        emprestimoRepository.deleteById(id);
    }

}
