/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package comunicacion;

import negocios.Operacion;

/**
 *
 * @author Miguel
 */
public class SOperacion {
    
    private static IOperacion instancia;
    
    private SOperacion(){
        
    }
    
    public static IOperacion getOperacion(){
        if(instancia == null){
            instancia = new Operacion();
        }
        return instancia;
    }
}
