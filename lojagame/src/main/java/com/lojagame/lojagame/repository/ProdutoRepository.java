package com.lojagame.lojagame.repository;

import com.lojagame.lojagame.Model.*;
import org.springframework.data.jpa.repository.*;

import java.math.*;
import java.util.*;

public interface ProdutoRepository extends JpaRepository<Produto, Long> {
    public List<Produto> findAllByDescricaoContainingIgnoreCase(String descricao);

    public List <Produto> findByPrecoGreaterThanOrderByPreco(BigDecimal preco);

    public List <Produto> findByPrecoLessThanOrderByPrecoDesc(BigDecimal preco);
}