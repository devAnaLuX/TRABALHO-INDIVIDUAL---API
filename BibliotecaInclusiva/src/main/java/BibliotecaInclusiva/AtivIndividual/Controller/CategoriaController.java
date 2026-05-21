package BibliotecaInclusiva.AtivIndividual.Controller;

import BibliotecaInclusiva.AtivIndividual.DTO.Categoria.CategoriaDTORequest;
import BibliotecaInclusiva.AtivIndividual.DTO.Categoria.CategoriaDTOResponse;
import BibliotecaInclusiva.AtivIndividual.Service.CategoriaService;
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

@Tag(name = "Categoria", description = "Gerenciamento completo de categorias — CRUD")
@RestController
@RequestMapping("/categorias")
public class CategoriaController {

    @Autowired
    private CategoriaService categoriaService;


    @Operation(summary = "Buscar categorias", description = "Busca todos as categorias")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Busca concluída."),
            @ApiResponse(responseCode = "500", description = "Erro interno no servidor")
    })
    @GetMapping
    public ResponseEntity<List<CategoriaDTOResponse>> buscar(){
        return ResponseEntity.ok(categoriaService.buscar());
    }


    @Operation(summary = "Buscar categoria - ID", description = "Busca a categoria pelo ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Busca concluída."),
            @ApiResponse(responseCode = "400", description = "Dados inválidos."),
            @ApiResponse(responseCode = "404", description = "Categoria não encontrado."),
            @ApiResponse(responseCode = "500", description = "Erro interno no servidor")
    })
    @GetMapping("/{id}")
    public ResponseEntity<CategoriaDTOResponse> buscarId(@PathVariable Long id){
        return ResponseEntity.ok(categoriaService.buscarId(id));
    }


    @Operation(summary = "Adicionar categoria", description = "Adiciona categoria")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Criado."),
            @ApiResponse(responseCode = "400", description = "Dados inválidos."),
            @ApiResponse(responseCode = "500", description = "Erro interno no servidor")
    })
    @PostMapping
    public ResponseEntity<CategoriaDTOResponse> adicionar(@Valid @RequestBody CategoriaDTORequest categoriaDTORequest){
        CategoriaDTOResponse categoriaDTO = categoriaService.adicionar(categoriaDTORequest);

        URI uri = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(categoriaDTO.getId())
                .toUri();

        return ResponseEntity.created(uri).body(categoriaDTO);
    }


    @Operation(summary = "Atualizar categoria - ID", description = "Atualizar categoria por ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Atualizado."),
            @ApiResponse(responseCode = "400", description = "Dados inválidos."),
            @ApiResponse(responseCode = "404", description = "Categoria não encontrado."),
            @ApiResponse(responseCode = "500", description = "Erro interno no servidor")
    })
    @PutMapping("/{id}")
    public ResponseEntity<CategoriaDTOResponse> atualizar(@PathVariable Long id, @Valid @RequestBody CategoriaDTORequest categoriaDTORequest){
        return ResponseEntity.ok(categoriaService.atualizar(id, categoriaDTORequest));
    }


    @Operation(summary = "Deletar categoria - ID", description = "Deletar o categoria pelo ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "204", description = "Deletado."),
            @ApiResponse(responseCode = "400", description = "Dados inválidos."),
            @ApiResponse(responseCode = "404", description = "Categoria não encontrado."),
            @ApiResponse(responseCode = "500", description = "Erro interno no servidor")
    })
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id){
        categoriaService.deletar(id);

        return ResponseEntity.noContent().build();
    }
}
