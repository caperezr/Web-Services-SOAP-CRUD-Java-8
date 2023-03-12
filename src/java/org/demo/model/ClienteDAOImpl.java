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
public class ClienteDAOImpl implements ClienteDAO {

    @Override
    public Cliente validarCliente(String emailCliente, String passCliente) {
        Cliente cliente = new Cliente();
        String sql = "SELECT PK_ID_CLIENTE, DNI_CLIENTE, NOMBRES_CLIENTE, APELLIDOS_CLIENTE,"
                + "DIRECCION_CLIENTE, TELEFONO_CLIENTE, EMAIL_CLIENTE, PASSWORD_CLIENTE FROM TB_CLIENTE "
                + "WHERE ESTADO_CLIENTE = 1 AND EMAIL_CLIENTE = ? AND PASSWORD_CLIENTE = ?";
        try (Connection con = Conexion.getConnection();
                PreparedStatement ps = con.prepareCall(sql)) {
            ps.setString(1, emailCliente);
            ps.setString(2, passCliente);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    cliente = new Cliente(
                            rs.getInt(1),
                            rs.getString(2),
                            rs.getString(3),
                            rs.getString(4),
                            rs.getString(5),
                            rs.getString(6),
                            rs.getString(7),
                            rs.getString(8));
                }
            }
        } catch (SQLException e) {
            System.err.println("Error al intentar validar: " + e);
        }
        return cliente;
    }

    @Override
    public int registrarCliente(Cliente c) {
        int rowAdded = 0;
        String sql = "INSERT INTO TB_CLIENTE(DNI_CLIENTE, NOMBRES_CLIENTE, APELLIDOS_CLIENTE, DIRECCION_CLIENTE, TELEFONO_CLIENTE, EMAIL_CLIENTE, "
                + "PASSWORD_CLIENTE, ESTADO_CLIENTE) VALUES(?,?,?,?,?,?,?,1)";
        try (Connection con = Conexion.getConnection();
                PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(1, c.getDniCliente());
            ps.setString(2, c.getNombresCliente());
            ps.setString(3, c.getApellidosCliente());
            ps.setString(4, c.getDireccionCliente());
            ps.setString(5, c.getTelefonoCliente());
            ps.setString(6, c.getEmailCliente());
            ps.setString(7, c.getPassCliente());
            rowAdded = ps.executeUpdate();
        } catch (Exception e) {
            System.err.println("Error al registrar el cliente: " + e);
        }
        return rowAdded;
    }

    @Override
    public List listarCliente() {
        String sql = "SELECT PK_ID_CLIENTE, DNI_CLIENTE, NOMBRES_CLIENTE, APELLIDOS_CLIENTE, DIRECCION_CLIENTE, TELEFONO_CLIENTE, EMAIL_CLIENTE, "
                + "PASSWORD_CLIENTE FROM TB_CLIENTE WHERE ESTADO_CLIENTE = 1";
        List<Cliente> listaClientes = new ArrayList<>();
        try (Connection con = Conexion.getConnection();
                PreparedStatement ps = con.prepareStatement(sql);
                ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                Cliente clienteLocal = new Cliente(
                        rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getString(5),
                        rs.getString(6),
                        rs.getString(7),
                        rs.getString(8));
                listaClientes.add(clienteLocal);
            }

        } catch (SQLException e) {
            System.err.println("Error al listar clientes: " + e);
        }
        return listaClientes;
    }

    @Override
    public Cliente listarClienteId(int idCliente) {
        Cliente cliente = new Cliente();
        String sql = "SELECT PK_ID_CLIENTE, DNI_CLIENTE, NOMBRES_CLIENTE, APELLIDOS_CLIENTE,"
                + "DIRECCION_CLIENTE, TELEFONO_CLIENTE, EMAIL_CLIENTE, PASSWORD_CLIENTE FROM TB_CLIENTE "
                + "WHERE ESTADO_CLIENTE = 1 AND PK_ID_CLIENTE = " + idCliente;
        try (Connection con = Conexion.getConnection();
                PreparedStatement ps = con.prepareStatement(sql)) {
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    cliente = new Cliente(rs.getInt(1),
                            rs.getString(2),
                            rs.getString(3),
                            rs.getString(4),
                            rs.getString(5),
                            rs.getString(6),
                            rs.getString(7),
                            rs.getString(8));
                }
            }
        } catch (SQLException e) {
            System.err.println("Error al listar el cliente: " + e);
        }
        return cliente;
    }

    @Override
    public int actualizarCliente(Cliente c) {
        int rowAffected = 0;
        String sql = "UPDATE TB_CLIENTE SET DNI_CLIENTE = ?, NOMBRES_CLIENTE = ?, APELLIDOS_CLIENTE = ?, "
                + "DIRECCION_CLIENTE = ?, TELEFONO_CLIENTE = ?, EMAIL_CLIENTE = ?, PASSWORD_CLIENTE = ? "
                + "WHERE PK_ID_CLIENTE = ?";
        try (Connection con = Conexion.getConnection();
                PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(1, c.getDniCliente());
            ps.setString(2, c.getNombresCliente());
            ps.setString(3, c.getApellidosCliente());
            ps.setString(4, c.getDireccionCliente());
            ps.setString(5, c.getTelefonoCliente());
            ps.setString(6, c.getTelefonoCliente());
            ps.setString(7, c.getEmailCliente());
            ps.setInt(8, c.getIdCliente());
            rowAffected = ps.executeUpdate();
        } catch (SQLException e) {
            System.err.println("Error al actualizar el cliente: "+e);
        }
        return rowAffected;
    }

    @Override
    public int eliminarCliente(int idCliente) {
        int userClientDelete = 0;
        String sql = "UPDATE TB_CLIENTE SET ESTADO_CLIENTE = 0 WHERE PK_ID_CLIENTE = "+idCliente;
        try (Connection con = Conexion.getConnection();
                PreparedStatement ps = con.prepareStatement(sql)) {
            userClientDelete = ps.executeUpdate();
        } catch (SQLException e) {
            System.err.println("Error al eliminar al cliente: "+e);
        }
        return userClientDelete;
    }

}
