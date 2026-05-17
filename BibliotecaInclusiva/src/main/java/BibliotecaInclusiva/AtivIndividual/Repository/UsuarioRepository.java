package BibliotecaInclusiva.AtivIndividual.Repository;

import BibliotecaInclusiva.AtivIndividual.Domain.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
}
