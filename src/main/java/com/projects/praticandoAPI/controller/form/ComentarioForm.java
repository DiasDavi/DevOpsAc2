package com.projects.praticandoAPI.controller.form;

import com.projects.praticandoAPI.modelo.Comentario;
import com.projects.praticandoAPI.modelo.Professor;

public class ComentarioForm {

    private String conteudo;
    private String autor;

    public String getConteudo() {
        return conteudo;
    }

    public void setConteudo(String conteudo) {
        this.conteudo = conteudo;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }
    
    public Comentario converter() {
        return new Comentario(conteudo, autor);
    }
}