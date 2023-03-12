/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.demo.model;

import java.util.List;
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
public class PagoDAOImplTest {
    
    public PagoDAOImplTest() {
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
     * Test of listarPago method, of class PagoDAOImpl.
     */
//    @Test
//    public void testListarPago() {
//        System.out.println("listarPago");
//        PagoDAOImpl instance = new PagoDAOImpl();
//        List<Pago> expResult = null;
//        List<Pago> result = instance.listarPago();
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }

    /**
     * Test of buscarPagoId method, of class PagoDAOImpl.
     */
//    @Test
//    public void testBuscarPagoId() {
//        System.out.println("buscarPagoId");
//        int idPago = 0;
//        PagoDAOImpl instance = new PagoDAOImpl();
//        Pago expResult = null;
//        Pago result = instance.buscarPagoId(idPago);
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }

    /**
     * Test of registrarPago method, of class PagoDAOImpl.
     */
//    @Test
//    public void testRegistrarPago() {
//        System.out.println("registrarPago");
//        PagoDAOImpl instance = new PagoDAOImpl();
//        int expResult = 0;
//        int result = instance.registrarPago();
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }

    /**
     * Test of idUltimoPago method, of class PagoDAOImpl.
     */
    @Test
    public void testIdUltimoPago() {
        System.out.println("idUltimoPago");
        PagoDAOImpl instance = new PagoDAOImpl();
        int expResult = 3;
        int result = instance.idUltimoPago();
        assertEquals(expResult, result);
    }
    
}
