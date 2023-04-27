/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package implementaciones;

import Entidades.Usuario;
import interfaces.IUsuarioDAO;
import org.bson.types.ObjectId;
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
public class UsuarioDAOTest {
    
    public UsuarioDAOTest() {
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

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
     @Test
     public void testConsultarUsuario() {
         System.out.println("Consultar usuario");
         IUsuarioDAO usuario = DAOSFactory.crearUsuarioDAO();
         Usuario expResult = new Usuario(new ObjectId("643475090bf048528980e87d"), "Mary", "MA123", "Maria", 
                 "64414783202", "San Marcos", "maria@gmail.com", false);
         Usuario result = usuario.consultarUsuario(expResult.getNombreUsuario());
         assertEquals(expResult, result);
     }
     
     @Test
     public void testRegistrarUsuario(){
         System.out.println("Registrar usuario");
         IUsuarioDAO usuario = DAOSFactory.crearUsuarioDAO();
         boolean expResult = true;
         Usuario userTest = new Usuario("Archy", "AR1234", "Archivaldo", 
                 "6441423712", "San Chavo", "archi@gmail.com", true);
         boolean result = usuario.registrarUsuario(userTest);
         assertEquals(expResult, result);
     }
}
