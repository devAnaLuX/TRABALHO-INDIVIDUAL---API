package BibliotecaInclusiva.AtivIndividual.DTO.Categoria;

import BibliotecaInclusiva.AtivIndividual.DTO.Livro.LivroDTOResponse;
import BibliotecaInclusiva.AtivIndividual.Domain.Categoria;
import BibliotecaInclusiva.AtivIndividual.Domain.Livro;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import java.util.ArrayList;
import java.util.List;

@JsonPropertyOrder({
        "id",
        "nome",
        "descricao",
        "livrosIds"
})

public class CategoriaDTOResponse {

    private Long id;
    private String nome;
    private String descricao;
    private List<LivroDTOResponse> livrosIds = new ArrayList<>();

    public CategoriaDTOResponse() {
    }

    public CategoriaDTOResponse(Categoria categoria) {
        this.id = categoria.getId();
        this.nome = categoria.getNome();
        this.descricao = categoria.getDescricao();
        this.livrosIds = categoria.getLivros()
                        .stream()
                        .map(LivroDTOResponse::new)
                        .toList();
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

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public List<LivroDTOResponse> getLivrosIds() {
        return livrosIds;
    }

    public void setLivrosIds(List<LivroDTOResponse> livrosIds) {
        this.livrosIds = livrosIds;
    }
}
