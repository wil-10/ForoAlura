package com.forohub.repository;

import com.forohub.topicos.Topico;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RegistroTopicoRepository extends JpaRepository<Topico,Long> {
}
