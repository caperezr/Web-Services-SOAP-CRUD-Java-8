/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.demo.model;



import com.mysql.jdbc.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import org.demo.config.Conexion;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author cris7
 */
public class AdministradorDAOImplTest {
    

    
    public AdministradorDAOImplTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {

    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of validarAdministrador method, of class AdministradorDAOImpl.
     */
    @Test
    public void testValidarAdministrador() {
        System.out.println("Prueba para el login del Administrador");
        String userAdministrador = "actualizado";
        String passAdministrador = "actualizado";
        AdministradorDAOImpl instance = new AdministradorDAOImpl();
        Administrador result = instance.validarAdministrador(userAdministrador, passAdministrador);
        assertEquals(instance.listarId(9034).getIdAdministrador(), result.getIdAdministrador());
    }

    /**
     * Test of listarAdministrador method, of class AdministradorDAOImpl.
     */
    @Test
    public void testListarAdministrador() {

    }
//
//    /**
//     * Test of listarId method, of class AdministradorDAOImpl.
//     */
//    @Test
//    public void testListarId() {
//        System.out.println("listarId");
//        int id = 0;
//        AdministradorDAOImpl instance = new AdministradorDAOImpl();
//        Administrador expResult = null;
//        Administrador result = instance.listarId(id);
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of actualizarAdministrador method, of class AdministradorDAOImpl.
//     */
//    @Test
//    public void testActualizarAdministrador() {
//        System.out.println("actualizarAdministrador");
//        Administrador administradorUpdate = null;
//        AdministradorDAOImpl instance = new AdministradorDAOImpl();
//        int expResult = 0;
//        int result = instance.actualizarAdministrador(administradorUpdate);
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of eliminarAdministrador method, of class AdministradorDAOImpl.
//     */
//    @Test
//    public void testEliminarAdministrador() {
//        System.out.println("eliminarAdministrador");
//        int idAdministrador = 0;
//        AdministradorDAOImpl instance = new AdministradorDAOImpl();
//        int expResult = 0;
//        int result = instance.eliminarAdministrador(idAdministrador);
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of registrarAdministrador method, of class AdministradorDAOImpl.
//     */
//    @Test
//    public void testRegistrarAdministrador() {
//        System.out.println("registrarAdministrador");
//        Administrador administratorRegister = null;
//        AdministradorDAOImpl instance = new AdministradorDAOImpl();
//        int expResult = 0;
//        int result = instance.registrarAdministrador(administratorRegister);
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
    
}
