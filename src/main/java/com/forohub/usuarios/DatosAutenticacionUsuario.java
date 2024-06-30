package com.forohub.usuarios;

import jakarta.validation.constraints.NotNull;

public record DatosAutenticacionUsuario(@NotNull String login,@NotNull String clave) {
}
