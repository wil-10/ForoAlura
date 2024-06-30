package com.forohub.dto;

import jakarta.validation.constraints.NotBlank;


public record DatosTopico(Long id, @NotBlank String mensaje, @NotBlank  String nombreCurso, @NotBlank  String titulo, @NotBlank  String autor) {
}
