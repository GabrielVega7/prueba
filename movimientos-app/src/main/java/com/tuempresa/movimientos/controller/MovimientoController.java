package com.tuempresa.movimientos.controller;

import com.tuempresa.movimientos.model.Movimiento;
import com.tuempresa.movimientos.service.MovimientoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

import com.tuempresa.movimientos.dto.MovimientoResumenDTO;

@RestController
@RequestMapping("/api/movimientos")

public class MovimientoController {
	@Autowired
    private MovimientoService movimientoService;
	
	
	// Endpoint para obtener el resumen de movimientos filtrado por estado
    @GetMapping("/resumen/{estado}")
    public ResponseEntity<List<MovimientoResumenDTO>> getResumenMovimientosPorEstado(@PathVariable String estado) {
        List<MovimientoResumenDTO> resumen = movimientoService.getResumenMovimientosPorEstado(estado);
        if (!resumen.isEmpty()) {
            return ResponseEntity.ok(resumen);
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }
	

    @GetMapping
    public List<Movimiento> getAllMovimientos() {
        return movimientoService.getAllMovimientos();
    }


 // Crear un movimiento con lista de detalles
    @PostMapping("/conDetalles")
    public ResponseEntity<Movimiento> createMovimientoConDetalles(@RequestBody Movimiento movimiento) {
        Movimiento savedMovimiento = movimientoService.saveMovimientoConDetalles(movimiento);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedMovimiento);
    }
    
    
    @PostMapping
    public ResponseEntity<Movimiento> createMovimiento(@RequestBody Movimiento movimiento) {
        Movimiento savedMovimiento = movimientoService.saveMovimiento(movimiento);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedMovimiento);
    }

    public ResponseEntity<Movimiento> updateMovimiento(@PathVariable Long id, @RequestBody Movimiento movimiento) {
        Optional<Movimiento> existingMovimiento = movimientoService.getMovimientoById(id);
        if (existingMovimiento.isPresent()) {
            Movimiento updatedMovimiento = existingMovimiento.get();
            
            updatedMovimiento.setDescripcion(movimiento.getDescripcion());
            updatedMovimiento.setBodegaOrigenCodigo(movimiento.getBodegaOrigenCodigo());
            updatedMovimiento.setBodegaDestinoCodigo(movimiento.getBodegaDestinoCodigo());
            updatedMovimiento.setFechaCreacion(movimiento.getFechaCreacion());
            updatedMovimiento.setFechaEntrega(movimiento.getFechaEntrega());
            updatedMovimiento.setEstado(movimiento.getEstado());

            return ResponseEntity.ok(movimientoService.saveMovimiento(updatedMovimiento));
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteMovimiento(@PathVariable Long id) {
        Optional<Movimiento> movimiento = movimientoService.getMovimientoById(id);
        if (movimiento.isPresent()) {
            movimientoService.deleteMovimiento(id);
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }
    
    
 // Buscar por ID
    @GetMapping("/{id}")
    public ResponseEntity<Movimiento> getMovimientoById(@PathVariable Long id) {
        Optional<Movimiento> movimiento = movimientoService.getMovimientoById(id);
        if (movimiento.isPresent()) {
            return ResponseEntity.ok(movimiento.get());
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }

    // Buscar por Estado
    @GetMapping("/estado/{estado}")
    public ResponseEntity<List<Movimiento>> getMovimientosByEstado(@PathVariable String estado) {
        List<Movimiento> movimientos = movimientoService.getMovimientosByEstado(estado);
        if (!movimientos.isEmpty()) {
            return ResponseEntity.ok(movimientos);
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }
}
