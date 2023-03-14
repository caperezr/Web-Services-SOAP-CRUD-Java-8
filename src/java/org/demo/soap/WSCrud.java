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
import org.demo.model.Compra;
import org.demo.model.CompraDAOImpl;
import org.demo.model.DetalleCompra;
import org.demo.model.DetalleCompraDAOImpl;
import org.demo.model.Pago;
import org.demo.model.PagoDAOImpl;
import org.demo.model.Producto;
import org.demo.model.ProductoDAOImpl;

/**
 *
 * @author cris7
 */
@WebService(serviceName = "WSCrud")
@Stateless()
public class WSCrud {

    Administrador administrador = new Administrador();
    Administrador adminLogueado = new Administrador();
    AdministradorDAOImpl administradordaoimpl = new AdministradorDAOImpl();
    Cliente cliente = new Cliente();
    ClienteDAOImpl clienteDaoImpl = new ClienteDAOImpl();
    Producto producto = new Producto();
    ProductoDAOImpl productoDaoImpl = new ProductoDAOImpl();
    Compra compra = new Compra();
    CompraDAOImpl compraDaoImpl = new CompraDAOImpl();
    DetalleCompra detCompra = new DetalleCompra();
    DetalleCompraDAOImpl detCompraDaoImpl = new DetalleCompraDAOImpl();
    Pago pago = new Pago();
    PagoDAOImpl pagoDaoImpl = new PagoDAOImpl();

//###############################################################################
    /**
     * Web service operation Administrador
     */
    @WebMethod(operationName = "loginAdministrador")
    public Administrador validarAdministrador(@WebParam(name = "userAdministrador") String userAdministrador, @WebParam(name = "passAdministrador") String passAdministrador) {
        Boolean estado;
        adminLogueado = administradordaoimpl.validarAdministrador(userAdministrador, passAdministrador);
        estado = adminLogueado.getIdAdministrador() != 0;
//        if (administrador.getIdAdministrador() != 0) {
//            estado = true;
//        } else {
//            estado = false;
//        }
        return adminLogueado;
    }
    
    @WebMethod(operationName = "listarAdministrador")
    public List<Administrador> listarAdministrador() {
        return administradordaoimpl.listarAdministrador();
    }
    
    @WebMethod(operationName = "listarAdministradorId")
    public Administrador listarAdministradorId(@WebParam(name = "idAdministrador") int idAdministrador) {
        //TODO write your implementation code here:
        return administradordaoimpl.listarAdministradorId(idAdministrador);
    }
    
    @WebMethod(operationName = "actualizarAdministrador")
    public String actualizarAdministrador(@WebParam(name = "idAdministrador") int idAdministrador, @WebParam(name = "dniAdministrador") String dniAdministrador, @WebParam(name = "nombresAdministrador") String nombresAdministrador, @WebParam(name = "apellidosAdministrador") String apellidosAdministrador, @WebParam(name = "addresAdministrador") String addresAdministrador, @WebParam(name = "telefonoAdministrador") String telefonoAdministrador, @WebParam(name = "userAdministrador") String userAdministrador, @WebParam(name = "passAdministrador") String passAdministrador) {
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
    
    @WebMethod(operationName = "eliminarAdministrador")
    public String eliminarAdministrador(@WebParam(name = "idAdministrador") int idAdministrador) {
        administradordaoimpl.eliminarAdministrador(idAdministrador);
        return "El administrador ha sido eliminado";
    }
    
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
    
//###############################################################################
    /**
     * Web service operation Cliente
     */
//###############################################################################
    @WebMethod(operationName = "validarCliente")
    public Cliente validarCliente(@WebParam(name = "emailCliente") String emailCliente, @WebParam(name = "passCliente") String passCliente) {
        Boolean estado;
        cliente = clienteDaoImpl.validarCliente(emailCliente, passCliente);
        estado = cliente.getIdCliente() != 0;
        return cliente;
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
    
    @WebMethod(operationName = "listarCliente")
    public List<Cliente> listarCliente() {
        return clienteDaoImpl.listarCliente();
    }

    
    @WebMethod(operationName = "listarClienteId")
    public Cliente listarClienteId(@WebParam(name = "idCliente") int idCliente) {
        //TODO write your implementation code here:
        return clienteDaoImpl.listarClienteId(idCliente);
    }
    
    @WebMethod(operationName = "actualizarCliente")
    public String actualizarCliente(@WebParam(name = "idCliente") int idCliente, @WebParam(name = "dniCliente") String dniCliente, @WebParam(name = "nombresCliente") String nombresCliente, @WebParam(name = "apellidosCliente") String apellidosCliente, @WebParam(name = "direccionCliente") String direccionCliente, @WebParam(name = "telefonoCliente") String telefonoCliente, @WebParam(name = "emailCliente") String emailCliente, @WebParam(name = "passwordCliente") String passwordCliente) {
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
    
    @WebMethod(operationName = "eliminarCliente")
    public String eliminarCliente(@WebParam(name = "idCliente") int idCliente) {
        clienteDaoImpl.eliminarCliente(idCliente);
        return "El cliente ha sido eliminado";
    }
//########################################################################################################
    /**
     * Web service operation Compra
     */
//########################################################################################################    
    @WebMethod(operationName = "listarCompra")
    public List<Compra> listarCompra() {
        return compraDaoImpl.listarCompra();
    }
    
    @WebMethod(operationName = "idUltimaCompra")
    public int idUltimaCompra() {
        return compraDaoImpl.idUltimaCompra();
    }
    
    @WebMethod(operationName = "contarCompraEnviada")
    public int contarCompraEnviada() {
        return compraDaoImpl.contarCompraEnviada();
    }
    
    @WebMethod(operationName = "contarCompraEntregada")
    public int contarCompraEntregada() {
        return compraDaoImpl.contarCompraEntregada();
    }
    
    @WebMethod(operationName = "contarCompraCancelada")
    public int contarCompraCancelada() {
        return compraDaoImpl.contarCompraCancelada();
    }
    
    @WebMethod(operationName = "montoCompraEnviada")
    public double montoCompraEnviada() {
        return compraDaoImpl.montoCompraEnviada();
    }
    
    @WebMethod(operationName = "montoCompraEntregada")
    public double montoCompraEntregada() {
        return compraDaoImpl.montoCompraEntregada();
    }
    
    @WebMethod(operationName = "montoCompraCancelada")
    public double montoCompraCancelada() {
        return compraDaoImpl.montoCompraCancelada();
    }
    
    @WebMethod(operationName = "montoCompraBruto")
    public double montoCompraBruto() {
        return compraDaoImpl.montoCompraBruto();
    }
    
    @WebMethod(operationName = "guardarCompra")
    public String guardarCompra(@WebParam(name = "idCliente") int idCliente, @WebParam(name = "idPago") int idPago, @WebParam(name = "fechaCompra") String fechaCompra, @WebParam(name = "montoCompra") double montoCompra, @WebParam(name = "estadoCompra") String estadoCompra) {
        compra.setIdCliente(idCliente);
        compra.setIdPago(idPago);
        compra.setFechaCompra(fechaCompra);
        compra.setMontoCompra(montoCompra);
        compra.setEstadoCompra(estadoCompra);
        compraDaoImpl.guardarCompra(compra);
        return "La compra ha sido registrada";
    }
    
    @WebMethod(operationName = "listarCompraCliente")
    public List<Compra> listarComprasCliente(@WebParam(name = "idCliente") int idCliente) {
        return compraDaoImpl.listarCompra();
    }
    
    @WebMethod(operationName = "actualizarEstado")
    public String actualizarEstado(@WebParam(name = "estadoCompra") String estadoCompra, @WebParam(name = "idCompra") int idCompra) {
        compraDaoImpl.actualizarEstado(estadoCompra, idCompra);
        return "El detalle de compra ha sido registrada";
    }
    
//########################################################################################################
    /**
     * Web service operation Detalle Compra
     */    
//########################################################################################################    
    @WebMethod(operationName = "listarDetalleCompra")
    public List<DetalleCompra> listarDetalleCompra(@WebParam(name = "idCompra") int idCompra) {
        return detCompraDaoImpl.listarDetalleCompra(idCompra);
    }
    
    @WebMethod(operationName = "guardarDetalleCompra")
    public String guardarDetalleCompra(@WebParam(name = "idProducto") int idProducto, @WebParam(name = "idCompra") int idCompra, @WebParam(name = "cantidadProducto") int cantidadProducto, @WebParam(name = "precioCompra") double precioCompra) {
        detCompra.setIdProducto(idProducto);
        detCompra.setIdCompra(idCompra);
        detCompra.setCantidadProducto(cantidadProducto);
        detCompra.setPrecioCompra(precioCompra);
        detCompraDaoImpl.guardarDetalleCompra(detCompra);
        return "El detalle de compra ha sido registrada";
    }
    
//########################################################################################################
    /**
     * Web service operation Pago
     */    
//########################################################################################################
    @WebMethod(operationName = "listarPago")
    public List<Pago> listarPago() {
        return pagoDaoImpl.listarPago();
    }
    
    @WebMethod(operationName = "buscarPagoId")
    public Pago buscarPagoId(@WebParam(name = "idPago") int idPago){
        return pagoDaoImpl.buscarPagoId(idPago);
    }
    
    @WebMethod(operationName = "registrarPago")
    public String registrarPago(@WebParam(name = "tipoPago") String tipoPago, @WebParam(name = "nombrePago") String nombrePago, @WebParam(name = "descripcionPago") String descripcionPago) {
        pago.setTipoPago(tipoPago);
        pago.setNombrePago(nombrePago);
        pago.setDescripcionPago(descripcionPago);
        pagoDaoImpl.registrarPago(pago);
        return "El pago ha sido registrado";
    }
    
    @WebMethod(operationName = "idUltimoPago")
    public int idUltimoPago(){
        return pagoDaoImpl.idUltimoPago();
    }
    
//########################################################################################################
    /**
     * Web service operation Producto
     */
//########################################################################################################
    @WebMethod(operationName = "listarProductos")
    public List<Producto> listarProductos() {
        return productoDaoImpl.listarProductos();
    }
    
    @WebMethod(operationName = "buscarProductoNombre")
    public List<Producto> buscarProductoNombre(@WebParam(name = "nombreProducto") String nombreProducto) {
        return productoDaoImpl.buscarProductoNombre(nombreProducto);
    }
    
    @WebMethod(operationName = "buscarProductoId")
    public Producto buscarProductoId(@WebParam(name = "idProducto") int idProducto) {
        //TODO write your implementation code here:
        return productoDaoImpl.buscarProductoId(idProducto);
    }
    
    @WebMethod(operationName = "agregarNuevoProducto")
    public String agregarNuevoProducto(@WebParam(name = "nombreProducto") String nombreProducto, @WebParam(name = "urlProducto") String urlProducto, @WebParam(name = "descripcionProducto") String descripcionProducto, @WebParam(name = "precioProducto") double precioProducto, @WebParam(name = "stockProducto") int stockProducto) {
        producto.setNombreProducto(nombreProducto);
        producto.setUrlProducto(urlProducto);
        producto.setDescripcionProducto(descripcionProducto);
        producto.setPrecioProducto(precioProducto);
        producto.setStockProducto(stockProducto);
        productoDaoImpl.agregarNuevoProducto(producto);
        return "El cliente ha sido registraddo";
    }


    @WebMethod(operationName = "actualizarProducto")
    public String actualizarProducto(@WebParam(name = "idProducto") int idProducto, @WebParam(name = "nombreProducto") String nombreProducto, @WebParam(name = "urlProducto") String urlProducto, @WebParam(name = "descripcionProducto") String descripcionProducto, @WebParam(name = "precioProducto") double precioProducto, @WebParam(name = "stockProducto") int stockProducto) {
        producto.setIdProducto(idProducto);
        producto.setNombreProducto(nombreProducto);
        producto.setUrlProducto(urlProducto);
        producto.setDescripcionProducto(descripcionProducto);
        producto.setPrecioProducto(precioProducto);
        producto.setStockProducto(stockProducto);
        productoDaoImpl.actualizarProducto(producto);
        return "El producto se ha actualizado";
    }

    @WebMethod(operationName = "actualizarStockProducto")
    public String actualizarStockProducto(@WebParam(name = "idProducto") int idProducto, @WebParam(name = "stockProducto") int stockProducto) {
        productoDaoImpl.actualizarStockProducto(idProducto, stockProducto);
        return "El stock del producto se ha actualizado";
    }

    @WebMethod(operationName = "eliminarProducto")
    public String eliminarProducto(@WebParam(name = "idProducto") int idProducto) {
        productoDaoImpl.eliminarProducto(idProducto);
        return "El cliente ha sido eliminado";
    }

}
