package BibliotecaInclusiva.AtivIndividual.Service;

import BibliotecaInclusiva.AtivIndividual.DTO.PerfilAcessibilidade.PerfilAcessibilidadeDTORequest;
import BibliotecaInclusiva.AtivIndividual.DTO.PerfilAcessibilidade.PerfilAcessibilidadeDTOResponse;
import BibliotecaInclusiva.AtivIndividual.Domain.PerfilAcessibilidade;
import BibliotecaInclusiva.AtivIndividual.Domain.Usuario;
import BibliotecaInclusiva.AtivIndividual.Exception.ResourceNotFoundException;
import BibliotecaInclusiva.AtivIndividual.Repository.PerfilAcessibilidadeRepository;
import BibliotecaInclusiva.AtivIndividual.Repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PerfilAcessibilidadeService {

    @Autowired
    private PerfilAcessibilidadeRepository perfilAcessibilidadeRepository;

    @Autowired
    private UsuarioRepository usuarioRepository;

    public List<PerfilAcessibilidadeDTOResponse> buscar(){
        return perfilAcessibilidadeRepository.findAll()
                .stream()
                .map(PerfilAcessibilidadeDTOResponse::new)
                .toList();
    }

    public PerfilAcessibilidadeDTOResponse buscarID(Long id){
        return perfilAcessibilidadeRepository.findById(id)
                .map(PerfilAcessibilidadeDTOResponse::new)
                .orElseThrow(() -> new ResourceNotFoundException("Usuário não encontrado com id: " + id));
    }

    public PerfilAcessibilidadeDTOResponse adicionar(Long usuarioId, PerfilAcessibilidadeDTORequest perfil){

        Usuario usuario = usuarioRepository.findById(usuarioId)
                .orElseThrow(() -> new ResourceNotFoundException("Usuário não encontrado."));

        PerfilAcessibilidade perfilAcessibilidade = new PerfilAcessibilidade();
        perfilAcessibilidade.setDeficiencia(perfil.getDeficiencia());
        perfilAcessibilidade.setFormatoPreferido(perfil.getFormatoPreferido());
        perfilAcessibilidade.setTamanhoFonte(perfil.getTamanhoFonte());
        perfilAcessibilidade.setAltoContraste(perfil.isAltoContraste());
        perfilAcessibilidade.setLeitorTela(perfil.isLeitorTela());

        perfilAcessibilidade.setUsuario(usuario);
        usuario.setPerfilAcessibilidade(perfilAcessibilidade);
        perfilAcessibilidadeRepository.save(perfilAcessibilidade);
        return new PerfilAcessibilidadeDTOResponse(perfilAcessibilidade);
    }

    public PerfilAcessibilidadeDTOResponse atualizar(Long id, PerfilAcessibilidadeDTORequest perfil){
        PerfilAcessibilidade perfilAcessibilidade = perfilAcessibilidadeRepository
                .findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Usuário não encontrado com id: " + id));

        perfilAcessibilidade.setDeficiencia(perfil.getDeficiencia());
        perfilAcessibilidade.setFormatoPreferido(perfil.getFormatoPreferido());
        perfilAcessibilidade.setTamanhoFonte(perfil.getTamanhoFonte());
        perfilAcessibilidade.setAltoContraste(perfil.isAltoContraste());
        perfilAcessibilidade.setLeitorTela(perfil.isLeitorTela());

        perfilAcessibilidadeRepository.save(perfilAcessibilidade);
        return new PerfilAcessibilidadeDTOResponse(perfilAcessibilidade);
    }

    public void deletar(Long id){
        if (!perfilAcessibilidadeRepository.existsById(id)){
            throw new ResourceNotFoundException("Usuário não encontrado com id: " + id);
        }

        perfilAcessibilidadeRepository.deleteById(id);
    }
}

