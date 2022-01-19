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
@CrossOrigin(origins = "*", allowedHeaders = "*")
class PostagemController {
    @Autowired
    private PostagemRepository postagemRepository;


    @GetMapping
    public ResponseEntity<List<Postagem>> GetAll() {
        return ResponseEntity.ok(postagemRepository.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Postagem> getById(@PathVariable long id) {
        return postagemRepository.findById(id)
                .map(resp -> ResponseEntity.ok(resp))
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/titulo/{titulo}")
    public ResponseEntity<List<Postagem>> getByTitulo(@PathVariable String titulo){
        return ResponseEntity.ok(postagemRepository.findAllByTituloContainingIgnoreCase(titulo));
    }

    @PostMapping
    public ResponseEntity<Postagem> postPostagem (@Valid @RequestBody Postagem postagem){
        return ResponseEntity.status(HttpStatus.CREATED).body(postagemRepository.save(postagem));
    }

    @PutMapping
    public ResponseEntity<Postagem> putPostagem (@Valid @RequestBody Postagem postagem){

        return postagemRepository.findById(postagem.getId())
                .map(resposta -> ResponseEntity.ok().body(postagemRepository.save(postagem)))
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deletePostagem(@PathVariable long id) {

        return postagemRepository.findById(id)
                .map(resposta -> {
                    postagemRepository.deleteById(id);
                    return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
                })
                .orElse(ResponseEntity.notFound().build());
    }



}

