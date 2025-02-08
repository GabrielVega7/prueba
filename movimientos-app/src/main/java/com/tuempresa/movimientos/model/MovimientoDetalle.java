package com.tuempresa.movimientos.model;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.*;
import lombok.Data;


@Data
@Entity
@Table(name = "movimiento_detalle", schema = "testswisslub") // El esquema se define aquí
public class MovimientoDetalle {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;  // columna id

	@ManyToOne
    @JoinColumn(name = "movimiento_id")
    @JsonBackReference
    private Movimiento movimiento;

    @Column(name = "item_codigo")
    private String itemCodigo;  // columna item_codigo

    @Column(name = "cantidad_enviada")
    private Integer cantidadEnviada;  // columna cantidad_enviada

    // Getter y Setter para id
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    // Getter y Setter para movimiento
    public Movimiento getMovimiento() {
        return movimiento;
    }

    public void setMovimiento(Movimiento movimiento) {
        this.movimiento = movimiento;
    }

    // Getter y Setter para itemCodigo
    public String getItemCodigo() {
        return itemCodigo;
    }

    public void setItemCodigo(String itemCodigo) {
        this.itemCodigo = itemCodigo;
    }

    // Getter y Setter para cantidadEnviada
    public Integer getCantidadEnviada() {
        return cantidadEnviada;
    }

    public void setCantidadEnviada(Integer cantidadEnviada) {
        this.cantidadEnviada = cantidadEnviada;
    }
}
