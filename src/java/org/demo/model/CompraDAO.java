/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.demo.model;

import java.util.List;

/**
 *
 * @author cris7
 */
public interface CompraDAO {
    public List<Compra> listarCompra();
    public int idUltimaCompra();
    public int contarCompraEnviada();
    public int contarCompraEntregada();
    public int contarCompraCancelada();
    public double montoCompraEnviada();
    public double montoCompraEntregada();
    public double montoCompraCancelada();
    public double montoCompraBruto();
    public int guardarCompra(Compra com);
    public List<Compra> listarComprasCliente(int idCliente);
    public int actualizarEstado(String estadoCompra, int idCompra);
    
}
