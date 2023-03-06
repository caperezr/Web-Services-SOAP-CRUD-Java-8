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
public interface ClienteDAO {
    public Cliente validarCliente (String emailCliente, String passCliente);
    public int registrarCliente (Cliente c);
    public List listarCliente ();
    public Cliente listarClienteId(int idCliente);
    public int actualizarCliente(Cliente c);
    public int eliminarCliente(int idCliente);
    
    
}
