package co.javeriana.dw.Parcial.controller;

import co.javeriana.dw.Parcial.dto.BodegaDto;
import co.javeriana.dw.Parcial.dto.BodegaRequest;
import co.javeriana.dw.Parcial.service.BodegaService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import jakarta.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/bodegas")
@CrossOrigin(origins = {"http://localhost:4200", "http://localhost:5173"})
public class BodegaController {

    private final BodegaService service;

    public BodegaController(BodegaService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<BodegaDto> registrar(@Valid @RequestBody BodegaRequest req) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.registrar(req));
    }

    @GetMapping
    public List<BodegaDto> listar() {
        return service.listar();
    }
}