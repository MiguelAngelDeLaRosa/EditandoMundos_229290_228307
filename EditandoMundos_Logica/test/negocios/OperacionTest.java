/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package negocios;

import Entidades.Autor;
import Entidades.Publicacion;
import Entidades.Usuario;
import java.util.List;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Disabled;

/**
 *
 * @author Miguel
 */
public class OperacionTest {
    
    public OperacionTest() {
    }
    
    @BeforeAll
    public static void setUpClass() {
    }
    
    @AfterAll
    public static void tearDownClass() {
    }
    
    @BeforeEach
    public void setUp() {
    }
    
    @AfterEach
    public void tearDown() {
    }

    /**
     * Test of registrarPublicacionTipoFisico method, of class Operacion.
     */
    @Test
    @Disabled
    public void testRegistrarPublicacionTipoFisico() {
        System.out.println("registrarPublicacionTipoFisico");
        Autor autor = null;
        int nPaginas = 0;
        String titulo = "";
        int paginaInicial = 0;
        String tipoPublicacion = "";
        String medioPago = "";
        String fechaInicio = "";
        String fechaEntrega = "";
        Operacion instance = new Operacion();
        boolean expResult = false;
        boolean result = instance.registrarPublicacionTipoFisico(autor, nPaginas, titulo, paginaInicial, tipoPublicacion, medioPago, fechaInicio, fechaEntrega);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of registrarPublicacionTipoDigital method, of class Operacion.
     */
    @Test
    @Disabled
    public void testRegistrarPublicacionTipoDigital() {
        System.out.println("registrarPublicacionTipoDigital");
        Autor autor = null;
        int nPaginas = 0;
        String titulo = "";
        String tipoPublicacion = "";
        float tamMegas = 0.0F;
        String medioPago = "";
        Operacion instance = new Operacion();
        boolean expResult = false;
        boolean result = instance.registrarPublicacionTipoDigital(autor, nPaginas, titulo, tipoPublicacion, tamMegas, medioPago);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of registrarAutor method, of class Operacion.
     */
    @Test
    @Disabled
    public void testRegistrarAutor() {
        System.out.println("registrarAutor");
        String nombre = "";
        int edad = 0;
        String nacionalidad = "";
        Operacion instance = new Operacion();
        boolean expResult = false;
        boolean result = instance.registrarAutor(nombre, edad, nacionalidad);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of consultarPublicaciones method, of class Operacion.
     */
    @Test
    @Disabled
    public void testConsultarPublicaciones() {
        System.out.println("consultarPublicaciones");
        Operacion instance = new Operacion();
        List<Publicacion> expResult = null;
        List<Publicacion> result = instance.consultarPublicaciones();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of consultarPublicacionesPorTitulo method, of class Operacion.
     */
    @Test
    @Disabled
    public void testConsultarPublicacionesPorTitulo() {
        System.out.println("consultarPublicacionesPorTitulo");
        String titulo = "";
        Operacion instance = new Operacion();
        List<Publicacion> expResult = null;
        List<Publicacion> result = instance.consultarPublicacionesPorTitulo(titulo);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of consultarPublicacionesPorTipoPublicacion method, of class Operacion.
     */
    @Test
    @Disabled
    public void testConsultarPublicacionesPorTipoPublicacion() {
        System.out.println("consultarPublicacionesPorTipoPublicacion");
        String tipoPublicacion = "";
        Operacion instance = new Operacion();
        List<Publicacion> expResult = null;
        List<Publicacion> result = instance.consultarPublicacionesPorTipoPublicacion(tipoPublicacion);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of consultarPublicacionesPorFechaEntrega method, of class Operacion.
     */
    @Test
    @Disabled
    public void testConsultarPublicacionesPorFechaEntrega() {
        System.out.println("consultarPublicacionesPorFechaEntrega");
        String fechaEntrega = "";
        Operacion instance = new Operacion();
        List<Publicacion> expResult = null;
        List<Publicacion> result = instance.consultarPublicacionesPorFechaEntrega(fechaEntrega);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of consultarPublicacionesPorTipoPago method, of class Operacion.
     */
    @Test
    @Disabled
    public void testConsultarPublicacionesPorTipoPago() {
        System.out.println("consultarPublicacionesPorTipoPago");
        String tipoPago = "";
        Operacion instance = new Operacion();
        List<Publicacion> expResult = null;
        List<Publicacion> result = instance.consultarPublicacionesPorTipoPago(tipoPago);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of consultarAutores method, of class Operacion.
     */
    @Test
    @Disabled
    public void testConsultarAutores() {
        System.out.println("consultarAutores");
        Operacion instance = new Operacion();
        List<Autor> expResult = null;
        List<Autor> result = instance.consultarAutores();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of consultarTipoDeUsuario method, of class Operacion.
     */
    @Test
    @Disabled
    public void testConsultarTipoDeUsuario() {
        System.out.println("consultarTipoDeUsuario");
        String nombre = "";
        Operacion instance = new Operacion();
        Usuario expResult = null;
        Usuario result = instance.consultarTipoDeUsuario(nombre);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of verificarUsuario method, of class Operacion.
     */
    @Test
    @Disabled
    public void testVerificarUsuario() {
        System.out.println("verificarUsuario");
        String nombre = "";
        String password = "";
        Operacion instance = new Operacion();
        boolean expResult = false;
        boolean result = instance.verificarUsuario(nombre, password);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of registrarUsuario method, of class Operacion.
     */
    @Test
    @Disabled
    public void testRegistrarUsuario() {
        System.out.println("registrarUsuario");
        String nombreUsuario = "";
        String password = "";
        String nombreCliente = "";
        String telefono = "";
        String direccion = "";
        String email = "";
        boolean esAutor = false;
        Operacion instance = new Operacion();
        boolean expResult = false;
        boolean result = instance.registrarUsuario(nombreUsuario, password, nombreCliente, telefono, direccion, email, esAutor);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of mostrarCosto method, of class Operacion.
     */
    @Test
    @Disabled
    public void testMostrarCosto() {
        System.out.println("mostrarCosto");
        int nPaginas = 0;
        Operacion instance = new Operacion();
        float expResult = 0.0F;
        float result = instance.mostrarCosto(nPaginas);
        assertEquals(expResult, result, 0.0);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of mostrarPrecioFisico method, of class Operacion.
     */
    @Test
    @Disabled
    public void testMostrarPrecioFisico() {
        System.out.println("mostrarPrecioFisico");
        String nacionalidad = "";
        float costo = 0.0F;
        Operacion instance = new Operacion();
        float expResult = 0.0F;
        float result = instance.mostrarPrecioFisico(nacionalidad, costo);
        assertEquals(expResult, result, 0.0);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of mostrarPrecioDigital method, of class Operacion.
     */
    @Test
    @Disabled
    public void testMostrarPrecioDigital() {
        System.out.println("mostrarPrecioDigital");
        float tamMegas = 0.0F;
        float costo = 0.0F;
        Operacion instance = new Operacion();
        float expResult = 0.0F;
        float result = instance.mostrarPrecioDigital(tamMegas, costo);
        assertEquals(expResult, result, 0.0);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
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
    @Disabled
    public void testCalcularFechas() {
        System.out.println("calcularFechas");
        int nPaginas = 0;
        Operacion instance = new Operacion();
        String[] expResult = null;
        String[] result = instance.calcularFechas(nPaginas);
        assertArrayEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }
    
}
