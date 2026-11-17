package com.javanauta.apredendospring.Infrastructure.Repository;

import com.javanauta.apredendospring.Infrastructure.Entity.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

    Boolean existsByEmail(String email);

    Optional<Usuario> findByEmail(String email);
}
