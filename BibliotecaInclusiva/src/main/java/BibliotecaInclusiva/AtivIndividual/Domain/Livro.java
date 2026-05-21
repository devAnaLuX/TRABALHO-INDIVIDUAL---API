package BibliotecaInclusiva.AtivIndividual.Domain;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.util.ArrayList;
import java.util.List;


@Entity
@Table(name = "livros")
public class Livro {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    @Column(nullable = false, length = 80)
    private String titulo;

    @NotBlank
    @Column(nullable = false, length = 80)
    private String autor;

    @NotNull
    @Column(nullable = false, length = 13)
    private String isbn;

    @NotBlank
    @Column(nullable = false, length = 40)
    private String idioma;

    @NotNull
    @Column(nullable = false)
    private Integer anoPublicacao;

    @Column(nullable = false)
    private boolean disponivelBraille;

    @Column(nullable = false)
    private boolean disponivelAudioLivro;

    @Column(nullable = false)
    private boolean disponivelEbook;

    @Column(nullable = false)
    private boolean disponivelLibras;

    @Column(nullable = false)
    private Integer exemplaresTotal;

    @OneToMany(mappedBy = "livro")
    private List<Emprestimo> emprestimos = new ArrayList<>();

    @ManyToMany
    @JoinTable(
            name = "livro_categoria",
            joinColumns = @JoinColumn(name = "livro_id"),
            inverseJoinColumns = @JoinColumn(name = "categoria_id")
    )
    private List<Categoria> categorias = new ArrayList<>();

    public Livro() {
    }

    public Livro(Long id, String titulo, String autor, String isbn, String idioma, Integer anoPublicacao, boolean disponivelBraille, boolean disponivelAudioLivro, boolean disponivelEbook, boolean disponivelLibras, Integer exemplaresTotal, List<Emprestimo> emprestimos, List<Categoria> categorias) {
        this.id = id;
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
        this.emprestimos = emprestimos;
        this.categorias = categorias;
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

    public List<Emprestimo> getEmprestimos() {
        return emprestimos;
    }

    public void setEmprestimos(List<Emprestimo> emprestimos) {
        this.emprestimos = emprestimos;
    }

    public List<Categoria> getCategorias() {
        return categorias;
    }

    public void setCategorias(List<Categoria> categorias) {
        this.categorias = categorias;
    }
}
