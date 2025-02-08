package com.tuempresa.movimientos.dto;

public class MovimientoResumenDTO {
	private Long movimientoId;
    private Long movimientoDetalleId;
    private String bodegaOrigenCodigo;
    private Integer empresa;
    private String bodegaDestinoCodigo;
    private String itemCodigo;

    // Constructor
    public MovimientoResumenDTO(Long movimientoId, Long movimientoDetalleId, String bodegaOrigenCodigo, Integer empresa, String bodegaDestinoCodigo, String itemCodigo) {
        this.movimientoId = movimientoId;
        this.movimientoDetalleId = movimientoDetalleId;
        this.bodegaOrigenCodigo = bodegaOrigenCodigo;
        this.empresa = empresa;
        this.bodegaDestinoCodigo = bodegaDestinoCodigo;
        this.itemCodigo = itemCodigo;
    }

    // Getters y Setters
    public Long getMovimientoId() {
        return movimientoId;
    }

    public void setMovimientoId(Long movimientoId) {
        this.movimientoId = movimientoId;
    }

    public Long getMovimientoDetalleId() {
        return movimientoDetalleId;
    }

    public void setMovimientoDetalleId(Long movimientoDetalleId) {
        this.movimientoDetalleId = movimientoDetalleId;
    }

    public String getBodegaOrigenCodigo() {
        return bodegaOrigenCodigo;
    }

    public void setBodegaOrigenCodigo(String bodegaOrigenCodigo) {
        this.bodegaOrigenCodigo = bodegaOrigenCodigo;
    }

    public Integer getEmpresa() {
        return empresa;
    }

    public void setEmpresa(Integer empresa) {
        this.empresa = empresa;
    }

    public String getBodegaDestinoCodigo() {
        return bodegaDestinoCodigo;
    }

    public void setBodegaDestinoCodigo(String bodegaDestinoCodigo) {
        this.bodegaDestinoCodigo = bodegaDestinoCodigo;
    }

    public String getItemCodigo() {
        return itemCodigo;
    }

    public void setItemCodigo(String itemCodigo) {
        this.itemCodigo = itemCodigo;
    }
}
