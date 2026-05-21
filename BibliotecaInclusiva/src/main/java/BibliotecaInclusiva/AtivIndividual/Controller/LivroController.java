package BibliotecaInclusiva.AtivIndividual.Controller;

import BibliotecaInclusiva.AtivIndividual.DTO.Livro.LivroDTORequest;
import BibliotecaInclusiva.AtivIndividual.DTO.Livro.LivroDTOResponse;
import BibliotecaInclusiva.AtivIndividual.Service.LivroService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@Tag(name = "Livro", description = "Gerenciamento completo de livros — CRUD")
@RestController
@RequestMapping("/livros")
public class LivroController {

    @Autowired
    private LivroService livroService;


    @Operation(summary = "Buscar livros", description = "Busca todos os livros")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Busca concluída."),
            @ApiResponse(responseCode = "500", description = "Erro interno no servidor")
    })
    @GetMapping
    public ResponseEntity<List<LivroDTOResponse>> buscar(){
        return ResponseEntity.ok(livroService.buscar());
    }


    @Operation(summary = "Buscar livro - ID", description = "Busca o livro pelo ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Busca concluída."),
            @ApiResponse(responseCode = "400", description = "Dados inválidos."),
            @ApiResponse(responseCode = "404", description = "Livro não encontrado."),
            @ApiResponse(responseCode = "500", description = "Erro interno no servidor")
    })
    @GetMapping("/{id}")
    public ResponseEntity<LivroDTOResponse> buscarPorId(@PathVariable Long id){
        return ResponseEntity.ok(livroService.buscarId(id));
    }


    @Operation(summary = "Adicionar livro", description = "Adiciona livro")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Criado."),
            @ApiResponse(responseCode = "400", description = "Dados inválidos."),
            @ApiResponse(responseCode = "409", description = "ISBN já cadastrado."),
            @ApiResponse(responseCode = "500", description = "Erro interno no servidor")
    })
    @PostMapping
    public ResponseEntity<LivroDTOResponse> adicionar(@Valid @RequestBody LivroDTORequest newLivro){
        LivroDTOResponse livroDTO = livroService.adicionar(newLivro);

        URI uri = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(livroDTO.getId())
                .toUri();

        return ResponseEntity.created(uri).body(livroDTO);
    }


    @Operation(summary = "Atualizar livro - ID", description = "Atualizar livro por ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Atualizado."),
            @ApiResponse(responseCode = "400", description = "Dados inválidos."),
            @ApiResponse(responseCode = "404", description = "Livro não encontrado."),
            @ApiResponse(responseCode = "409", description = "ISBN já cadastrado."),
            @ApiResponse(responseCode = "500", description = "Erro interno no servidor")
    })
    @PutMapping("/{id}")
    public ResponseEntity<LivroDTOResponse> atualizar(@PathVariable Long id, @Valid @RequestBody LivroDTORequest livro){
        return ResponseEntity.ok(livroService.atualizar(id, livro));
    }


    @Operation(summary = "Deletar livro - ID", description = "Deletar o livro pelo ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "204", description = "Deletado."),
            @ApiResponse(responseCode = "400", description = "Dados inválidos."),
            @ApiResponse(responseCode = "404", description = "Livro não encontrado."),
            @ApiResponse(responseCode = "500", description = "Erro interno no servidor")
    })
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id){
        livroService.deletar(id);

        return ResponseEntity.noContent().build();
    }
}
