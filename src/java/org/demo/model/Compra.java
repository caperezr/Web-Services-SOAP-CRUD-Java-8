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
public class Compra {
    private int idCompra;
    private int idCliente;
    private int idPago;
    private String fechaCompra;
    private double montoCompra;
    private String estadoCompra;

    public Compra() {
    }

    public Compra(int idCompra, int idCliente, int idPago, String fechaCompra, double montoCompra, String estadoCompra) {
        this.idCompra = idCompra;
        this.idCliente = idCliente;
        this.idPago = idPago;
        this.fechaCompra = fechaCompra;
        this.montoCompra = montoCompra;
        this.estadoCompra = estadoCompra;
    }

    public String getEstadoCompra() {
        return estadoCompra;
    }

    public void setEstadoCompra(String estadoCompra) {
        this.estadoCompra = estadoCompra;
    }

    public int getIdCompra() {
        return idCompra;
    }

    public void setIdCompra(int idCompra) {
        this.idCompra = idCompra;
    }

    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    public int getIdPago() {
        return idPago;
    }

    public void setIdPago(int idPago) {
        this.idPago = idPago;
    }

    public String getFechaCompra() {
        return fechaCompra;
    }

    public void setFechaCompra(String fechaCompra) {
        this.fechaCompra = fechaCompra;
    }

    public double getMontoCompra() {
        return montoCompra;
    }

    public void setMontoCompra(double montoCompra) {
        this.montoCompra = montoCompra;
    }

    @Override
    public String toString() {
        return "Compra{" + "idCompra=" + idCompra + ", idCliente=" + idCliente + ", idPago=" + idPago + ", fechaCompra=" + fechaCompra + ", montoCompra=" + montoCompra + ", estadoCompra=" + estadoCompra + '}';
    }
    
    
    
}
