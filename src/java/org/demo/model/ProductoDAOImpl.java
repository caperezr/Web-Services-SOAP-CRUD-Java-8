/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.demo.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import org.demo.config.Conexion;

/**
 *
 * @author cris7
 */
public class ProductoDAOImpl implements ProductoDAO {

    @Override
    public List<Producto> listarProductos() {
        String sql = "SELECT PK_ID_PRODUCTO, NOMBRE_PRODUCTO, IMAGEN_PRODUCTO, DESCRIPCION_PRODUCTO, "
                + "PRECIO_PRODUCTO, STOCK_PRODUCTO FROM TB_PRODUCTO WHERE ESTADO_PRODUCTO = 1 "
                + "ORDER BY STOCK_PRODUCTO DESC";
        List<Producto> listaProductos = new ArrayList<>();
        try (Connection con = Conexion.getConnection();
                PreparedStatement ps = con.prepareStatement(sql);
                ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                Producto producto = new Producto(
                        rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getDouble(5),
                        rs.getInt(6));
                listaProductos.add(producto);
            }
        } catch (SQLException e) {
            System.err.println("Error al listar los productos: " + e.getMessage());
        }
        return listaProductos; //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Producto> buscarProductoNombre(String nombreProducto) {
        String sql = "SELECT PK_ID_PRODUCTO, NOMBRE_PRODUCTO, IMAGEN_PRODUCTO, DESCRIPCION_PRODUCTO, "
                + "PRECIO_PRODUCTO, STOCK_PRODUCTO FROM TB_PRODCUTO "
                + "WHERE ESTADO_PRODUCTO = 1 AND NOMBRE_PRODUCTO LIKE '%" + nombreProducto + "%'";
        List<Producto> listaProductoNombre = new ArrayList<>();
        try (Connection con = Conexion.getConnection();
                PreparedStatement ps = con.prepareStatement(sql);
                ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                Producto producto = new Producto(
                        rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getDouble(5),
                        rs.getInt(6));
                listaProductoNombre.add(producto);
            }
        } catch (SQLException e) {
            System.err.println("Error al listar producto: " + e.getMessage());
        }
        return listaProductoNombre; //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Producto buscarProductoId(int idProducto) {
        String sql = "SELECT PK_ID_PRODUCTO, NOMBRE_PRODUCTO, IMAGEN_PRODUCTO, DESCRIPCION_PRODUCTO, "
                + "PRECIO_PRODUCTO, STOCK_PRODUCTO FROM TB_PRODUCTO "
                + "WHERE ESTADO_PRODUCTO = 1 AND PK_ID_PRODUCTO=" + idProducto;
        Producto producto = new Producto();
        try (Connection con = Conexion.getConnection();
                PreparedStatement ps = con.prepareStatement(sql)) {
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    producto = new Producto(
                            rs.getInt(1),
                            rs.getString(2),
                            rs.getString(3),
                            rs.getString(4),
                            rs.getDouble(5),
                            rs.getInt(6));
                }
            }
        } catch (SQLException e) {
            System.err.println("Error al listar los productos: " + e.getMessage());
        }
        return producto; //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int agregarNuevoProducto(Producto p) {
        int rowAdded = 0;
        String sql = "INSERT INTO TB_PRODUCTO(NOMBRE_PRODUCTO, IMAGEN_PRODUCTO, DESCRIPCION_PRODUCTO, "
                + "PRECIO_PRODUCTO, STOCK_PRODUCTO, ESTADO_PRODUCTO) VALUES (?,?,?,?,?,1)";
        try (Connection con = Conexion.getConnection();
                PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(1, p.getNombreProducto());
            ps.setString(2, p.getUrlProducto());
            ps.setString(3, p.getDescripcionProducto());
            ps.setDouble(4, p.getPrecioProducto());
            ps.setInt(5, p.getStockProducto());
            rowAdded = ps.executeUpdate();
        } catch (SQLException e) {
            System.err.println("Error al registrar el producto: " + e.getMessage());
        }
        return rowAdded; //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int actualizarProducto(Producto p) {
        int rowAffected = 0;
        String sql = "UPDATE TB_PRODUCTO SET NOMBRE_PRODUCTO=?, IMAGEN_PRODUCTO=?, DESCRIPCION_PRODUCTO=?, "
                + "PRECIO_PRODUCTO=?, STOCK_PRODUCTO=? WHERE PK_ID_PRODUCTO=?";
        try (Connection con = Conexion.getConnection();
                PreparedStatement ps = con.prepareStatement(sql)){
            ps.setString(1, p.getNombreProducto());
            ps.setString(2, p.getUrlProducto());
            ps.setString(3, p.getDescripcionProducto());
            ps.setDouble(4, p.getPrecioProducto());
            ps.setInt(5, p.getStockProducto());
            ps.setInt(6, p.getIdProducto());
            rowAffected = ps.executeUpdate();
        } catch (SQLException e) {
            System.err.println("Error al actualizar el producto: " + e.getMessage());
        }
        return rowAffected; //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int actualizarStockProducto(int idProducto, int stockProducto) {
        int stokAffected = 0;
        String sql="UPDATE TB_PRODUCTO SET STOCK_PRODUCTO=? WHERE PK_ID_PRODUCTO=?";
        try (Connection con = Conexion.getConnection();
                PreparedStatement ps = con.prepareStatement(sql)){
            ps.setInt(1, stockProducto);
            ps.setInt(2, idProducto);
            stokAffected = ps.executeUpdate();
        } catch (SQLException e) {
            System.err.println("Error al actualizar el stock: " + e.getMessage());
        }
        return stokAffected; //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int eliminarProducto(int idProducto) {
        int productDelete = 0;
        String sql="UPDATE TB_PRODUCTO SET ESTADO_PRODUCTO=0 WHERE PK_ID_PRODUCTO="+idProducto;
        try (Connection con = Conexion.getConnection();
                PreparedStatement ps = con.prepareStatement(sql)){
            productDelete = ps.executeUpdate();
        } catch (SQLException e) {
            System.err.println("Error al eliminar el producto: " + e.getMessage());
        }
        return productDelete; //To change body of generated methods, choose Tools | Templates.
    }

}
