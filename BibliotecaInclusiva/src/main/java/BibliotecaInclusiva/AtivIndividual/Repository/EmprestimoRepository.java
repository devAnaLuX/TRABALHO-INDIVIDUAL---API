package BibliotecaInclusiva.AtivIndividual.Repository;

import BibliotecaInclusiva.AtivIndividual.Domain.Emprestimo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmprestimoRepository extends JpaRepository<Emprestimo, Long> {
}
