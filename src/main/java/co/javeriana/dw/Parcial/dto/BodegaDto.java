package co.javeriana.dw.Parcial.dto;

import java.util.List;

public record BodegaDto(
        Long id,
        String nombre,
        String ubicacion,
        List<ProductoDto> productos
) {}