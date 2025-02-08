package com.tuempresa.movimientos.service;

import com.tuempresa.movimientos.model.Movimiento;
import com.tuempresa.movimientos.model.MovimientoDetalle;
import com.tuempresa.movimientos.repository.MovimientoDetalleRepository;
import com.tuempresa.movimientos.repository.MovimientoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

import com.tuempresa.movimientos.dto.MovimientoResumenDTO;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class MovimientoService {
	@Autowired
    private MovimientoRepository movimientoRepository;

	@Autowired
    private MovimientoDetalleRepository movimientoDetalleRepository;
	
	public List<MovimientoResumenDTO> getResumenMovimientosPorEstado(String estado) {
        List<Movimiento> movimientos = movimientoRepository.findByEstado(estado);

        return movimientos.stream()
                .flatMap(movimiento -> movimiento.getDetalles().stream()
                        .map(detalle -> new MovimientoResumenDTO(
                                movimiento.getId(),
                                detalle.getId(),
                                movimiento.getBodegaOrigenCodigo(),
                                movimiento.getIdEmpresa(),
                                movimiento.getBodegaDestinoCodigo(),
                                detalle.getItemCodigo()
                        )))
                .collect(Collectors.toList());
    }
	
	

    public Movimiento saveMovimientoConDetalles(Movimiento movimiento) {
        // Asocia los detalles al movimiento
        for (MovimientoDetalle detalle : movimiento.getDetalles()) {
            detalle.setMovimiento(movimiento);
        }
        // Guarda el movimiento con los detalles
        return movimientoRepository.save(movimiento);
    }
	
	
	
    public List<Movimiento> getAllMovimientos() {
        return movimientoRepository.findAll();
    }

    public Optional<Movimiento> getMovimientoById(Long id) {
        return movimientoRepository.findById(id);
    }

    public Movimiento saveMovimiento(Movimiento movimiento) {
        return movimientoRepository.save(movimiento);
    }

    public void deleteMovimiento(Long id) {
        movimientoRepository.deleteById(id);
    }
    

    // Obtener Movimientos por Estado
    public List<Movimiento> getMovimientosByEstado(String estado) {
        return movimientoRepository.findByEstado(estado);  // Asegúrate de que este método esté bien definido
    }
    
 // Obtener Movimientos por ID
    public List<Movimiento> getMovimientosByIDD(int id) {
        return movimientoRepository.findById(id);  // Asegúrate de que este método esté bien definido
    }
}
