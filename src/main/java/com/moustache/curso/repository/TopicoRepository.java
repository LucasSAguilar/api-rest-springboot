package com.moustache.curso.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import com.moustache.curso.models.Topico;

public interface TopicoRepository extends JpaRepository<Topico, Long> {

    List<Topico> findByCursoNome(String nomeCurso);

}
