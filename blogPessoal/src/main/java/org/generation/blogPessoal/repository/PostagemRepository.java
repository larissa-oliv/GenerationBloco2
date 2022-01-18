package org.generation.blogPessoal.repository;

import org.generation.blogPessoal.model.*;
import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.*;

@org.springframework.stereotype.Repository
public interface PostagemRepository extends JpaRepository<Postagem, Long> {
}
