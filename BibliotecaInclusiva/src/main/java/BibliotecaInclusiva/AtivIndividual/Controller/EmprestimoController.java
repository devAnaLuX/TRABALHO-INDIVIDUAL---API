package BibliotecaInclusiva.AtivIndividual.Controller;

import BibliotecaInclusiva.AtivIndividual.DTO.Emprestimo.EmprestimoDTORequest;
import BibliotecaInclusiva.AtivIndividual.DTO.Emprestimo.EmprestimoDTOResponse;
import BibliotecaInclusiva.AtivIndividual.Service.EmprestimoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/emprestimos")
public class EmprestimoController {

    @Autowired
    private EmprestimoService emprestimoService;

    @GetMapping
    public ResponseEntity<List<EmprestimoDTOResponse>> buscar(){
        return ResponseEntity.ok(emprestimoService.buscar());
    }

    @GetMapping("/{id}")
    public ResponseEntity<EmprestimoDTOResponse> buscarPorId(@PathVariable Long id){
        return ResponseEntity.ok(emprestimoService.buscarId(id));
    }

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

    @PutMapping("/{id}")
    public ResponseEntity<EmprestimoDTOResponse> atualizar(@PathVariable Long id, @Valid @RequestBody EmprestimoDTORequest emprestimoDTORequest){
        return ResponseEntity.ok(emprestimoService.atualizar(id, emprestimoDTORequest));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id){
        emprestimoService.deletar(id);

        return ResponseEntity.noContent().build();
    }

}
