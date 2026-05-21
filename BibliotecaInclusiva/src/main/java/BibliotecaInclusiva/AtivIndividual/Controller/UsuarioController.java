package BibliotecaInclusiva.AtivIndividual.Controller;

import BibliotecaInclusiva.AtivIndividual.DTO.Usuario.UsuarioDTORequest;
import BibliotecaInclusiva.AtivIndividual.DTO.Usuario.UsuarioDTOResponse;
import BibliotecaInclusiva.AtivIndividual.Service.UsuarioService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @GetMapping
    public ResponseEntity<List<UsuarioDTOResponse>> buscar(){
        return ResponseEntity.ok(usuarioService.buscar());
    }

    @GetMapping("/{id}")
    public ResponseEntity<UsuarioDTOResponse> buscarPorId(@PathVariable Long id){
        return ResponseEntity.ok(usuarioService.buscarID(id));
    }

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

    @PutMapping("/{id}")
    public ResponseEntity<UsuarioDTOResponse> atualizar(@PathVariable Long id, @Valid @RequestBody UsuarioDTORequest usuario){
        return ResponseEntity.ok(usuarioService.atualizar(id, usuario));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id){
        usuarioService.deletar(id);

        return ResponseEntity.noContent().build();
    }

}
