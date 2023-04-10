/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package implementaciones;

import interfaces.IAutorDAO;
import interfaces.IConexionBD;
import interfaces.IPublicacionDAO;
import interfaces.IUsuarioDAO;

/**
 *
 * @author Miguel
 */
public class DAOSFactory {
    
    private final static IConexionBD conexion = Singleton.getConexion();
    
    public static IAutorDAO crearAutorDAO(){
        return new AutorDAO(conexion);
    }
    
    public static IPublicacionDAO crearPublicacionDAO(){
        return new PublicacionDAO(conexion);
    }
    
    public static IUsuarioDAO crearUsuarioDAO(){
        return new UsuarioDAO(conexion);
    }
}
