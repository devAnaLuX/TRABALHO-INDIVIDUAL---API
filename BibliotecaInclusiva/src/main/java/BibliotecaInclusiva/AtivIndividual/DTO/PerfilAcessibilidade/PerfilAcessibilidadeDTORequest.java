package BibliotecaInclusiva.AtivIndividual.DTO.PerfilAcessibilidade;

import BibliotecaInclusiva.AtivIndividual.Enumerated.Deficiencia;
import BibliotecaInclusiva.AtivIndividual.Enumerated.Formato;

public class PerfilAcessibilidadeDTORequest {

    private Deficiencia deficiencia;
    private Formato formatoPreferido;
    private Integer tamanhoFonte;
    private boolean altoContraste;
    private boolean leitorTela;
    private Long usuarioid;

    public PerfilAcessibilidadeDTORequest() {
    }

    public PerfilAcessibilidadeDTORequest(Deficiencia deficiencia, Formato formatoPreferido, Integer tamanhoFonte, boolean altoContraste, boolean leitorTela, Long usuarioid) {
        this.deficiencia = deficiencia;
        this.formatoPreferido = formatoPreferido;
        this.tamanhoFonte = tamanhoFonte;
        this.altoContraste = altoContraste;
        this.leitorTela = leitorTela;
        this.usuarioid = usuarioid;
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

    public Long getUsuarioid() {
        return usuarioid;
    }

    public void setUsuarioid(Long usuarioid) {
        this.usuarioid = usuarioid;
    }
}
