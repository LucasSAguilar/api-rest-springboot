package com.moustache.curso.form;

import com.moustache.curso.models.Topico;
import com.moustache.curso.repository.TopicoRepository;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

public class AtualizarTopicoForm {
    @NotNull
    @NotEmpty
    private String titulo;

    @NotNull
    @NotEmpty
    private String mensagem;

    public String getTitulo() {
        return this.titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getMensagem() {
        return this.mensagem;
    }

    public void setMensagem(String mensagem) {
        this.mensagem = mensagem;
    }

    public Topico atualizar(Long id, TopicoRepository topicoRepository) {
        Topico topico = topicoRepository.findById(id).get();
        topico.setTitulo(this.titulo);
        topico.setMensagem(this.mensagem);
        return topico;
    }

}
