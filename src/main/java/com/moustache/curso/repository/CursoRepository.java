package com.moustache.curso.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.moustache.curso.models.Curso;

public interface CursoRepository extends JpaRepository<Curso, Long> {
    Curso findByNome(String nome);
}
