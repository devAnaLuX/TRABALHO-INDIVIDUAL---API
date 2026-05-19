package BibliotecaInclusiva.AtivIndividual.Repository;

import BibliotecaInclusiva.AtivIndividual.Domain.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
}
