package Crud.demo.C.Infra.Repo;

import Crud.demo.C.Infra.Entity.Usuario;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepo extends JpaRepository<Usuario,Integer> {
    Optional<Usuario> findByEmail(String email);
    @Transactional
    void deleteByEmail(String email);
}
