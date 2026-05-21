package BibliotecaInclusiva.AtivIndividual.Controller;

import BibliotecaInclusiva.AtivIndividual.DTO.PerfilAcessibilidade.PerfilAcessibilidadeDTORequest;
import BibliotecaInclusiva.AtivIndividual.DTO.PerfilAcessibilidade.PerfilAcessibilidadeDTOResponse;
import BibliotecaInclusiva.AtivIndividual.Service.PerfilAcessibilidadeService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/perfis")
public class PerfilAcessibilidadeController {

    @Autowired
    private PerfilAcessibilidadeService perfilAcessibilidadeService;

    @GetMapping
    public ResponseEntity<List<PerfilAcessibilidadeDTOResponse>> buscar(){
        return ResponseEntity.ok(perfilAcessibilidadeService.buscar());
    }

    @GetMapping("/{id}")
    public ResponseEntity<PerfilAcessibilidadeDTOResponse> buscarPorId(@PathVariable Long id){
        return ResponseEntity.ok(perfilAcessibilidadeService.buscarID(id));
    }

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

    @PutMapping("/{id}")
    public ResponseEntity<PerfilAcessibilidadeDTOResponse> atualizar(@PathVariable Long id, @Valid @RequestBody PerfilAcessibilidadeDTORequest perfil){
        return ResponseEntity.ok(perfilAcessibilidadeService.atualizar(id, perfil));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id){
        perfilAcessibilidadeService.deletar(id);

        return ResponseEntity.noContent().build();
    }
}
