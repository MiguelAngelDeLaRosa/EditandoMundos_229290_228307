/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package negocios;

import Entidades.Autor;
import Entidades.Publicacion;
import Entidades.Usuario;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.Ignore;
import static org.junit.Assert.*;

/**
 *
 * @author Miguel
 */
public class OperacionTest {
    
    public OperacionTest() {
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
     * Test of registrarAutor method, of class Operacion.
     */
    @Test
    public void testRegistrarAutor() {
        System.out.println("registrarAutor");
        String nombre = "J.K. Rowling";
        int edad = 50;
        String nacionalidad = "britanica";
        Operacion instance = new Operacion();
        boolean expResult = true;
        boolean result = instance.registrarAutor(nombre, edad, nacionalidad);
        assertEquals(expResult, result);
    }

    /**
     * Test of verificarUsuario method, of class Operacion.
     */
    @Test
    public void testVerificarUsuario() {
        System.out.println("verificarUsuario");
        String nombre = "Archy";
        String password = "AR1234";
        Operacion instance = new Operacion();
        boolean expResult = false;
        boolean result = instance.verificarUsuario(nombre, password);
        assertEquals(expResult, result);
    }

    /**
     * Test of mostrarCosto method, of class Operacion.
     */
    @Test
    public void testMostrarCosto() {
        System.out.println("mostrarCosto");
        int nPaginas = 300;
        Operacion instance = new Operacion();
        float expResult = 60000.0F;
        float result = instance.mostrarCosto(nPaginas);
        assertEquals(expResult, result, 0.0);
    }

    /**
     * Test of mostrarPrecioFisico method, of class Operacion.
     */
    @Test
    public void testMostrarPrecioFisico() {
        System.out.println("mostrarPrecioFisico");
        String nacionalidad = "aleman";
        float costo = 60000.0F;
        Operacion instance = new Operacion();
        float expResult = 75000.0F;
        float result = instance.mostrarPrecioFisico(nacionalidad, costo);
        assertEquals(expResult, result, 0.0);
    }

    /**
     * Test of validarCadenaEntero method, of class Operacion.
     */
    @Test
    public void testValidarCadenaEntero() {
        System.out.println("validarCadenaEntero");
        String cadena = "123";
        Operacion instance = new Operacion();
        boolean expResult = true;
        boolean result = instance.validarCadenaEntero(cadena);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of validarDecimal method, of class Operacion.
     */
    @Test
    public void testValidarDecimal() {
        System.out.println("validarDecimal");
        String cadena = "12.5";
        Operacion instance = new Operacion();
        boolean expResult = true;
        boolean result = instance.validarDecimal(cadena);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of validarTelefono method, of class Operacion.
     */
    @Test
    public void testValidarTelefono() {
        System.out.println("validarTelefono");
        String cadena = "6441347645";
        Operacion instance = new Operacion();
        boolean expResult = true;
        boolean result = instance.validarTelefono(cadena);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of validarEmail method, of class Operacion.
     */
    @Test
    public void testValidarEmail() {
        System.out.println("validarEmail");
        String cadena = "miguel@gmail.com";
        Operacion instance = new Operacion();
        boolean expResult = true;
        boolean result = instance.validarEmail(cadena);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of validarFecha method, of class Operacion.
     */
    @Test
    public void testValidarFecha() {
        System.out.println("validarFecha");
        String cadena = "24/04/2023";
        Operacion instance = new Operacion();
        boolean expResult = true;
        boolean result = instance.validarFecha(cadena);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of calcularFechas method, of class Operacion.
     */
    @Test
    public void testCalcularFechas() {
        System.out.println("calcularFechas");
        int nPaginas = 499;
        Operacion instance = new Operacion();
        String[] expResult = {"26/04/2023", "29/04/2023"};
        String[] result = instance.calcularFechas(nPaginas);
        assertArrayEquals(expResult, result);
        nPaginas = 500;
        String[] expResult2 = {"26/04/2023", "01/05/2023"};
        result = instance.calcularFechas(nPaginas);
        assertArrayEquals(expResult2, result);
        nPaginas = 1000;
        String[] expResult3 = {"26/04/2023", "03/05/2023"};
        result = instance.calcularFechas(nPaginas);
        assertArrayEquals(expResult3, result);
    }
    
}
