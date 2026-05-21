package BibliotecaInclusiva.AtivIndividual.DTO.Usuario;

import BibliotecaInclusiva.AtivIndividual.DTO.Emprestimo.EmprestimoDTOResponse;
import BibliotecaInclusiva.AtivIndividual.DTO.PerfilAcessibilidade.PerfilAcessibilidadeDTOResponse;
import BibliotecaInclusiva.AtivIndividual.Domain.Emprestimo;
import BibliotecaInclusiva.AtivIndividual.Domain.PerfilAcessibilidade;
import BibliotecaInclusiva.AtivIndividual.Domain.Usuario;
import BibliotecaInclusiva.AtivIndividual.Enumerated.Tipo;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import java.util.ArrayList;
import java.util.List;

@JsonPropertyOrder({
    "id",
    "nome",
    "tipo",
    "perfilAcessibilidade",
    "emprestimos"
})

public class UsuarioDTOResponse {

    private Long id;
    private String nome;
    private Tipo tipo;
    private PerfilAcessibilidadeDTOResponse perfilAcessibilidade;
    private List<EmprestimoDTOResponse> emprestimos;

    public UsuarioDTOResponse() {
    }

    public UsuarioDTOResponse(Usuario usuario) {
        this.id = usuario.getId();
        this.nome = usuario.getNome();
        this.tipo = usuario.getTipo();
        this.perfilAcessibilidade = usuario.getPerfilAcessibilidade() != null
                                    ? new PerfilAcessibilidadeDTOResponse(usuario.getPerfilAcessibilidade())
                                    : null;
        this.emprestimos = usuario.getEmprestimos()
                .stream()
                .map(EmprestimoDTOResponse::new)
                .toList();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome= nome;
    }

    public Tipo getTipo() {
        return tipo;
    }

    public void setTipo(Tipo tipo) {
        this.tipo = tipo;
    }

    public PerfilAcessibilidadeDTOResponse getPerfilAcessibilidade() {
        return perfilAcessibilidade;
    }

    public void setPerfilAcessibilidade(PerfilAcessibilidadeDTOResponse perfilAcessibilidade) {
        this.perfilAcessibilidade = perfilAcessibilidade;
    }

    public List<EmprestimoDTOResponse> getEmprestimos() {
        return emprestimos;
    }

    public void setEmprestimos(List<EmprestimoDTOResponse> emprestimos) {
        this.emprestimos = emprestimos;
    }
}
