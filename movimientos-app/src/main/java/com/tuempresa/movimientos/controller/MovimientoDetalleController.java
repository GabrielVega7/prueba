package com.tuempresa.movimientos.controller;

import com.tuempresa.movimientos.model.MovimientoDetalle;
import com.tuempresa.movimientos.service.MovimientoDetalleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/movimientoDetalles")

public class MovimientoDetalleController {
	@Autowired
    private MovimientoDetalleService movimientoDetalleService;

    @GetMapping
    public List<MovimientoDetalle> getAllMovimientoDetalles() {
        return movimientoDetalleService.getAllMovimientoDetalles();
    }


    @PostMapping
    public ResponseEntity<MovimientoDetalle> createMovimientoDetalle(@RequestBody MovimientoDetalle movimientoDetalle) {
        MovimientoDetalle savedMovimientoDetalle = movimientoDetalleService.saveMovimientoDetalle(movimientoDetalle);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedMovimientoDetalle);
    }

    @PutMapping("/{id}")
    public ResponseEntity<MovimientoDetalle> updateMovimientoDetalle(@PathVariable Long id, @RequestBody MovimientoDetalle movimientoDetalle) {
        Optional<MovimientoDetalle> existingMovimientoDetalle = movimientoDetalleService.getMovimientoDetalleById(id);
        if (existingMovimientoDetalle.isPresent()) {
            MovimientoDetalle updatedMovimientoDetalle = existingMovimientoDetalle.get();
            updatedMovimientoDetalle.setItemCodigo(movimientoDetalle.getItemCodigo());
            updatedMovimientoDetalle.setCantidadEnviada(movimientoDetalle.getCantidadEnviada());
            
            // No es necesario setear el ID si ya existe
            return ResponseEntity.ok(movimientoDetalleService.saveMovimientoDetalle(updatedMovimientoDetalle));
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteMovimientoDetalle(@PathVariable Long id) {
        Optional<MovimientoDetalle> movimientoDetalle = movimientoDetalleService.getMovimientoDetalleById(id);
        if (movimientoDetalle.isPresent()) {
            movimientoDetalleService.deleteMovimientoDetalle(id);
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }
    
    
 // Buscar por ID
    @GetMapping("/{id}")
    public ResponseEntity<MovimientoDetalle> getMovimientoDetalleById(@PathVariable Long id) {
        Optional<MovimientoDetalle> detalle = movimientoDetalleService.getMovimientoDetalleById(id);
        return detalle.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND).build());
    }

    // Buscar por Estado
//    @GetMapping("/estado/{estado}")
//    public ResponseEntity<List<MovimientoDetalle>> getMovimientoDetalleByEstado(@PathVariable String estado) {
//        List<MovimientoDetalle> detalles = movimientoDetalleService.getMovimientoDetalleByEstado(estado);
//        if (!detalles.isEmpty()) {
//            return ResponseEntity.ok(detalles);
//        }
//        return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
//    }

    // Buscar por movimiento_id
    @GetMapping("/movimiento/{movimientoId}")
    public ResponseEntity<List<MovimientoDetalle>> getMovimientoDetalleByMovimientoId(@PathVariable Long movimientoId) {
        List<MovimientoDetalle> detalles = movimientoDetalleService.getMovimientoDetalleByMovimientoId(movimientoId);
        if (!detalles.isEmpty()) {
            return ResponseEntity.ok(detalles);
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }
}
