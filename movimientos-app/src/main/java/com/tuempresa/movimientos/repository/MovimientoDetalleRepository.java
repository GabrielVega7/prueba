package com.tuempresa.movimientos.repository;

import com.tuempresa.movimientos.model.MovimientoDetalle;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface MovimientoDetalleRepository extends JpaRepository<MovimientoDetalle, Long> {
	// Buscar MovimientoDetalle por estado
//    List<MovimientoDetalle> findByEstado(String estado);

    // Buscar MovimientoDetalle por movimiento_id
    List<MovimientoDetalle> findByMovimientoId(Long movimientoId);
}
