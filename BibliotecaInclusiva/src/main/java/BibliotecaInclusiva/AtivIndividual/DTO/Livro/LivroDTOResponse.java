package BibliotecaInclusiva.AtivIndividual.DTO.Livro;

import BibliotecaInclusiva.AtivIndividual.Domain.Emprestimo;
import BibliotecaInclusiva.AtivIndividual.Domain.Livro;
import BibliotecaInclusiva.AtivIndividual.Enumerated.Status;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@JsonPropertyOrder({
    "id",
    "titulo",
    "autor",
    "isbn",
    "idioma",
    "anoPublicacao",
    "disponivelBraille",
    "disponivelAudioLivro",
    "disponivelEbook",
    "disponivelLibras",
    "exemplaresTotal"
})

public class LivroDTOResponse {

    private Long id;
    private String titulo;
    private String autor;
    private String isbn;
    private String idioma;
    private Integer anoPublicacao;
    private boolean disponivelBraille;
    private boolean disponivelAudioLivro;
    private boolean disponivelEbook;
    private boolean disponivelLibras;
    private Integer exemplaresTotal;


    public static class EmprestimoResumidoDTO {
        private Long id;
        private LocalDate dataEmprestimo;
        private LocalDate dataPrevista;
        private Status status;

        public EmprestimoResumidoDTO(Emprestimo emprestimo) {
            this.id = emprestimo.getId();
            this.dataEmprestimo = emprestimo.getDataEmprestimo();
            this.dataPrevista = emprestimo.getDataPrevista();
            this.status = emprestimo.getStatus();
        }

        public Long getId() { return id; }
        public LocalDate getDataEmprestimo() { return dataEmprestimo; }
        public LocalDate getDataPrevista() { return dataPrevista; }
        public Status getStatus() { return status; }
    }


    public LivroDTOResponse() {
    }

    public LivroDTOResponse(Livro livro) {
        this.id = livro.getId();
        this.titulo = livro.getTitulo();
        this.autor = livro.getAutor();
        this.isbn = livro.getIsbn();
        this.idioma = livro.getIdioma();
        this.anoPublicacao = livro.getAnoPublicacao();
        this.disponivelBraille = livro.isDisponivelBraille();
        this.disponivelAudioLivro = livro.isDisponivelAudioLivro();
        this.disponivelEbook = livro.isDisponivelEbook();
        this.disponivelLibras = livro.isDisponivelLibras();
        this.exemplaresTotal = livro.getExemplaresTotal();

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getIdioma() {
        return idioma;
    }

    public void setIdioma(String idioma) {
        this.idioma = idioma;
    }

    public Integer getAnoPublicacao() {
        return anoPublicacao;
    }

    public void setAnoPublicacao(Integer anoPublicacao) {
        this.anoPublicacao = anoPublicacao;
    }

    public boolean isDisponivelBraille() {
        return disponivelBraille;
    }

    public void setDisponivelBraille(boolean disponivelBraille) {
        this.disponivelBraille = disponivelBraille;
    }

    public boolean isDisponivelAudioLivro() {
        return disponivelAudioLivro;
    }

    public void setDisponivelAudioLivro(boolean disponivelAudioLivro) {
        this.disponivelAudioLivro = disponivelAudioLivro;
    }

    public boolean isDisponivelEbook() {
        return disponivelEbook;
    }

    public void setDisponivelEbook(boolean disponivelEbook) {
        this.disponivelEbook = disponivelEbook;
    }

    public boolean isDisponivelLibras() {
        return disponivelLibras;
    }

    public void setDisponivelLibras(boolean disponivelLibras) {
        this.disponivelLibras = disponivelLibras;
    }

    public Integer getExemplaresTotal() {
        return exemplaresTotal;
    }

    public void setExemplaresTotal(Integer exemplaresTotal) {
        this.exemplaresTotal = exemplaresTotal;
    }

}
