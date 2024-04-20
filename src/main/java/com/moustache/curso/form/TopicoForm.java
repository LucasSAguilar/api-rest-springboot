package com.moustache.curso.form;

import com.moustache.curso.models.Curso;
import com.moustache.curso.models.Topico;
import com.moustache.curso.repository.CursoRepository;

public class TopicoForm {
    private String titulo;
    private String mensagem;
    private String nomeCurso;


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

    public String getNomeCurso() {
        return this.nomeCurso;
    }

    public void setNomeCurso(String nomeCurso) {
        this.nomeCurso = nomeCurso;
    }


    public Topico formatarParaTopico(CursoRepository cursoRepository) {
        Curso curso = cursoRepository.findByNome(nomeCurso);
        return new Topico(titulo, mensagem, curso);
    }
}
