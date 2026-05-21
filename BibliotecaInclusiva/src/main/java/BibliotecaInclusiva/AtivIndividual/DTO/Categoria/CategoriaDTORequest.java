package BibliotecaInclusiva.AtivIndividual.DTO.Categoria;

import java.util.ArrayList;
import java.util.List;

public class CategoriaDTORequest {

    private String nome;
    private String descricao;
    private List<Long> livrosIds = new ArrayList<>();

    public CategoriaDTORequest() {
    }

    public CategoriaDTORequest(String nome, String descricao, List<Long> livrosIds) {
        this.nome = nome;
        this.descricao = descricao;
        this.livrosIds = livrosIds;
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

    public List<Long> getLivrosIds() {
        return livrosIds;
    }

    public void setLivrosIds(List<Long> livrosIds) {
        this.livrosIds = livrosIds;
    }
}
