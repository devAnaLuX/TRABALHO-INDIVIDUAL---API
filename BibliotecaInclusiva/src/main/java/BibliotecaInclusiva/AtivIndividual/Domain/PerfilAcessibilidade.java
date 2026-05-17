package BibliotecaInclusiva.AtivIndividual.Domain;

import jakarta.persistence.*;

@Entity
@Table(name = "perfil_acessibilidade")
public class PerfilAcessibilidade {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Deficiencia deficiencia;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Formato formatoPreferido;

    @Column
    private Integer tamanhoFonte;

    @Column
    private boolean altoContraste;

    @Column(nullable = false)
    private String leitorTela;

    @OneToOne
    @JoinColumn(name = "usuario_id", nullable = false)
    private Usuario usuario;

    public PerfilAcessibilidade() {
    }

    public PerfilAcessibilidade(Long id, Deficiencia deficiencia, Formato formatoPreferido, Integer tamanhoFonte, boolean altoContraste, String leitorTela, Usuario usuario) {
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

    public String getLeitorTela() {
        return leitorTela;
    }

    public void setLeitorTela(String leitorTela) {
        this.leitorTela = leitorTela;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
}
