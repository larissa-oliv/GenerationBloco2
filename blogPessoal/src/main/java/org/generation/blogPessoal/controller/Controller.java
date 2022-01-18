package org.generation.blogPessoal.controller;

import java.util.List;

import org.generation.blogPessoal.model.*;
import org.generation.blogPessoal.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/postagens")
@CrossOrigin(origins = "*", allowedHeaders = "*")
class PostagemController {
    @Autowired
    private PostagemRepository postagemRepository;
    @GetMapping
    public ResponseEntity<List<Postagem>> getAll (){
        return ResponseEntity.ok(postagemRepository.findAll());
    }}