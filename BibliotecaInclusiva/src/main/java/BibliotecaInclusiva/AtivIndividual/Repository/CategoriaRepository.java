package BibliotecaInclusiva.AtivIndividual.Repository;

import BibliotecaInclusiva.AtivIndividual.Domain.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoriaRepository extends JpaRepository<Categoria, Long> {
}
