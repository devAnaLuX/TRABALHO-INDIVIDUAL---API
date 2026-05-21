package BibliotecaInclusiva.AtivIndividual.Domain;

import BibliotecaInclusiva.AtivIndividual.Enumerated.Tipo;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "usuario")
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Schema(description = "Identificador único do usuário.", example = "1")
    private Long id;

    @NotBlank
    @Column(nullable = false, length = 80)
    @Schema(description = "Nome do usuário")
    private String nome;

    @Email
    @Column(nullable = false, unique = true)
    @Schema(description = "Email do usuário")
    private String email;

    @NotBlank
    @Column(nullable = false, length = 11)
    @Schema(description = "Telefone do usuário")
    private String telefone;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    @Schema(description = "Tipo do usuário", example = "Estudante")
    private Tipo tipo;

    @CreationTimestamp
    @Column(nullable = false, updatable = false)
    @Schema(description = "Data do cadastro do usuário")
    private LocalDate dataCadastro;

    @OneToOne(mappedBy = "usuario", cascade = CascadeType.ALL)
    @Schema(description = "Perfil do usuário")
    private PerfilAcessibilidade perfilAcessibilidade;

    @OneToMany(mappedBy = "usuario")
    @Schema(description = "Empréstimos do usuário")
    private List<Emprestimo> emprestimos = new ArrayList<>();

    public Usuario() {
    }

    public Usuario(Long id, String nome, String email, String telefone, Tipo tipo, LocalDate dataCadastro, PerfilAcessibilidade perfilAcessibilidade, List<Emprestimo> emprestimos) {
        this.id = id;
        this.nome = nome;
        this.email = email;
        this.telefone = telefone;
        this.tipo = tipo;
        this.dataCadastro = dataCadastro;
        this.perfilAcessibilidade = perfilAcessibilidade;
        this.emprestimos = emprestimos;
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

    public LocalDate getDataCadastro() {
        return dataCadastro;
    }

    public void setDataCadastro(LocalDate dataCadastro) {
        this.dataCadastro = dataCadastro;
    }

    public PerfilAcessibilidade getPerfilAcessibilidade() {
        return perfilAcessibilidade;
    }

    public void setPerfilAcessibilidade(PerfilAcessibilidade perfilAcessibilidade) {
        this.perfilAcessibilidade = perfilAcessibilidade;
    }

    public List<Emprestimo> getEmprestimos() {
        return emprestimos;
    }

    public void setEmprestimos(List<Emprestimo> emprestimos) {
        this.emprestimos = emprestimos;
    }
}
