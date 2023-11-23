package com.projects.praticandoAPI.controller;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import com.projects.praticandoAPI.controller.dto.ComentarioDto;
import com.projects.praticandoAPI.controller.form.ComentarioForm;
import com.projects.praticandoAPI.modelo.Comentario;
import com.projects.praticandoAPI.repository.ComentarioRepository;

@RestController
@CrossOrigin
@RequestMapping("/comentarios")
public class ComentarioController {

    @Autowired
    private ComentarioRepository comentarioRepository;

    @GetMapping
    public List<ComentarioDto> lista() {
        List<Comentario> comentarios = comentarioRepository.findAll();
        return ComentarioDto.converter(comentarios);
    }

    @PostMapping
    public ResponseEntity<ComentarioDto> cadastrar(@RequestBody ComentarioForm form, UriComponentsBuilder uriBuilder) {
        Comentario comentario = form.converter();
        comentarioRepository.save(comentario);

        URI uri = uriBuilder.path("/comentarios/{id}").buildAndExpand(comentario.getId()).toUri();
        return ResponseEntity.created(uri).body(new ComentarioDto(comentario));
    }
}