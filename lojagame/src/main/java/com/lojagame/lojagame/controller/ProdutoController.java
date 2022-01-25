package com.lojagame.lojagame.controller;


import com.lojagame.lojagame.Model.*;
import com.lojagame.lojagame.repository.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

import javax.validation.*;
import java.math.*;
import java.util.*;

@RestController
@RequestMapping("/produtos")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class ProdutoController {

    @Autowired
    private ProdutoRepository produtoRepository;

    @Autowired
    private CategoriaRepository categoriaRepository;

    @GetMapping
    public ResponseEntity<List<Produto>> getAll(){
        return ResponseEntity.ok(produtoRepository.findAll());
    }
    @GetMapping("/{id}")
    public ResponseEntity<Produto> getById(@PathVariable Long id){
        return produtoRepository.findById(id)
                .map(resp-> ResponseEntity.ok(resp))
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/nome/{nome}")
    public ResponseEntity<List<Produto>> getByNome(@PathVariable String nome){
        return ResponseEntity.ok(produtoRepository.findAllByNomeContainingIgnoreCase(nome));
    }

    @PostMapping
    public ResponseEntity<Produto> postProduto(@Valid @RequestBody Produto produto){
        return categoriaRepository.findById(produto.getCategoria().getId())
                .map(resposta -> {
                    return ResponseEntity.status(HttpStatus.CREATED).body(produtoRepository.save(produto));
                })
                .orElse(ResponseEntity.badRequest().build());
    }

    @PutMapping
    public ResponseEntity<Produto> putProduto(@Valid @RequestBody Produto produto) {

        if (produtoRepository.existsById(produto.getId())){

            return categoriaRepository.findById(produto.getCategoria().get())
                    .map(resposta -> {
                        return ResponseEntity.status(HttpStatus.OK).body(produtoRepository.save(produto));
                    })
                    .orElse(ResponseEntity.badRequest().build());
        }

        return ResponseEntity.notFound().build();

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteProduto(@PathVariable Long id) {

        return produtoRepository.findById(id)
                .map(resposta -> {
                    produtoRepository.deleteById(id);
                    return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
                })
                .orElse(ResponseEntity.notFound().build());
    }

    // Consulta pelo preço maior do que o preço digitado emm ordem crescente

    @GetMapping("/preco_maior/{preco}")
    public ResponseEntity<List<Produto>> getPrecoMaiorQue(@PathVariable BigDecimal preco){
        return ResponseEntity.ok(produtoRepository.findByPrecoGreaterThanOrderByPreco(preco));
    }

    // Consulta pelo preço menor do que o preço digitado em ordem decrescente

    @GetMapping("/preco_menor/{preco}")
    public ResponseEntity<List<Produto>> getPrecoMenorQue(@PathVariable BigDecimal preco){
        return ResponseEntity.ok(produtoRepository.findByPrecoLessThanOrderByPrecoDesc(preco));
    }

}