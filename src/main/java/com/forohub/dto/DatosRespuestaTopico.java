package com.forohub.dto;

import java.time.LocalDateTime;

public record DatosRespuestaTopico(Long id, String mensaje, String nombreCurso, String titulo, String autor, LocalDateTime fechaCreacion) {
}
