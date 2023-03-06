package org.demo.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import org.demo.config.Conexion;

public class AdministradorDAOImpl implements AdministradorDAO {

    int r;
    Administrador administrador = new Administrador();

    @Override
    public Administrador validarAdministrador(String userAdministrador, String passAdministrador) {
        administrador = new Administrador();
        String sql = "SELECT PK_ID_ADMINISTRADOR, DNI_ADMINISTRADOR, NOMBRES_ADMINISTRADOR, APELLIDOS_ADMINISTRADOR,"
                + "DIRECCION_ADMINISTRADOR,TELEFONO_ADMINISTRADOR, ADMI_ADMINISTRADOR, PASSWORD_ADMINISTRADOR "
                + "FROM TB_ADMINISTRADOR WHERE ESTADO_ADMINISTRADOR=1 AND ADMI_ADMINISTRADOR=? AND PASSWORD_ADMINISTRADOR=?";

        try (Connection con = Conexion.getConnection();
                PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(1, userAdministrador);
            ps.setString(2, passAdministrador);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    administrador = new Administrador(
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
            System.err.println("Error al intentar ingresar el administrador: " + e.getMessage());
        }
        return administrador;
    }

    @Override
    public List<Administrador> listarAdministrador(int estado) {
        String sql = "SELECT PK_ID_ADMINISTRADOR, DNI_ADMINISTRADOR, NOMBRES_ADMINISTRADOR, APELLIDOS_ADMINISTRADOR,"
                + "DIRECCION_ADMINISTRADOR,TELEFONO_ADMINISTRADOR, ADMI_ADMINISTRADOR, PASSWORD_ADMINISTRADOR FROM TB_ADMINISTRADOR WHERE ESTADO_ADMINISTRADOR=" + estado;
        List<Administrador> listaAdministrador = new ArrayList<>();
        try (Connection con = Conexion.getConnection();
                PreparedStatement ps = con.prepareStatement(sql);
                ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                Administrador administradorLocal = new Administrador(
                        rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getString(5),
                        rs.getString(6),
                        rs.getString(7),
                        rs.getString(8));
                listaAdministrador.add(administradorLocal);
            }
        } catch (SQLException e) {
            System.err.println("Error al listar los administradores: " + e.getMessage());
        }
        return listaAdministrador;
    }

//    @Override
//    public Administrador listarId(int id) {
//        Administrador administrador = new Administrador();
//        String sql = "SELECT PK_ID_ADMINISTRADOR, DNI_ADMINISTRADOR, NOMBRES_ADMINISTRADOR, APELLIDOS_ADMINISTRADOR,"
//                + "DIRECCION_ADMINISTRADOR,TELEFONO_ADMINISTRADOR, ADMI_ADMINISTRADOR, PASSWORD_ADMINISTRADOR FROM TB_ADMINISTRADOR WHERE PK_ID_ADMINISTRADOR=?";
//        try (Connection con = Conexion.getConnection();
//                PreparedStatement ps = con.prepareStatement(sql)) {
//            ps.setInt(1, id);
//            try (ResultSet rs = ps.executeQuery()) {
//                if (rs.next()) {
//                    administrador.setIdAdministrador(rs.getInt(1));
//                    administrador.setDniAdministrador(rs.getString(2));
//                    administrador.setNombresAdministrador(rs.getString(3));
//                    administrador.setApellidosAdministrador(rs.getString(4));
//                    administrador.setAddresAdministrador(rs.getString(5));
//                    administrador.setTelefonoAdministrador(rs.getString(6));
//                    administrador.setUserAdministrador(rs.getString(7));
//                    administrador.setPassAdministrador(rs.getString(8));
//                }
//            }
//        } catch (SQLException e) {
//            System.err.println("Error al actualizar el administrador: " + e.getMessage());
//        }
//        return administrador;
//    }
    @Override
    public Administrador listarId(int id) {
        String sql = "SELECT PK_ID_ADMINISTRADOR, DNI_ADMINISTRADOR, NOMBRES_ADMINISTRADOR, APELLIDOS_ADMINISTRADOR,"
                + "DIRECCION_ADMINISTRADOR,TELEFONO_ADMINISTRADOR, ADMI_ADMINISTRADOR, PASSWORD_ADMINISTRADOR FROM TB_ADMINISTRADOR WHERE PK_ID_ADMINISTRADOR=" + id;
        try (Connection con = Conexion.getConnection();
                PreparedStatement ps = con.prepareStatement(sql)) {
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    administrador = new Administrador(
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
            System.err.println("Error al listar el administrador: " + e.getMessage());
        }
        return administrador;
    }

    @Override
    public int actualizarAdministrador(Administrador administradorUpdate) {
        int rowAffected = 0;
        String sql = "UPDATE TB_ADMINISTRADOR SET DNI_ADMINISTRADOR=?, NOMBRES_ADMINISTRADOR=?, "
                + "APELLIDOS_ADMINISTRADOR=?, DIRECCION_ADMINISTRADOR=?, TELEFONO_ADMINISTRADOR=?, "
                + "ADMI_ADMINISTRADOR=?, PASSWORD_ADMINISTRADOR=?  WHERE PK_ID_ADMINISTRADOR=?";
        try (Connection con = Conexion.getConnection();
                PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(1, administradorUpdate.getDniAdministrador());
            ps.setString(2, administradorUpdate.getNombresAdministrador());
            ps.setString(3, administradorUpdate.getApellidosAdministrador());
            ps.setString(4, administradorUpdate.getAddresAdministrador());
            ps.setString(5, administradorUpdate.getTelefonoAdministrador());
            ps.setString(6, administradorUpdate.getUserAdministrador());
            ps.setString(7, administradorUpdate.getPassAdministrador());
            ps.setInt(8, administradorUpdate.getIdAdministrador());
            rowAffected = ps.executeUpdate();
        } catch (SQLException e) {
            System.err.println("Error al actualizar el administrador: " + e.getMessage());
        }
        return rowAffected;
    }

    @Override
    public int eliminarAdministrador(int idAdministrador) {
        int userAdmiDelete = 0;
        String sql = "UPDATE TB_ADMINISTRADOR SET ESTADO_ADMINISTRADOR=0  WHERE PK_ID_ADMINISTRADOR="+idAdministrador;
        try (Connection con = Conexion.getConnection();
                PreparedStatement ps = con.prepareStatement(sql)) {
            userAdmiDelete = ps.executeUpdate();
        } catch (SQLException e) {
            System.err.println("Hubo un error al intentar eliminar el administrador: "+e.getMessage());
        }
        
        return userAdmiDelete; //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int registrarAdministrador(Administrador administratorRegister) {
        int rowAdded = 0;
        String sql = "INSERT INTO TB_ADMINISTRADOR(DNI_ADMINISTRADOR, NOMBRES_ADMINISTRADOR, APELLIDOS_ADMINISTRADOR, DIRECCION_ADMINISTRADOR, "
                + "TELEFONO_ADMINISTRADOR, ADMI_ADMINISTRADOR, PASSWORD_ADMINISTRADOR, ESTADO_ADMINISTRADOR) VALUES (?,?,?,?,?,?,?,1)";
        try (Connection con = Conexion.getConnection();
                PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(1, administratorRegister.getDniAdministrador());
            ps.setString(2, administratorRegister.getNombresAdministrador());
            ps.setString(3, administratorRegister.getApellidosAdministrador());
            ps.setString(4, administratorRegister.getAddresAdministrador());
            ps.setString(5, administratorRegister.getTelefonoAdministrador());
            ps.setString(6, administratorRegister.getUserAdministrador());
            ps.setString(7, administratorRegister.getPassAdministrador());
            rowAdded = ps.executeUpdate();
        } catch (SQLException ex) {
            System.err.println("Error al Registrar al administrador: " + ex.getMessage());
        }
        return rowAdded;
    }

}
