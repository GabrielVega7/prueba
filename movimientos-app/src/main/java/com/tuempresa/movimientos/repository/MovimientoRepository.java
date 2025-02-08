package com.tuempresa.movimientos.repository;

import com.tuempresa.movimientos.model.Movimiento;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface MovimientoRepository extends JpaRepository<Movimiento, Long> {
	List<Movimiento> findByEstado(String estado);  // Método para buscar por estado
	List<Movimiento> findById(int id);  // Método para buscar por ID
	
}
