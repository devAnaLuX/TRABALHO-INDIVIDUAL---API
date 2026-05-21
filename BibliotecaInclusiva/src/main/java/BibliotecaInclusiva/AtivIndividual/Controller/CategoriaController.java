package BibliotecaInclusiva.AtivIndividual.Controller;

import BibliotecaInclusiva.AtivIndividual.DTO.Categoria.CategoriaDTORequest;
import BibliotecaInclusiva.AtivIndividual.DTO.Categoria.CategoriaDTOResponse;
import BibliotecaInclusiva.AtivIndividual.Service.CategoriaService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/categorias")
public class CategoriaController {

    @Autowired
    private CategoriaService categoriaService;

    @GetMapping
    public ResponseEntity<List<CategoriaDTOResponse>> buscar(){
        return ResponseEntity.ok(categoriaService.buscar());
    }

    @GetMapping("/{id}")
    public ResponseEntity<CategoriaDTOResponse> buscarId(@PathVariable Long id){
        return ResponseEntity.ok(categoriaService.buscarId(id));
    }

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

    @PutMapping("/{id}")
    public ResponseEntity<CategoriaDTOResponse> atualizar(@PathVariable Long id, @Valid @RequestBody CategoriaDTORequest categoriaDTORequest){
        return ResponseEntity.ok(categoriaService.atualizar(id, categoriaDTORequest));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id){
        categoriaService.deletar(id);

        return ResponseEntity.noContent().build();
    }
}
