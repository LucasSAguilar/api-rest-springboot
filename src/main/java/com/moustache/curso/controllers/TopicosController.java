package com.moustache.curso.controllers;

import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.moustache.curso.dto.TopicoDto;
import com.moustache.curso.models.Curso;
import com.moustache.curso.models.Topico;

@RestController
public class TopicosController {

    @RequestMapping("/topicos")
    public List<TopicoDto> coletarLista() {
        Topico topico = new Topico("Dúvidas", "Dúvida com Spring boot", new Curso("Spring boot", "Programação"));

        return TopicoDto.converterParaDto(Arrays.asList(topico, topico, topico));
    }

}
