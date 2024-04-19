package com.moustache.curso.dto;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

import com.moustache.curso.models.Topico;

public class TopicoDto {
    private Long id;
    private String titulo;
    private String mensagem;
    private LocalDateTime dataCriacao;

    public TopicoDto(Topico topico) {
        this.id = topico.getId();
        this.titulo = topico.getTitulo();
        this.mensagem = topico.getMensagem();
        this.dataCriacao = topico.getDataCriacao();
    }

    public Long getId() {
        return this.id;
    }

    public String getTitulo() {
        return this.titulo;
    }

    public String getMensagem() {
        return this.mensagem;
    }

    public LocalDateTime getDataCriacao() {
        return this.dataCriacao;
    }
    

    public static List<TopicoDto> converterParaDto(List<Topico> topicos) {
        return topicos.stream().map(TopicoDto::new).collect(Collectors.toList());
    }

}
