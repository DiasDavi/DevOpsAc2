package com.projects.praticandoAPI.controller.dto;

import com.projects.praticandoAPI.modelo.Comentario;

import java.util.List;
import java.util.stream.Collectors;

public class ComentarioDto {

    private Long id;
    private String conteudo;
    private String autor;

    public ComentarioDto(Comentario comentario) {
        this.id = comentario.getId();
        this.conteudo = comentario.getConteudo();
        this.autor = comentario.getAutor();
    }

    public Long getId() {
        return id;
    }

    public String getConteudo() {
        return conteudo;
    }

    public String getAutor() {
        return autor;
    }

    public static List<ComentarioDto> converter(List<Comentario> comentarios) {
        return comentarios.stream().map(ComentarioDto::new).collect(Collectors.toList());
    }
}