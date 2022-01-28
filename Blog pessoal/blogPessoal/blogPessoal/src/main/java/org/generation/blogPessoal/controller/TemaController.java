package org.generation.blogPessoal.controller;

import org.generation.blogPessoal.model.*;
import org.generation.blogPessoal.repository.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("/tema")
public class TemaController {
    @Autowired
    private TemaRepository repository;

    @GetMapping
    public ResponseEntity<List<Tema>> getAll (){
        return ResponseEntity.ok(repository.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Tema> getById(@PathVariable long id){
        return repository.findById(id).map(resposta -> ResponseEntity.ok(resposta))
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping ("/nome/{nome}")
    public ResponseEntity<List<Tema>> getByName(@PathVariable String nome){
        return ResponseEntity.ok(repository.findAllByDescricaoContainingIgnoreCase(nome));
    }

    @PostMapping
    public ResponseEntity<Tema> post(@RequestBody Tema tema){
        return ResponseEntity.status(HttpStatus.CREATED).body(repository.save(tema));
    }

    @PutMapping
    public ResponseEntity<Tema> put(@RequestBody Tema tema){
        return ResponseEntity.ok(repository.save(tema));
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable long id){
        repository.deleteById(id);
    }
}
