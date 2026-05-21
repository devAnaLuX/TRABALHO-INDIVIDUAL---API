package BibliotecaInclusiva.AtivIndividual.DTO.Emprestimo;

import BibliotecaInclusiva.AtivIndividual.Domain.Emprestimo;
import BibliotecaInclusiva.AtivIndividual.Enumerated.Formato;
import BibliotecaInclusiva.AtivIndividual.Enumerated.Status;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import java.time.LocalDate;

@JsonPropertyOrder({
        "id",
        "dataEmprestimo",
        "dataPrevista",
        "dataDevolucao",
        "formatoEmprestado",
        "status",
        "livroId",
        "usuarioId"
})

public class EmprestimoDTOResponse {

    private Long id;
    private LocalDate dataEmprestimo;
    private LocalDate dataPrevista;
    private LocalDate dataDevolucao;
    private Formato formatoEmprestado;
    private Status status;
    private Long livroId;
    private Long usuarioId;

    public EmprestimoDTOResponse() {
    }

    public EmprestimoDTOResponse(Emprestimo emprestimo) {
        this.id = emprestimo.getId();
        this.dataEmprestimo = emprestimo.getDataEmprestimo();
        this.dataPrevista = emprestimo.getDataPrevista();
        this.dataDevolucao = emprestimo.getDataDevolucao();
        this.formatoEmprestado = emprestimo.getFormatoEmprestado();
        this.status = emprestimo.getStatus();
        this.livroId = emprestimo.getLivro().getId();
        this.usuarioId = emprestimo.getUsuario().getId();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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
