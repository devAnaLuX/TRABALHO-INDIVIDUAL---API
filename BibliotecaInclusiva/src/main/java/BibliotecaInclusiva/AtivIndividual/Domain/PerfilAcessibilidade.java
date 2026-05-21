package BibliotecaInclusiva.AtivIndividual.Domain;

import BibliotecaInclusiva.AtivIndividual.Enumerated.Deficiencia;
import BibliotecaInclusiva.AtivIndividual.Enumerated.Formato;
import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;


@Entity
@Table(name = "perfil_acessibilidade")
public class PerfilAcessibilidade {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Schema(description = "Identificador único do perfil")
    private Long id;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    @Schema(description = "Tipo de deficiência")
    private Deficiencia deficiencia;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    @Schema(description = "Formato de livro preferido", example = "Ebook")
    private Formato formatoPreferido;

    @Column
    @Schema(description = "Tamanho da fonte do livro", example = "12")
    private Integer tamanhoFonte;

    @Column
    @Schema(description = "Com ou sem alto contraste")
    private boolean altoContraste;

    @Column(nullable = false)
    @Schema(description = "Com ou sem leitor de tela")
    private boolean leitorTela;

    @JsonIgnore
    @OneToOne
    @JoinColumn(name = "usuario_id", nullable = false, unique = true)
    @Schema(description = "Usuário dono do perfil")
    private Usuario usuario;

    public PerfilAcessibilidade() {
    }

    public PerfilAcessibilidade(Long id, Deficiencia deficiencia, Formato formatoPreferido, Integer tamanhoFonte, boolean altoContraste, boolean leitorTela, Usuario usuario) {
        this.id = id;
        this.deficiencia = deficiencia;
        this.formatoPreferido = formatoPreferido;
        this.tamanhoFonte = tamanhoFonte;
        this.altoContraste = altoContraste;
        this.leitorTela = leitorTela;
        this.usuario = usuario;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Deficiencia getDeficiencia() {
        return deficiencia;
    }

    public void setDeficiencia(Deficiencia deficiencia) {
        this.deficiencia = deficiencia;
    }

    public Formato getFormatoPreferido() {
        return formatoPreferido;
    }

    public void setFormatoPreferido(Formato formatoPreferido) {
        this.formatoPreferido = formatoPreferido;
    }

    public Integer getTamanhoFonte() {
        return tamanhoFonte;
    }

    public void setTamanhoFonte(Integer tamanhoFonte) {
        this.tamanhoFonte = tamanhoFonte;
    }

    public boolean isAltoContraste() {
        return altoContraste;
    }

    public void setAltoContraste(boolean altoContraste) {
        this.altoContraste = altoContraste;
    }

    public boolean isLeitorTela() {
        return leitorTela;
    }

    public void setLeitorTela(boolean leitorTela) {
        this.leitorTela = leitorTela;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
}
