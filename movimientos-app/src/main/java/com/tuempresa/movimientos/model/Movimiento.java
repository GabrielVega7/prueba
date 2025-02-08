package com.tuempresa.movimientos.model;

import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDateTime;
import java.util.List;


import com.fasterxml.jackson.annotation.JsonManagedReference;

@Data
@Entity
@Table(name = "movimiento", schema = "testswisslub") // El esquema se define aquí

public class Movimiento {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;  

    @Column(name = "id_empresa")
    private Integer idEmpresa;

    @Column(name = "descripcion")
    private String descripcion;

    @Column(name = "bodega_origen_codigo")
    private String bodegaOrigenCodigo;

    @Column(name = "bodega_destino_codigo")
    private String bodegaDestinoCodigo;

    @Column(name = "fecha_creacion")
    private LocalDateTime fechaCreacion;

    @Column(name = "fecha_entrega")
    private LocalDateTime fechaEntrega;

    @Column(name = "estado")
    private String estado;

    @OneToMany(mappedBy = "movimiento", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JsonManagedReference
    private List<MovimientoDetalle> detalles;

    // Getters y Setters manuales
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getIdEmpresa() {
        return idEmpresa;
    }

    public void setIdEmpresa(Integer idEmpresa) {
        this.idEmpresa = idEmpresa;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getBodegaOrigenCodigo() {
        return bodegaOrigenCodigo;
    }

    public void setBodegaOrigenCodigo(String bodegaOrigenCodigo) {
        this.bodegaOrigenCodigo = bodegaOrigenCodigo;
    }

    public String getBodegaDestinoCodigo() {
        return bodegaDestinoCodigo;
    }

    public void setBodegaDestinoCodigo(String bodegaDestinoCodigo) {
        this.bodegaDestinoCodigo = bodegaDestinoCodigo;
    }

    public LocalDateTime getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(LocalDateTime fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public LocalDateTime getFechaEntrega() {
        return fechaEntrega;
    }

    public void setFechaEntrega(LocalDateTime fechaEntrega) {
        this.fechaEntrega = fechaEntrega;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public List<MovimientoDetalle> getDetalles() {
        return detalles;
    }

    public void setDetalles(List<MovimientoDetalle> detalles) {
        this.detalles = detalles;
    }
}
