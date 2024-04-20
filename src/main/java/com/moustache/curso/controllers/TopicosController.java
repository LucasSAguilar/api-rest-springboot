package com.moustache.curso.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.moustache.curso.dto.TopicoDto;
import com.moustache.curso.models.Topico;
import com.moustache.curso.repository.TopicoRepository;

@RestController
public class TopicosController {

    @Autowired
    private TopicoRepository topicoRepository;

    @RequestMapping("/topicos")
    public List<TopicoDto> coletarLista() {
        List<Topico> topicos = topicoRepository.findAll();
        return TopicoDto.converterParaDto(topicos);
    }

}
