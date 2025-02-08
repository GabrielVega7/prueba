package com.tuempresa.movimientos.service;

import com.tuempresa.movimientos.model.MovimientoDetalle;
import com.tuempresa.movimientos.repository.MovimientoDetalleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service

public class MovimientoDetalleService {
	@Autowired
    private MovimientoDetalleRepository movimientoDetalleRepository;

    public List<MovimientoDetalle> getAllMovimientoDetalles() {
        return movimientoDetalleRepository.findAll();
    }

    public MovimientoDetalle saveMovimientoDetalle(MovimientoDetalle movimientoDetalle) {
        return movimientoDetalleRepository.save(movimientoDetalle);
    }

    public void deleteMovimientoDetalle(Long id) {
        movimientoDetalleRepository.deleteById(id);
    }
    
 // Buscar por ID
    public Optional<MovimientoDetalle> getMovimientoDetalleById(Long id) {
        return movimientoDetalleRepository.findById(id);
    }

    // Buscar por Estado
//    public List<MovimientoDetalle> getMovimientoDetalleByEstado(String estado) {
//        return movimientoDetalleRepository.findByEstado(estado);
//    }

    // Buscar por movimiento_id
    public List<MovimientoDetalle> getMovimientoDetalleByMovimientoId(Long movimientoId) {
        return movimientoDetalleRepository.findByMovimientoId(movimientoId);
    }
}
