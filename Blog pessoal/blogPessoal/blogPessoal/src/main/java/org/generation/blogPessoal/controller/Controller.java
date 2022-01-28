package org.generation.blogPessoal.controller;

import java.util.List;

import org.generation.blogPessoal.model.*;
import org.generation.blogPessoal.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

import javax.validation.*;


@RestController
@RequestMapping("/postagens")
@CrossOrigin("*")
class PostagemController {
    @Autowired
    private PostagemRepository repository;


    @GetMapping
    public ResponseEntity<List<Postagem>> GetAll() {
        return ResponseEntity.ok(repository.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Postagem> getById(@PathVariable long id) {
        return repository.findById(id)
                .map(resposta -> ResponseEntity.ok(resposta))
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/titulo/{titulo}")
    public ResponseEntity<List<Postagem>> getByTitulo(@PathVariable String titulo){
        return ResponseEntity.ok(repository.findAllByTituloContainingIgnoreCase(titulo));
    }

    @PostMapping
    public ResponseEntity postPostagem (@Valid @RequestBody Postagem postagem){
        return ResponseEntity.status(HttpStatus.CREATED).body(repository.save(postagem));
    }

    @PutMapping
    public ResponseEntity<Postagem> putPostagem (@Valid @RequestBody Postagem postagem){

        return repository.findById(postagem.getId())
                .map(resposta -> ResponseEntity.ok().body(repository.save(postagem)))
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deletePostagem(@PathVariable long id) {

        return repository.findById(id)
                .map(resposta -> {
                    repository.deleteById(id);
                    return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
                })
                .orElse(ResponseEntity.notFound().build());
    }



}

