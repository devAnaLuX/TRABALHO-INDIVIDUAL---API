package BibliotecaInclusiva.AtivIndividual.DTO.Usuario;

import BibliotecaInclusiva.AtivIndividual.Enumerated.Tipo;

public class UsuarioDTORequest {

    private String nome;
    private String email;
    private String telefone;
    private Tipo tipo;
    private Long perfilAcessibilidadeId;

    public UsuarioDTORequest() {
    }

    public UsuarioDTORequest(String nome, String email, String telefone, Tipo tipo, Long perfilAcessibilidadeId) {
        this.nome = nome;
        this.email = email;
        this.telefone = telefone;
        this.tipo = tipo;
        this.perfilAcessibilidadeId = perfilAcessibilidadeId;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public Tipo getTipo() {
        return tipo;
    }

    public void setTipo(Tipo tipo) {
        this.tipo = tipo;
    }

    public Long getPerfilAcessibilidadeId() {
        return perfilAcessibilidadeId;
    }

    public void setPerfilAcessibilidadeId(Long perfilAcessibilidadeId) {
        this.perfilAcessibilidadeId = perfilAcessibilidadeId;
    }
}
