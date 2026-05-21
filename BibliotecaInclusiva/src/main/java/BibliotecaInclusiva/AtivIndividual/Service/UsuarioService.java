package BibliotecaInclusiva.AtivIndividual.Service;

import BibliotecaInclusiva.AtivIndividual.DTO.Usuario.UsuarioDTORequest;
import BibliotecaInclusiva.AtivIndividual.DTO.Usuario.UsuarioDTOResponse;
import BibliotecaInclusiva.AtivIndividual.Domain.PerfilAcessibilidade;
import BibliotecaInclusiva.AtivIndividual.Domain.Usuario;
import BibliotecaInclusiva.AtivIndividual.Exception.DuplicateEntryException;
import BibliotecaInclusiva.AtivIndividual.Exception.ResourceNotFoundException;
import BibliotecaInclusiva.AtivIndividual.Repository.PerfilAcessibilidadeRepository;
import BibliotecaInclusiva.AtivIndividual.Repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private PerfilAcessibilidadeRepository perfilAcessibilidadeRepository;


    public List<UsuarioDTOResponse> buscar(){
        return usuarioRepository.findAll()
                .stream()
                .map(UsuarioDTOResponse::new)
                .toList();
    }

    public UsuarioDTOResponse buscarID(Long id){
        return usuarioRepository.findById(id)
                .map(UsuarioDTOResponse::new)
                .orElseThrow(() -> new ResourceNotFoundException("Usuário não encontrado com id: "+id));
    }

    public UsuarioDTOResponse adicionar(UsuarioDTORequest usuarioDTORequest){

        if (usuarioRepository.findByEmail(usuarioDTORequest.getEmail()) != null){
            throw new DuplicateEntryException("O email já está cadastrado.");
        }

        if(usuarioRepository.findByTelefone(usuarioDTORequest.getTelefone()) != null){
            throw new DuplicateEntryException("O número já está cadastrado.");
        }

        Usuario user = new Usuario();
        user.setNome(usuarioDTORequest.getNome());
        user.setEmail(usuarioDTORequest.getEmail());
        user.setTelefone(usuarioDTORequest.getTelefone());
        user.setTipo(usuarioDTORequest.getTipo());

        if (usuarioDTORequest.getPerfilAcessibilidadeId() != null){
            PerfilAcessibilidade perfil = perfilAcessibilidadeRepository
                    .findById(usuarioDTORequest.getPerfilAcessibilidadeId())
                    .orElseThrow(() -> new ResourceNotFoundException("Perfil não encontrado."));
        }
        else {
            user.setPerfilAcessibilidade(null);
        }
        usuarioRepository.save(user);
        return new UsuarioDTOResponse(user);

    }

    public UsuarioDTOResponse atualizar(Long id, UsuarioDTORequest usuarioDTORequest){
        Usuario user = usuarioRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Usuário não encontrado com o id: "+id));

        if (usuarioRepository.findByEmail(usuarioDTORequest.getEmail()) != null){
            throw new DuplicateEntryException("O email já está cadastrado.");
        }

        if(usuarioRepository.findByTelefone(usuarioDTORequest.getTelefone()) != null){
            throw new DuplicateEntryException("O número já está cadastrado.");
        }

        PerfilAcessibilidade perfil = perfilAcessibilidadeRepository
                .findById(usuarioDTORequest.getPerfilAcessibilidadeId())
                .orElseThrow(() -> new ResourceNotFoundException("Perfil não encontrado."));

        user.setNome(usuarioDTORequest.getNome());
        user.setEmail(usuarioDTORequest.getEmail());
        user.setTelefone(usuarioDTORequest.getTelefone());
        user.setTipo(usuarioDTORequest.getTipo());
        user.setPerfilAcessibilidade(perfil);

        usuarioRepository.save(user);
        return new UsuarioDTOResponse(user);

    }

    public void deletar(Long id){
        if (!usuarioRepository.existsById(id)){
            throw new ResourceNotFoundException("Usuário não encontrado com o id: "+ id);
        }

        usuarioRepository.deleteById(id);
    }

}
