package com.projects.praticandoAPI.controller.form;

import com.projects.praticandoAPI.modelo.Professor;

public class ProfessorForm {

    private String nome;
    private String disciplina;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDisciplina() {
        return disciplina;
    }

    public void setDisciplina(String disciplina) {
        this.disciplina = disciplina;
    }

    public Professor converter() {
        return new Professor(nome, disciplina);
    }
}