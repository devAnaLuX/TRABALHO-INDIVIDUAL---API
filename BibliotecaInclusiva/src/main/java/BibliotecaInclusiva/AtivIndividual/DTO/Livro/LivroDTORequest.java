package BibliotecaInclusiva.AtivIndividual.DTO.Livro;

public class LivroDTORequest {

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

    public LivroDTORequest() {
    }

    public LivroDTORequest(String titulo, String autor, String isbn, String idioma, Integer anoPublicacao, boolean disponivelBraille, boolean disponivelAudioLivro, boolean disponivelEbook, boolean disponivelLibras, Integer exemplaresTotal) {
        this.titulo = titulo;
        this.autor = autor;
        this.isbn = isbn;
        this.idioma = idioma;
        this.anoPublicacao = anoPublicacao;
        this.disponivelBraille = disponivelBraille;
        this.disponivelAudioLivro = disponivelAudioLivro;
        this.disponivelEbook = disponivelEbook;
        this.disponivelLibras = disponivelLibras;
        this.exemplaresTotal = exemplaresTotal;
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
