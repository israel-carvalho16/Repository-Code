package Crud.demo.C.Business;

import Crud.demo.C.Infra.Entity.Usuario;
import Crud.demo.C.Infra.Repo.UserRepo;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private final UserRepo repo;

    public UserService(UserRepo repo) {
        this.repo = repo;
    }

    public void salvaUsuario(Usuario usuario ){
        repo.saveAndFlush(usuario);
    }

    public Usuario BuscaUserEmail(String email){
        return repo.findByEmail(email).orElseThrow();
    }

    public void deletarUserEmail(String email){
        repo.deleteByEmail(email);
    }

    public void atualizarUserId(Integer id,String email, Usuario usuario){
        Usuario usuarioEntity = repo.findById(id).orElseThrow();
        Usuario usuarioAtualizado = new Usuario(usuario.getEmail() != null ? usuario.getEmail() : usuarioEntity.getEmail(), usuario.getNome() != null ? usuario.getNome() : usuarioEntity.getNome(), usuarioEntity.getId());
        repo.saveAndFlush(usuarioAtualizado);
    }
}
