package BibliotecaInclusiva.AtivIndividual.Controller;

import BibliotecaInclusiva.AtivIndividual.DTO.Usuario.UsuarioDTORequest;
import BibliotecaInclusiva.AtivIndividual.DTO.Usuario.UsuarioDTOResponse;
import BibliotecaInclusiva.AtivIndividual.Service.UsuarioService;
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

@Tag(name = "Usuário", description = "Gerenciamento completo de usuários — CRUD")
@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @Operation(summary = "Buscar usuários", description = "Busca todos os usuários")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Busca concluída."),
            @ApiResponse(responseCode = "500", description = "Erro interno no servidor")
    })
    @GetMapping
    public ResponseEntity<List<UsuarioDTOResponse>> buscar(){
        return ResponseEntity.ok(usuarioService.buscar());
    }


    @Operation(summary = "Buscar usuários - ID", description = "Busca o usuário pelo ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Busca concluída."),
            @ApiResponse(responseCode = "400", description = "Dados inválidos."),
            @ApiResponse(responseCode = "404", description = "Usuário não encontrado."),
            @ApiResponse(responseCode = "500", description = "Erro interno no servidor")
    })
    @GetMapping("/{id}")
    public ResponseEntity<UsuarioDTOResponse> buscarPorId(@PathVariable Long id){
        return ResponseEntity.ok(usuarioService.buscarID(id));
    }


    @Operation(summary = "Adicionar usuário", description = "Adiciona usuário")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Criado."),
            @ApiResponse(responseCode = "400", description = "Dados inválidos."),
            @ApiResponse(responseCode = "409", description = "Email ou telefone já cadastrados."),
            @ApiResponse(responseCode = "500", description = "Erro interno no servidor")
    })
    @PostMapping
    public ResponseEntity<UsuarioDTOResponse> adicionar(@Valid @RequestBody UsuarioDTORequest usuario){

        UsuarioDTOResponse usuarioDTO = usuarioService.adicionar(usuario);

        URI uri = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(usuarioDTO.getId())
                .toUri();

        return ResponseEntity.created(uri).body(usuarioDTO);
    }


    @Operation(summary = "Atualizar usuário - ID", description = "Atualizar usuário por ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Atualizado."),
            @ApiResponse(responseCode = "400", description = "Dados inválidos."),
            @ApiResponse(responseCode = "404", description = "Usuário não encontrado."),
            @ApiResponse(responseCode = "409", description = "Email ou telefone já cadastrados."),
            @ApiResponse(responseCode = "500", description = "Erro interno no servidor")
    })
    @PutMapping("/{id}")
    public ResponseEntity<UsuarioDTOResponse> atualizar(@PathVariable Long id, @Valid @RequestBody UsuarioDTORequest usuario){
        return ResponseEntity.ok(usuarioService.atualizar(id, usuario));
    }


    @Operation(summary = "Deletar usuario - ID", description = "Deletar o usuário pelo ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "204", description = "Deletado."),
            @ApiResponse(responseCode = "400", description = "Dados inválidos."),
            @ApiResponse(responseCode = "404", description = "Usuário não encontrado."),
            @ApiResponse(responseCode = "500", description = "Erro interno no servidor")
    })
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id){
        usuarioService.deletar(id);

        return ResponseEntity.noContent().build();
    }

}
