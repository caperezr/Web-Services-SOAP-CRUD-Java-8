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
public interface ProductoDAO {
    
    public List<Producto> listarProductos();
    public List<Producto> buscarProductoNombre(String nombreProducto);
    public Producto buscarProductoId(int idProducto);
    public int agregarNuevoProducto(Producto p);
    public int actualizarProducto(Producto p);
    public int actualizarStockProducto(int idProducto, int stockProducto);
    public int eliminarProducto(int idProducto); 
    
    
}
