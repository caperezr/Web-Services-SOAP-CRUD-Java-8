/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.demo.model;

import java.util.Objects;

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
    
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Pago)) {
            return false;
        }
        Pago other = (Pago) obj;
        return idPago == other.idPago && tipoPago.equals(other.tipoPago) && nombrePago.equals(other.nombrePago)
                && descripcionPago.equals(other.descripcionPago);
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 59 * hash + this.idPago;
        hash = 59 * hash + Objects.hashCode(this.tipoPago);
        hash = 59 * hash + Objects.hashCode(this.nombrePago);
        hash = 59 * hash + Objects.hashCode(this.descripcionPago);
        return hash;
    }
    
    
}
