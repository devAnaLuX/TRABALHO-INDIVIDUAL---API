package BibliotecaInclusiva.AtivIndividual.DTO.Emprestimo;

import BibliotecaInclusiva.AtivIndividual.Enumerated.Formato;
import BibliotecaInclusiva.AtivIndividual.Enumerated.Status;

import java.time.LocalDate;

public class EmprestimoDTORequest {

    private LocalDate dataEmprestimo;
    private LocalDate dataPrevista;
    private LocalDate dataDevolucao;
    private Formato formatoEmprestado;
    private Status status;
    private Long livroId;
    private Long usuarioId;

    public EmprestimoDTORequest() {
    }

    public EmprestimoDTORequest(LocalDate dataEmprestimo, LocalDate dataPrevista, LocalDate dataDevolucao, Formato formatoEmprestado, Status status, Long livroId, Long usuarioId) {
        this.dataEmprestimo = dataEmprestimo;
        this.dataPrevista = dataPrevista;
        this.dataDevolucao = dataDevolucao;
        this.formatoEmprestado = formatoEmprestado;
        this.status = status;
        this.livroId = livroId;
        this.usuarioId = usuarioId;
    }

    public LocalDate getDataEmprestimo() {
        return dataEmprestimo;
    }

    public void setDataEmprestimo(LocalDate dataEmprestimo) {
        this.dataEmprestimo = dataEmprestimo;
    }

    public LocalDate getDataPrevista() {
        return dataPrevista;
    }

    public void setDataPrevista(LocalDate dataPrevista) {
        this.dataPrevista = dataPrevista;
    }

    public LocalDate getDataDevolucao() {
        return dataDevolucao;
    }

    public void setDataDevolucao(LocalDate dataDevolucao) {
        this.dataDevolucao = dataDevolucao;
    }

    public Formato getFormatoEmprestado() {
        return formatoEmprestado;
    }

    public void setFormatoEmprestado(Formato formatoEmprestado) {
        this.formatoEmprestado = formatoEmprestado;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public Long getLivroId() {
        return livroId;
    }

    public void setLivroId(Long livroId) {
        this.livroId = livroId;
    }

    public Long getUsuarioId() {
        return usuarioId;
    }

    public void setUsuarioId(Long usuarioId) {
        this.usuarioId = usuarioId;
    }
}
