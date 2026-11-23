package co.javeriana.dw.Parcial.dto;

import java.math.BigDecimal;

public record ProductoDto(
        Long id,
        String nombre,
        String descripcion,
        BigDecimal precio,
        Integer cantidad
) {}