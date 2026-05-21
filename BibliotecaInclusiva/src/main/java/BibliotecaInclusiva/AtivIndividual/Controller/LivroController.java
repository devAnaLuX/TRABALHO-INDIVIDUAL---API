package BibliotecaInclusiva.AtivIndividual.Controller;

import BibliotecaInclusiva.AtivIndividual.DTO.Livro.LivroDTORequest;
import BibliotecaInclusiva.AtivIndividual.DTO.Livro.LivroDTOResponse;
import BibliotecaInclusiva.AtivIndividual.Service.LivroService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/livros")
public class LivroController {

    @Autowired
    private LivroService livroService;

    @GetMapping
    public ResponseEntity<List<LivroDTOResponse>> buscar(){
        return ResponseEntity.ok(livroService.buscar());
    }

    @GetMapping("/{id}")
    public ResponseEntity<LivroDTOResponse> buscarPorId(@PathVariable Long id){
        return ResponseEntity.ok(livroService.buscarId(id));
    }

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

    @PutMapping("/{id}")
    public ResponseEntity<LivroDTOResponse> atualizar(@PathVariable Long id, @Valid @RequestBody LivroDTORequest livro){
        return ResponseEntity.ok(livroService.atualizar(id, livro));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id){
        livroService.deletar(id);

        return ResponseEntity.noContent().build();
    }
}
