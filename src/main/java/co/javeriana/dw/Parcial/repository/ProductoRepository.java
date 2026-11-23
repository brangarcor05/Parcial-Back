package co.javeriana.dw.Parcial.repository;

import co.javeriana.dw.Parcial.entidad.Producto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductoRepository extends JpaRepository<Producto, Long> {}