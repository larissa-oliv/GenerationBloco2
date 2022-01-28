package org.generation.blogPessoal.repository;

import org.generation.blogPessoal.model.*;
import org.springframework.data.jpa.repository.*;

import java.util.*;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

    public Optional<Usuario> findByUsuario(String usuario);
}
