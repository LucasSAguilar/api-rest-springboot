package com.moustache.curso.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.moustache.curso.models.Topico;

public interface TopicoRepository extends JpaRepository<Topico, Long> {

}
