/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.demo.main;

import java.sql.SQLException;
import org.demo.model.Administrador;
import org.demo.model.AdministradorDAOImpl;
import org.demo.model.Cliente;
import org.demo.model.ClienteDAOImpl;


/**
 *
 * @author cris7
 */
public class main {
    
    @SuppressWarnings("empty-statement")
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        AdministradorDAOImpl adaoimp = new AdministradorDAOImpl();
//        Administrador ad;
//        ad = new Administrador(9034,"7777777","actualizado","actualizado","actualizado","actualizado","actualizado","actualizado");
//        
//        System.out.println(adaoimp.listarId(9034).toString());
//        
//        System.out.println(""+adaoimp.actualizarAdministrador(ad));
//        System.out.println("hola");
        //adaoimp.eliminarAdministrador(9034);
        ClienteDAOImpl cdaoimp = new ClienteDAOImpl();
//        System.out.println(""+cdaoimp.listarCliente().toString());
System.out.println(cdaoimp.validarCliente("cris@gmail.com", "1234").toString());
        System.out.println(cdaoimp.listarClienteId(76).toString());
//        Cliente cliente = new Cliente(76, "71245436", "Julian", "Paredes", "Av. los gladiolos", "765676545", "jparedes@gmail.com", "123456");
//        System.out.println(""+cdaoimp.actualizarCliente(cliente));;
        System.out.println(""+cdaoimp.eliminarCliente(76));
        

        
        
        
        
        
        
        
        
    }
    
}