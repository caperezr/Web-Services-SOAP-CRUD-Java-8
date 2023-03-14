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
public class CompraDAOImpl implements CompraDAO {

    @Override
    public List<Compra> listarCompra() {
        List<Compra> listaCompra = new ArrayList<>();
        String sql = "SELECT PK_ID_COMPRA, FK_ID_CLIENTE, FK_ID_PAGO, FECHA_COMPRA, MONTO_COMPRA, "
                + "ESTADO_COMPRA FROM TB_COMPRA";
        try (Connection con = Conexion.getConnection();
                PreparedStatement ps = con.prepareStatement(sql);
                ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                Compra compra = new Compra(
                        rs.getInt(1),
                        rs.getInt(2),
                        rs.getInt(3),
                        rs.getString(4),
                        rs.getDouble(5),
                        rs.getString(6));
                listaCompra.add(compra);
            }
        } catch (SQLException e) {
            System.err.println("Error al listar las copras: " + e.getMessage());
        }
        return listaCompra;
    }

    @Override
    public int idUltimaCompra() {
        int idCompra = 0;
        String sql = "SELECT MAX(PK_ID_COMPRA) FROM TB_COMPRA";
        try (Connection con = Conexion.getConnection();
                PreparedStatement ps = con.prepareStatement(sql)) {
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    idCompra = rs.getInt(1);
                }
            }
        } catch (SQLException e) {
            System.err.println("Error al listar el administrador: " + e.getMessage());
        }
        return idCompra;
    }

    @Override
    public int contarCompraEnviada() {
        int comprasEnviadas = 0;
        String sql = "SELECT COUNT(PK_ID_COMPRA) FROM TB_COMPRA WHERE ESTADO_COMPRA = 'Enviado'";
        try (Connection con = Conexion.getConnection();
                PreparedStatement ps = con.prepareStatement(sql)) {
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    comprasEnviadas = rs.getInt(1);
                }
            }
        } catch (SQLException e) {
            System.err.println("Error al contar compras enviadas: " + e.getMessage());
        }
        return comprasEnviadas;
    }

    @Override
    public int contarCompraEntregada() {
        int comprasEntregadas = 0;
        String sql = "SELECT COUNT(PK_ID_COMPRA) FROM TB_COMPRA WHERE ESTADO_COMPRA = 'Entregado'";
        try (Connection con = Conexion.getConnection();
                PreparedStatement ps = con.prepareStatement(sql)) {
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    comprasEntregadas = rs.getInt(1);
                }
            }
        } catch (SQLException e) {
            System.err.println("Error al contar compras entregadas: " + e.getMessage());
        }
        return comprasEntregadas;
    }

    @Override
    public int contarCompraCancelada() {
        int comprasCanceladas = 0;
        String sql = "SELECT COUNT(PK_ID_COMPRA) FROM TB_COMPRA WHERE ESTADO_COMPRA = 'Cancelado'";
        try (Connection con = Conexion.getConnection();
                PreparedStatement ps = con.prepareStatement(sql)) {
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    comprasCanceladas = rs.getInt(1);
                }
            }
        } catch (SQLException e) {
            System.err.println("Error al contar compras canceladas: " + e.getMessage());
        }
        return comprasCanceladas;
    }

    @Override
    public double montoCompraEnviada() {
        double montoComprasEnviadas = 0;
        String sql = "SELECT SUM(MONTO_COMPRA) FROM tb_compra WHERE ESTADO_COMPRA = 'Enviado'";
        try (Connection con = Conexion.getConnection();
                PreparedStatement ps = con.prepareStatement(sql)) {
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    montoComprasEnviadas = rs.getDouble(1);
                }
            }
        } catch (SQLException e) {
            System.err.println("Error al sumar compras enviadas: " + e.getMessage());
        }
        montoComprasEnviadas = (double) Math.round((montoComprasEnviadas) * 100) / 100;
        return montoComprasEnviadas;
    }

    @Override
    public double montoCompraEntregada() {
        double montoComprasEntregadas = 0;
        String sql = "SELECT SUM(MONTO_COMPRA) FROM tb_compra WHERE ESTADO_COMPRA = 'Entregado'";
        try (Connection con = Conexion.getConnection();
                PreparedStatement ps = con.prepareStatement(sql)) {
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    montoComprasEntregadas = rs.getDouble(1);
                }
            }
        } catch (SQLException e) {
            System.err.println("Error al sumar compras entregadas: " + e.getMessage());
        }
        montoComprasEntregadas = (double) Math.round((montoComprasEntregadas) * 100) / 100;
        return montoComprasEntregadas;
    }

    @Override
    public double montoCompraCancelada() {
        double montoComprasCanceladas = 0;
        String sql = "SELECT SUM(MONTO_COMPRA) FROM tb_compra WHERE ESTADO_COMPRA = 'Cancelado'";
        try (Connection con = Conexion.getConnection();
                PreparedStatement ps = con.prepareStatement(sql)) {
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    montoComprasCanceladas = rs.getDouble(1);
                }
            }
        } catch (SQLException e) {
            System.err.println("Error al sumar compras canceladas: " + e.getMessage());
        }
        montoComprasCanceladas = (double) Math.round((montoComprasCanceladas) * 100) / 100;
        return montoComprasCanceladas;
    }

    @Override
    public double montoCompraBruto() {
        double montoComprasBruto = 0;
        String sql = "SELECT SUM(MONTO_COMPRA) FROM TB_COMPRA";
        try (Connection con = Conexion.getConnection();
                PreparedStatement ps = con.prepareStatement(sql)) {
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    montoComprasBruto = rs.getDouble(1);
                }
            }
        } catch (SQLException e) {
            System.err.println("Error al sumar el monto bruto de las compras: " + e.getMessage());
        }
        montoComprasBruto = (double) Math.round((montoComprasBruto) * 100) / 100;
        return montoComprasBruto;
    }

    @Override
    public int guardarCompra(Compra com) {
        int rowAdded = 0;
        String sql = "INSERT INTO TB_COMPRA(FK_ID_CLIENTE, FK_ID_PAGO, FECHA_COMPRA, MONTO_COMPRA, ESTADO_COMPRA) VALUES (?,?,?,?,?)";
        try (Connection con = Conexion.getConnection();
                PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, com.getIdCliente());
            ps.setInt(2, com.getIdPago());
            ps.setString(3, com.getFechaCompra());
            ps.setDouble(4, com.getMontoCompra());
            ps.setString(5, com.getEstadoCompra());
            rowAdded = ps.executeUpdate();
        } catch (SQLException ex) {
            System.err.println("Error al Registrar la compra: " + ex.getMessage());
        }
        return rowAdded;
    }


    @Override
    public List<Compra> listarComprasCliente(int idCliente) {
        List<Compra> listaCompraCliente = new ArrayList<>();
        String sql = "SELECT PK_ID_COMPRA, FK_ID_CLIENTE, FK_ID_PAGO, FECHA_COMPRA, MONTO_COMPRA, "
                + "ESTADO_COMPRA  FROM TB_COMPRA WHERE FK_ID_CLIENTE=" + idCliente;
        try (Connection con = Conexion.getConnection();
                PreparedStatement ps = con.prepareStatement(sql);
                ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                Compra compra = new Compra(
                        rs.getInt(1),
                        rs.getInt(2),
                        rs.getInt(3),
                        rs.getString(4),
                        rs.getDouble(5),
                        rs.getString(6));
                listaCompraCliente.add(compra);
            }
        } catch (SQLException e) {
            System.err.println("Error al listar las copras de un cliente: " + e.getMessage());
        }
        return listaCompraCliente;
    }


    @Override
    public int actualizarEstado(String estadoCompra, int idCompra) {
        int rowAffected = 0;
        String sql="UPDATE TB_COMPRA SET ESTADO_COMPRA=? WHERE PK_ID_COMPRA=?";
        try (Connection con = Conexion.getConnection();
                PreparedStatement ps = con.prepareStatement(sql)){
            ps.setString(1, estadoCompra);
            ps.setInt(2, idCompra);
            ps.executeUpdate();
        } catch (SQLException e) {
            System.err.println("Error al actualizar el estado: " + e.getMessage());
        }
        return rowAffected;
    }

}
