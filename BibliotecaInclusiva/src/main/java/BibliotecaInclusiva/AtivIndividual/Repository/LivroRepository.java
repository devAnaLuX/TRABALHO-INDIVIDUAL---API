package BibliotecaInclusiva.AtivIndividual.Repository;

import BibliotecaInclusiva.AtivIndividual.Domain.Livro;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LivroRepository extends JpaRepository<Livro, Long> {
}
