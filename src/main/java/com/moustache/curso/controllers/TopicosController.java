package com.moustache.curso.controllers;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.moustache.curso.dto.DetalhesDoTopicoDto;
import com.moustache.curso.dto.TopicoDto;
import com.moustache.curso.form.AtualizarTopicoForm;
import com.moustache.curso.form.TopicoForm;
import com.moustache.curso.models.Topico;
import com.moustache.curso.repository.CursoRepository;
import com.moustache.curso.repository.TopicoRepository;

import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.PutMapping;

@RestController
@RequestMapping("/topicos")
public class TopicosController {

    @Autowired
    private TopicoRepository topicoRepository;
    @Autowired
    private CursoRepository cursoRepository;

    @GetMapping
    public List<TopicoDto> coletarLista(String nomeCurso) {

        List<Topico> topicos;

        if (nomeCurso == null) {
            topicos = topicoRepository.findAll();
        } else {

            // Para buscar por nome do curso, é necessário criar um método no repositório
            // A convenção do Spring Data é findBy + nome do atributo
            // Caso seja um atributo de outra classe, é necessário usar o nome do atributo +
            // nome do atributo da outra classe

            // Exemplos: findByNome | Isso vai procurar por um atributo chamado nome
            // Exemplos: findByPessoasNome | caso tenha um atribudo Pessoa que é uma outra
            // classe, ele vai procurar por um atributo chamado nome dentro da classe Pessoa

            topicos = topicoRepository.findByCursoNome(nomeCurso);

            // Também é possível usar o underline para separar os atributos, exemplo:
            // topicos = topicoRepository.findByCurso_Nome(nomeCurso);
        }

        return TopicoDto.converterParaDto(topicos);
    }

    @PostMapping
    @Transactional
    public ResponseEntity<TopicoDto> cadastrar(@RequestBody @Valid TopicoForm form, UriComponentsBuilder uriBuilder) {
        Topico topico = form.formatarParaTopico(cursoRepository);
        topicoRepository.save(topico);

        URI uri = uriBuilder.path("/topicos/{id}").buildAndExpand(topico.getId()).toUri();
        return ResponseEntity.created(uri).body(new TopicoDto(topico));

    }

    @GetMapping("/{id}")
    public ResponseEntity<DetalhesDoTopicoDto> selecionarUm(@PathVariable Long id) {
        Optional<Topico> topico = topicoRepository.findById(id);
        if (topico.isPresent()) {
            return ResponseEntity.ok(new DetalhesDoTopicoDto(topico.get()));
        }

        return ResponseEntity.notFound().build();
    }

    @PutMapping("/{id}")
    @Transactional
    public ResponseEntity<TopicoDto> atualizarTopico(@PathVariable Long id,
            @RequestBody @Valid AtualizarTopicoForm novosDados) {

        Optional<Topico> topico = topicoRepository.findById(id);

        if (topico.isPresent()) {
            Topico topicoAlterado = novosDados.atualizar(id, topicoRepository);
            return ResponseEntity.ok(new TopicoDto(topicoAlterado));
        }

        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity<?> deletarTopico(@PathVariable Long id) {

        Optional<Topico> topico = topicoRepository.findById(id);

        if (topico.isPresent()) {
            topicoRepository.deleteById(id);
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.notFound().build();
    }

}
