package co.javeriana.dw.Parcial.config;

import co.javeriana.dw.Parcial.entidad.Bodega;
import co.javeriana.dw.Parcial.entidad.Producto;
import co.javeriana.dw.Parcial.repository.BodegaRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
public class DataInitializer implements CommandLineRunner {

    private final BodegaRepository bodegaRepo;

    public DataInitializer(BodegaRepository bodegaRepo) {
        this.bodegaRepo = bodegaRepo;
    }

    @Override
    public void run(String... args) {
        if (bodegaRepo.count() > 0) return; 

        Bodega norte = new Bodega("Bodega Norte", "Zona Industrial Norte");
        Bodega sur = new Bodega("Bodega Sur", "Zona Industrial Sur");

        norte.addProducto(new Producto("Computador portátil",
                "Laptop 15 pulgadas", new BigDecimal("2500000"), 15));
        norte.addProducto(new Producto("Monitor",
                "Monitor 24 pulgadas", new BigDecimal("750000"), 20));
        sur.addProducto(new Producto("Impresora",
                "Impresora láser", new BigDecimal("1200000"), 8));

        bodegaRepo.save(norte);
        bodegaRepo.save(sur);
    }
}