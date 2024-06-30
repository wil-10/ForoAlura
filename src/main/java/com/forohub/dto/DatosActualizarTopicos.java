package com.forohub.dto;

import jakarta.validation.constraints.NotNull;

public record DatosActualizarTopicos(Long id, String mensaje, String nombreCurso, String titulo, String autor) {
}
