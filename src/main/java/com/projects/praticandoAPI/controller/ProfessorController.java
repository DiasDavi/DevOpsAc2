package com.projects.praticandoAPI.controller;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import com.projects.praticandoAPI.controller.dto.ProfessorDto;
import com.projects.praticandoAPI.controller.form.ProfessorForm;
import com.projects.praticandoAPI.modelo.Professor;
import com.projects.praticandoAPI.repository.ProfessorRepository;

@RestController
@CrossOrigin
@RequestMapping("/professores")
public class ProfessorController {

    @Autowired
    private ProfessorRepository professorRepository;

    @GetMapping
    public List<ProfessorDto> lista() {
        List<Professor> professores = professorRepository.findAll();
        return ProfessorDto.converter(professores);
    }

    @PostMapping
    public ResponseEntity<ProfessorDto> cadastrar(@RequestBody ProfessorForm form, UriComponentsBuilder uriBuilder) {
        Professor professor = form.converter();
        professorRepository.save(professor);

        URI uri = uriBuilder.path("/professores/{id}").buildAndExpand(professor.getId()).toUri();
        return ResponseEntity.created(uri).body(new ProfessorDto(professor));
    }
}