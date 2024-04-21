package com.moustache.curso.config.validacao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.moustache.curso.dto.ErroFormDto;

// Isso serve para que o Spring saiba que essa classe é um interceptador de exceções
// ou seja, ele vai interceptar as exceções que acontecerem na aplicação
@RestControllerAdvice

public class ErroValidacaoHandler {
    // Método que vai lidar com a exceção MethodArgumentNotValidException
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public List<ErroFormDto> lidar(MethodArgumentNotValidException exception) {

        List<ErroFormDto> listaDeErroDTO = new ArrayList<>();

        // getBindingResult(): retorna o resultado da validação
        // getFieldErrors(): retorna os erros de campo
        List<FieldError> fieldErros = exception.getBindingResult().getFieldErrors();

        fieldErros.forEach(e -> {
            String campo = e.getField();
            String erro = e.getDefaultMessage();
            ErroFormDto erroFormDto = new ErroFormDto(campo, erro);
            listaDeErroDTO.add(erroFormDto);
        });

        return listaDeErroDTO;
    }
}
