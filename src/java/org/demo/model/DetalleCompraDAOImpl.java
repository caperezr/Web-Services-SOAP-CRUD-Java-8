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
public class DetalleCompraDAOImpl implements DetalleCompraDAO{
    @Override
    public List<DetalleCompra> listarDetalleCompra(int idCompra) {
        List<DetalleCompra> listaDetalleCompra = new ArrayList<>();
        String sql = "SELECT DC.PK_ID_DETALLE_COMPRA, DC.FK_ID_PRODUCTO, P.IMAGEN_PRODUCTO, P.NOMBRE_PRODUCTO, "
                + "DC.FK_ID_COMPRA, DC.CANTIDAD_COMPRA, DC.PRECIO_COMPRA FROM TB_DETALLE_COMPRA DC "
                + "INNER JOIN TB_PRODUCTO P ON P.PK_ID_PRODUCTO = DC.FK_ID_PRODUCTO WHERE FK_ID_COMPRA=" + idCompra;
        try (Connection con = Conexion.getConnection();
                PreparedStatement ps = con.prepareStatement(sql);
                ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                DetalleCompra dcom = new DetalleCompra();
                dcom.setIdDetalleCompra(rs.getInt(1));
                dcom.setProducto(new Producto());
                dcom.getProducto().setIdProducto(rs.getInt(2));
                dcom.getProducto().setUrlProducto(rs.getString(3));
                dcom.getProducto().setNombreProducto(rs.getString(4));
                dcom.setIdCompra(rs.getInt(5));
                dcom.setCantidadProducto(rs.getInt(6));
                dcom.setPrecioCompra(rs.getDouble(7));
                listaDetalleCompra.add(dcom);
            }
        } catch (SQLException e) {
            System.err.println("Error al listar los detalles de compra: " + e.getMessage());
        }
        return listaDetalleCompra;
    }
    
}
