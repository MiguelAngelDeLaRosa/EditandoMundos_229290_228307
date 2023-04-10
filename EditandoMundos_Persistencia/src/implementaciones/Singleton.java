/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package implementaciones;

import interfaces.IConexionBD;
import interfaces.IFachada;

/**
 *
 * @author Miguel
 */
public class Singleton {
    
    private static IConexionBD conexion;
    private static IFachada fachada;
    
    private Singleton(){
        
    }
    
    public static IConexionBD getConexion(){
        if(conexion == null){
            conexion = new ConexionBD();
        }
        return conexion;
    }
    
    public static IFachada getFachada(){
        if(fachada == null){
            fachada = new Fachada();
        }
        return fachada;
    }
}
