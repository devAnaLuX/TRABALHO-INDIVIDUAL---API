package BibliotecaInclusiva.AtivIndividual.Controller;

import BibliotecaInclusiva.AtivIndividual.DTO.Emprestimo.EmprestimoDTORequest;
import BibliotecaInclusiva.AtivIndividual.DTO.Emprestimo.EmprestimoDTOResponse;
import BibliotecaInclusiva.AtivIndividual.Service.EmprestimoService;
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

@Tag(name = "Emprestimo", description = "Gerenciamento completo de emprestimos — CRUD")
@RestController
@RequestMapping("/emprestimos")
public class EmprestimoController {

    @Autowired
    private EmprestimoService emprestimoService;


    @Operation(summary = "Buscar empréstimos", description = "Busca todos os empréstimos")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Busca concluída."),
            @ApiResponse(responseCode = "500", description = "Erro interno no servidor")
    })
    @GetMapping
    public ResponseEntity<List<EmprestimoDTOResponse>> buscar(){
        return ResponseEntity.ok(emprestimoService.buscar());
    }


    @Operation(summary = "Buscar empréstimo - ID", description = "Busca o empréstimo pelo ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Busca concluída."),
            @ApiResponse(responseCode = "400", description = "Dados inválidos."),
            @ApiResponse(responseCode = "404", description = "Empréstimo não encontrado."),
            @ApiResponse(responseCode = "500", description = "Erro interno no servidor")
    })
    @GetMapping("/{id}")
    public ResponseEntity<EmprestimoDTOResponse> buscarPorId(@PathVariable Long id){
        return ResponseEntity.ok(emprestimoService.buscarId(id));
    }


    @Operation(summary = "Adicionar empréstimo", description = "Adiciona empréstimo")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Criado."),
            @ApiResponse(responseCode = "400", description = "Dados inválidos."),
            @ApiResponse(responseCode = "500", description = "Erro interno no servidor")
    })
    @PostMapping
    public ResponseEntity<EmprestimoDTOResponse> adicionar(@Valid @RequestBody EmprestimoDTORequest emprestimoDTORequest){
        EmprestimoDTOResponse emprestimoDTO = emprestimoService.adicionar(emprestimoDTORequest);

        URI uri = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(emprestimoDTO.getId())
                .toUri();

        return ResponseEntity.created(uri).body(emprestimoDTO);
    }


    @Operation(summary = "Atualizar empréstimo - ID", description = "Atualizar empréstimo por ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Atualizado."),
            @ApiResponse(responseCode = "400", description = "Dados inválidos."),
            @ApiResponse(responseCode = "404", description = "Empréstimo não encontrado."),
            @ApiResponse(responseCode = "500", description = "Erro interno no servidor")
    })
    @PutMapping("/{id}")
    public ResponseEntity<EmprestimoDTOResponse> atualizar(@PathVariable Long id, @Valid @RequestBody EmprestimoDTORequest emprestimoDTORequest){
        return ResponseEntity.ok(emprestimoService.atualizar(id, emprestimoDTORequest));
    }


    @Operation(summary = "Deletar empréstimo - ID", description = "Deletar o empréstimo pelo ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "204", description = "Deletado."),
            @ApiResponse(responseCode = "400", description = "Dados inválidos."),
            @ApiResponse(responseCode = "404", description = "Empréstimo não encontrado."),
            @ApiResponse(responseCode = "500", description = "Erro interno no servidor")
    })
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id){
        emprestimoService.deletar(id);

        return ResponseEntity.noContent().build();
    }

}
