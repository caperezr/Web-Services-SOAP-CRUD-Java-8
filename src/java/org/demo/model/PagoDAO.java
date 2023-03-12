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
public interface PagoDAO {
    public List<Pago> listarPago();
    public Pago buscarPagoId(int idPago);
    public int registrarPago(Pago pago);
    public int idUltimoPago();
    
}
