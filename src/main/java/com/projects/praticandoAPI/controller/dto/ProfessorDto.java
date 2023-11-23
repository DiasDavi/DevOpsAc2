package com.projects.praticandoAPI.controller.dto;

import com.projects.praticandoAPI.modelo.Professor;

import java.util.List;
import java.util.stream.Collectors;

public class ProfessorDto {

    private Long id;
    private String nome;
    private String disciplina;

    public ProfessorDto(Professor professor) {
        this.id = professor.getId();
        this.nome = professor.getNome();
        this.disciplina = professor.getDisciplina();
    }

    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getDisciplina() {
        return disciplina;
    }

    public static List<ProfessorDto> converter(List<Professor> professores) {
        return professores.stream().map(ProfessorDto::new).collect(Collectors.toList());
    }
}