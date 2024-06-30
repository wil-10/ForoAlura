package com.forohub.dto;

import com.forohub.topicos.Topico;
import jakarta.validation.constraints.NotBlank;

import java.sql.Timestamp;
import java.time.LocalDateTime;

public record DatosMostrarTopicos(Long id, String mensaje, String nombreCurso, String titulo, String autor, LocalDateTime fechaCreacion) {

    public DatosMostrarTopicos(Topico topico){
         this(topico.getId(),topico.getMensaje(),topico.getNombreCurso(),topico.getTitulo(),topico.getAutor(),topico.getFecha());

    }

}
