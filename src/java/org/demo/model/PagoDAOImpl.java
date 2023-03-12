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
public class PagoDAOImpl implements PagoDAO {

    @Override
    public List<Pago> listarPago() {
        String sql = "SELECT PK_ID_PAGO, TIPO_PAGO, NOMBRE_PAGO, DESCRIPCION_PAGO FROM TB_PAGO";
        List<Pago> listaPago = new ArrayList<>();
        try (Connection con = Conexion.getConnection();
                PreparedStatement ps = con.prepareStatement(sql);
                ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                Pago pago = new Pago(
                        rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4));
                listaPago.add(pago);
            }
        } catch (SQLException e) {
            System.err.println("Error al listar los pagos: " + e.getMessage());
        }
        return listaPago;
    }

    @Override
    public Pago buscarPagoId(int idPago) {
        String sql = "SELECT PK_ID_PAGO, TIPO_PAGO, NOMBRE_PAGO, DESCRIPCION_PAGO FROM TB_PAGO WHERE PK_ID_PAGO=" + idPago;
        Pago pago = new Pago();
        try (Connection con = Conexion.getConnection();
                PreparedStatement ps = con.prepareStatement(sql)) {
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    pago = new Pago(
                            rs.getInt(1),
                            rs.getString(2),
                            rs.getString(3),
                            rs.getString(4));
                }
            }
        } catch (SQLException e) {
            System.err.println("Error al buscar pago por id: " + e.getMessage());
        }
        return pago;
    }

    @Override
    public int registrarPago(Pago pago) {
        int rowAdded = 0;
        String sql = "INSERT INTO TB_PAGO(PK_ID_PAGO, TIPO_PAGO, NOMBRE_PAGO, DESCRIPCION_PAGO) VALUES (?,?,?,?)";
        try (Connection con = Conexion.getConnection();
                PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, pago.getIdPago());
            ps.setString(2, pago.getTipoPago());
            ps.setString(3, pago.getNombrePago());
            ps.setString(4, pago.getDescripcionPago());
            rowAdded = ps.executeUpdate();
        } catch (SQLException ex) {
            System.err.println("Error al Registrar el Pago: " + ex.getMessage());
        }
        return rowAdded;
    }

    @Override
    public int idUltimoPago() {
        int idUltimoPago = 0;
        String sql = "SELECT MAX(PK_ID_PAGO) FROM TB_PAGO";
        try (Connection con = Conexion.getConnection();
                PreparedStatement ps = con.prepareStatement(sql)) {
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    idUltimoPago = rs.getInt(1);
                }
            }
        } catch (SQLException e) {
            System.err.println("Error al devolver el Id del último Pago: " + e.getMessage());
        }
        return idUltimoPago;
    }

}
