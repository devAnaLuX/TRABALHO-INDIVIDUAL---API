package BibliotecaInclusiva.AtivIndividual.DTO.PerfilAcessibilidade;

import BibliotecaInclusiva.AtivIndividual.Domain.PerfilAcessibilidade;
import BibliotecaInclusiva.AtivIndividual.Enumerated.Deficiencia;
import BibliotecaInclusiva.AtivIndividual.Enumerated.Formato;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonPropertyOrder({
        "usuarioId",
        "id",
        "deficiencia",
        "formatoPreferido",
        "tamanhoFonte",
        "altoContraste",
        "leitorTela"
})

public class PerfilAcessibilidadeDTOResponse {

    private Long id;
    private Deficiencia deficiencia;
    private Formato formatoPreferido;
    private Integer tamanhoFonte;
    private boolean altoContraste;
    private boolean leitorTela;
    private Long usuarioId;

    public PerfilAcessibilidadeDTOResponse() {
    }

    public PerfilAcessibilidadeDTOResponse(PerfilAcessibilidade perfilAcessibilidade) {
        this.id = perfilAcessibilidade.getId();
        this.deficiencia = perfilAcessibilidade.getDeficiencia();
        this.formatoPreferido = perfilAcessibilidade.getFormatoPreferido();
        this.tamanhoFonte = perfilAcessibilidade.getTamanhoFonte();
        this.altoContraste = perfilAcessibilidade.isAltoContraste();
        this.leitorTela = perfilAcessibilidade.isLeitorTela();
        this.usuarioId = perfilAcessibilidade.getUsuario().getId();
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

    public Long getUsuarioId() {
        return usuarioId;
    }

    public void setUsuarioId(Long usuarioId) {
        this.usuarioId = usuarioId;
    }
}
