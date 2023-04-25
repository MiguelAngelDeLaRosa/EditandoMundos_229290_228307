/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package implementaciones;

import Entidades.Usuario;
import interfaces.IUsuarioDAO;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author Miguel
 */
public class UsuarioDAOTest {
    
    public UsuarioDAOTest() {
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

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
     @Test
     public void testConsultarUsuario() {
         System.out.println("Consultar usuario");
         IUsuarioDAO usuario = DAOSFactory.crearUsuarioDAO();
         Usuario expResult = new Usuario("Mary", "MA123", "Maria", 
                 "64414783202", "San Marcos", "maria@gmail.com", false);
         Usuario result = usuario.consultarUsuario(expResult.getNombreUsuario());
         assertEquals(expResult, result);
     }
}
