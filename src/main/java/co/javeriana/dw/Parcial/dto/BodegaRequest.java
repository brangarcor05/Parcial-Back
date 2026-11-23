package co.javeriana.dw.Parcial.dto;

import jakarta.validation.constraints.NotBlank;

public record BodegaRequest(
        @NotBlank String nombre,
        @NotBlank String ubicacion
) {}