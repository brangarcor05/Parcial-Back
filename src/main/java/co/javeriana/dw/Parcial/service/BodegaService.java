package co.javeriana.dw.Parcial.service;

import co.javeriana.dw.Parcial.dto.BodegaDto;
import co.javeriana.dw.Parcial.dto.BodegaRequest;
import co.javeriana.dw.Parcial.dto.ProductoDto;
import co.javeriana.dw.Parcial.entidad.Bodega;
import co.javeriana.dw.Parcial.repository.BodegaRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class BodegaService {

    private final BodegaRepository repo;

    public BodegaService(BodegaRepository repo) {
        this.repo = repo;
    }

    @Transactional
    public BodegaDto registrar(BodegaRequest req) {
        Bodega b = new Bodega(req.nombre(), req.ubicacion());
        return toDTO(repo.save(b));
    }

    @Transactional(readOnly = true)
    public List<BodegaDto> listar() {
        return repo.findAll().stream().map(this::toDTO).toList();
    }

    private BodegaDto toDTO(Bodega b) {
        List<ProductoDto> ps = b.getProductos().stream()
                .map(p -> new ProductoDto(
                        p.getId(),
                        p.getNombre(),
                        p.getDescripcion(),
                        p.getPrecio(),
                        p.getCantidad()))
                .toList();
        return new BodegaDto(b.getId(), b.getNombre(), b.getUbicacion(), ps);
    }
}