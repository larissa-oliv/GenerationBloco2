package org.generation.blogPessoal.repository;

import org.generation.blogPessoal.model.*;
import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.*;

import java.util.*;

@Repository
public interface PostagemRepository extends JpaRepository<Postagem, Long> {

    public List <Postagem> findAllByTituloContainingIgnoreCase(String titulo);


}


