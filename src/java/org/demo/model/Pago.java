/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.demo.model;

/**
 *
 * @author cris7
 */
public class Pago {
    private int idPago;
    private String tipoPago;
    private String nombrePago;
    private String descripcionPago;

    public Pago() {
    }

    public Pago(int idPago, String tipoPago, String nombrePago, String descripcionPago) {
        this.idPago = idPago;
        this.tipoPago = tipoPago;
        this.nombrePago = nombrePago;
        this.descripcionPago = descripcionPago;
    }

    public String getDescripcionPago() {
        return descripcionPago;
    }

    public void setDescripcionPago(String descripcionPago) {
        this.descripcionPago = descripcionPago;
    }

    public int getIdPago() {
        return idPago;
    }

    public void setIdPago(int idPago) {
        this.idPago = idPago;
    }

    public String getTipoPago() {
        return tipoPago;
    }

    public void setTipoPago(String tipoPago) {
        this.tipoPago = tipoPago;
    }

    public String getNombrePago() {
        return nombrePago;
    }

    public void setNombrePago(String nombrePago) {
        this.nombrePago = nombrePago;
    }

    @Override
    public String toString() {
        return "Pago{" + "idPago=" + idPago + ", tipoPago=" + tipoPago + ", nombrePago=" + nombrePago + ", descripcionPago=" + descripcionPago + '}';
    }
    
    
    
}
