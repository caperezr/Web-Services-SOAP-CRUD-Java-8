/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.demo.soap;

//import java.sql.SQLException;
//import java.util.ArrayList;
import java.util.List;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.ejb.Stateless;
import org.demo.model.Administrador;
import org.demo.model.AdministradorDAOImpl;
import org.demo.model.Cliente;
import org.demo.model.ClienteDAOImpl;
import org.demo.model.Producto;
import org.demo.model.ProductoDAOImpl;

/**
 *
 * @author cris7
 */
@WebService(serviceName = "WSConversion")
@Stateless()
public class WSConversion {

//    /**
//     * Web service operation
//     */
//    @WebMethod(operationName = "DecToBin")
//    public String DecToBin(@WebParam(name = "numero") int numero) {
//        String binario = "";
//        while (numero > 0) {
//            binario = numero % 2 + binario;
//            numero /= 2;
//        }
//        //TODO write your implementation code here:
//        return binario;
//    }
//
//    /**
//     * Web service operation
//     */
//    @WebMethod(operationName = "BinToDec")
//    public String BinToDec(@WebParam(name = "numBin") int numBin) {
//        int dec = 0;
//        int pot = 0;
//        //TODO write your implementation code here:
//        while (numBin > 0) {
//            int dig = numBin % 10;
//            dec += dig * Math.pow(2, pot);
//            pot++;
//            numBin /= 10;
//        }
//        return dec + "";
//    }
//
//    /**
//     * Web service operation
//     */
//    @WebMethod(operationName = "Saludo")
//    public String Saludo(@WebParam(name = "nombre") String nombre, @WebParam(name = "apellido") String apellido) {
//        //TODO write your implementation code here:
//        return "Hola, " + nombre + ", " + apellido + ". Bienvenido¡";
//    }
    /**
     * Web service operation
     */
    Administrador administrador = new Administrador();
    Administrador adminLogin = new Administrador();
    AdministradorDAOImpl administradordaoimpl = new AdministradorDAOImpl();
    Cliente cliente = new Cliente();
    ClienteDAOImpl clienteDaoImpl = new ClienteDAOImpl();
    Producto producto = new Producto();
    ProductoDAOImpl productoDaoImpl = new ProductoDAOImpl();

//###############################################################################
    /**
     * Web service operation Registrar
     */
    @WebMethod(operationName = "registrarAdministrador")
    public String registrarAdministrador(@WebParam(name = "dniAdministrador") String dniAdministrador, @WebParam(name = "nombresAdministrador") String nombresAdministrador, @WebParam(name = "apellidosAdministrador") String apellidosAdministrador, @WebParam(name = "addresAdministrador") String addresAdministrador, @WebParam(name = "telefonoAdministrador") String telefonoAdministrador, @WebParam(name = "userAdministrador") String userAdministrador, @WebParam(name = "passAdministrador") String passAdministrador) {
        administrador.setDniAdministrador(dniAdministrador);
        administrador.setNombresAdministrador(nombresAdministrador);
        administrador.setApellidosAdministrador(apellidosAdministrador);
        administrador.setAddresAdministrador(addresAdministrador);
        administrador.setTelefonoAdministrador(telefonoAdministrador);
        administrador.setUserAdministrador(userAdministrador);
        administrador.setPassAdministrador(passAdministrador);
        administradordaoimpl.registrarAdministrador(administrador);
        return "El administrador ha sido registrado";
    }

    @WebMethod(operationName = "registrarCliente")
    public String registrarCliente(@WebParam(name = "dniCliente") String dniCliente, @WebParam(name = "nombresCliente") String nombresCliente, @WebParam(name = "apellidosCliente") String apellidosCliente, @WebParam(name = "direccionCliente") String direccionCliente, @WebParam(name = "telefonoCliente") String telefonoCliente, @WebParam(name = "emailCliente") String emailCliente, @WebParam(name = "passCliente") String passCliente) {
        cliente.setDniCliente(dniCliente);
        cliente.setNombresCliente(nombresCliente);
        cliente.setApellidosCliente(apellidosCliente);
        cliente.setDireccionCliente(direccionCliente);
        cliente.setTelefonoCliente(telefonoCliente);
        cliente.setEmailCliente(emailCliente);
        cliente.setPassCliente(passCliente);
        clienteDaoImpl.registrarCliente(cliente);
        return "El cliente ha sido registraddo";
    }
//###############################################################################

    /**
     * Web service operation Iniciar Sesion
     */
    @WebMethod(operationName = "loginAdministrador")
    public Boolean loginAdministrador(@WebParam(name = "userAdministrador") String userAdministrador, @WebParam(name = "passAdministrador") String passAdministrador) {
        Boolean estado;
        adminLogin = administradordaoimpl.validarAdministrador(userAdministrador, passAdministrador);
        estado = adminLogin.getIdAdministrador() != 0;
//        if (administrador.getIdAdministrador() != 0) {
//            estado = true;
//        } else {
//            estado = false;
//        }
        return estado;
    }

    @WebMethod(operationName = "loginCliente")
    public Boolean loginCliente(@WebParam(name = "emailCliente") String emailCliente, @WebParam(name = "passCliente") String passCliente) {
        Boolean estado;
        cliente = clienteDaoImpl.validarCliente(emailCliente, passCliente);
        estado = cliente.getIdCliente() != 0;
        return estado;
    }
//###############################################################################
    /**
     * Web service operation listar en general
     */
    @WebMethod(operationName = "listarAdministrador")
    public List<Administrador> listarAdministrador() {
        return administradordaoimpl.listarAdministrador(1);
    }

    @WebMethod(operationName = "listarCliente")
    public List<Cliente> listarCliente() {
        return clienteDaoImpl.listarCliente();
    }

    @WebMethod(operationName = "listarProducto")
    public List<Producto> listarProducto() {
        return productoDaoImpl.listarProductos();
    }
//###############################################################################
    /**
     * Web service operation listar producto por nombre
     */
    @WebMethod(operationName = "listarProductoNombre")
    public List<Producto> listarProductoNombre(@WebParam(name = "nombreProducto") String nombreProducto) {
        return productoDaoImpl.buscarProductoNombre(nombreProducto);
    }
//###############################################################################
    /**
     * Web service operation listar por id
     */
    @WebMethod(operationName = "listarAdministradorId")
    public Administrador listarAdministradorId(@WebParam(name = "idAdministrador") int idAdministrador) {
        //TODO write your implementation code here:
        return administradordaoimpl.listarId(idAdministrador);
    }

    @WebMethod(operationName = "listarClienteId")
    public Cliente listarClienteId(@WebParam(name = "idCliente") int idCliente) {
        //TODO write your implementation code here:
        return clienteDaoImpl.listarClienteId(idCliente);
    }

    @WebMethod(operationName = "listarProductoId")
    public Producto listarProductoId(@WebParam(name = "idProducto") int idProducto) {
        //TODO write your implementation code here:
        return productoDaoImpl.buscarProductoId(idProducto);
    }
//###############################################################################

    /**
     * Web service operation Actualizar datos
     */
    @WebMethod(operationName = "actualizarDatosAdministrador")
    public String actualizarDatosAdministrador(@WebParam(name = "idAdministrador") int idAdministrador, @WebParam(name = "dniAdministrador") String dniAdministrador, @WebParam(name = "nombresAdministrador") String nombresAdministrador, @WebParam(name = "apellidosAdministrador") String apellidosAdministrador, @WebParam(name = "addresAdministrador") String addresAdministrador, @WebParam(name = "telefonoAdministrador") String telefonoAdministrador, @WebParam(name = "userAdministrador") String userAdministrador, @WebParam(name = "passAdministrador") String passAdministrador) {
        administrador.setIdAdministrador(idAdministrador);
        administrador.setDniAdministrador(dniAdministrador);
        administrador.setNombresAdministrador(nombresAdministrador);
        administrador.setApellidosAdministrador(apellidosAdministrador);
        administrador.setAddresAdministrador(addresAdministrador);
        administrador.setTelefonoAdministrador(telefonoAdministrador);
        administrador.setUserAdministrador(userAdministrador);
        administrador.setPassAdministrador(passAdministrador);
        administradordaoimpl.actualizarAdministrador(administrador);
        return "El administrador ha sido actualizado";
    }

    @WebMethod(operationName = "actualizarDatosCliente")
    public String actualizarDatosCliente(@WebParam(name = "idCliente") int idCliente, @WebParam(name = "dniCliente") String dniCliente, @WebParam(name = "nombresCliente") String nombresCliente, @WebParam(name = "apellidosCliente") String apellidosCliente, @WebParam(name = "direccionCliente") String direccionCliente, @WebParam(name = "telefonoCliente") String telefonoCliente, @WebParam(name = "emailCliente") String emailCliente, @WebParam(name = "passwordCliente") String passwordCliente) {
        cliente.setIdCliente(idCliente);
        cliente.setDniCliente(dniCliente);
        cliente.setNombresCliente(nombresCliente);
        cliente.setApellidosCliente(apellidosCliente);
        cliente.setDireccionCliente(direccionCliente);
        cliente.setTelefonoCliente(telefonoCliente);
        cliente.setEmailCliente(emailCliente);
        cliente.setPassCliente(passwordCliente);
        clienteDaoImpl.actualizarCliente(cliente);
        return "El cliente ha sido actualizado";
    }
//###############################################################################

    /**
     * Web service operation eliminar
     */
    @WebMethod(operationName = "eliminarAdministrador")
    public String eliminarAdministrador(@WebParam(name = "idAdministrador") int idAdministrador) {
        administradordaoimpl.eliminarAdministrador(idAdministrador);
        return "El administrador ha sido eliminado";
    }

    @WebMethod(operationName = "eliminarCliente")
    public String eliminarCliente(@WebParam(name = "idCliente") int idCliente) {
        clienteDaoImpl.eliminarCliente(idCliente);
        return "El cliente ha sido eliminado";
    }

    @WebMethod(operationName = "eliminarProducto")
    public String eliminarProducto(@WebParam(name = "idProducto") int idProducto) {
        productoDaoImpl.eliminarProducto(idProducto);
        return "El cliente ha sido eliminado";
    }

    /**
     * Web service operation
     */
}
