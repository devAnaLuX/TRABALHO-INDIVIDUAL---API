package BibliotecaInclusiva.AtivIndividual.Controller;

import BibliotecaInclusiva.AtivIndividual.DTO.PerfilAcessibilidade.PerfilAcessibilidadeDTORequest;
import BibliotecaInclusiva.AtivIndividual.DTO.PerfilAcessibilidade.PerfilAcessibilidadeDTOResponse;
import BibliotecaInclusiva.AtivIndividual.Service.PerfilAcessibilidadeService;
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

@Tag(name = "Perfil Acessibilidade", description = "Gerenciamento completo de perfis — CRUD")
@RestController
@RequestMapping("/perfis")
public class PerfilAcessibilidadeController {

    @Autowired
    private PerfilAcessibilidadeService perfilAcessibilidadeService;


    @Operation(summary = "Buscar perfis", description = "Busca todos os perfis")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Busca concluída."),
            @ApiResponse(responseCode = "500", description = "Erro interno no servidor")
    })
    @GetMapping
    public ResponseEntity<List<PerfilAcessibilidadeDTOResponse>> buscar(){
        return ResponseEntity.ok(perfilAcessibilidadeService.buscar());
    }


    @Operation(summary = "Buscar perfil - ID", description = "Busca o perfil pelo ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Busca concluída."),
            @ApiResponse(responseCode = "400", description = "Dados inválidos."),
            @ApiResponse(responseCode = "404", description = "Perfil não encontrado."),
            @ApiResponse(responseCode = "500", description = "Erro interno no servidor")
    })
    @GetMapping("/{id}")
    public ResponseEntity<PerfilAcessibilidadeDTOResponse> buscarPorId(@PathVariable Long id){
        return ResponseEntity.ok(perfilAcessibilidadeService.buscarID(id));
    }


    @Operation(summary = "Adicionar perfil", description = "Adiciona perfil")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Criado."),
            @ApiResponse(responseCode = "400", description = "Dados inválidos."),
            @ApiResponse(responseCode = "500", description = "Erro interno no servidor")
    })
    @PostMapping
    public ResponseEntity<PerfilAcessibilidadeDTOResponse> adicionar( @Valid @RequestBody PerfilAcessibilidadeDTORequest perfil){

        PerfilAcessibilidadeDTOResponse perfilAcessibilidadeDTO = perfilAcessibilidadeService.adicionar(perfil.getUsuarioid(),perfil);

        URI uri = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(perfilAcessibilidadeDTO.getId())
                .toUri();

        return ResponseEntity.created(uri).body(perfilAcessibilidadeDTO);
    }


    @Operation(summary = "Atualizar perfil - ID", description = "Atualizar usuário por ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Atualizado."),
            @ApiResponse(responseCode = "400", description = "Dados inválidos."),
            @ApiResponse(responseCode = "404", description = "Perfil não encontrado."),
            @ApiResponse(responseCode = "500", description = "Erro interno no servidor")
    })
    @PutMapping("/{id}")
    public ResponseEntity<PerfilAcessibilidadeDTOResponse> atualizar(@PathVariable Long id, @Valid @RequestBody PerfilAcessibilidadeDTORequest perfil){
        return ResponseEntity.ok(perfilAcessibilidadeService.atualizar(id, perfil));
    }


    @Operation(summary = "Deletar perfil - ID", description = "Deletar o perfil pelo ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "204", description = "Deletado."),
            @ApiResponse(responseCode = "400", description = "Dados inválidos."),
            @ApiResponse(responseCode = "404", description = "Perfil não encontrado."),
            @ApiResponse(responseCode = "500", description = "Erro interno no servidor")
    })
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id){
        perfilAcessibilidadeService.deletar(id);

        return ResponseEntity.noContent().build();
    }
}
