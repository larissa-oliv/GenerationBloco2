package org.generation.blogPessoal.repository;

import org.generation.blogPessoal.model.*;
import org.springframework.data.jpa.repository.*;

import java.util.*;

public interface TemaRepository extends JpaRepository<Tema, Long> {
    public List<Tema> findAllByDescricaoContainingIgnoreCase(String descricao);
}
