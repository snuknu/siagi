package sansuy.com.br.siagi.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import sansuy.com.br.siagi.model.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

    Usuario findOneByUsername(String username);
    
}
