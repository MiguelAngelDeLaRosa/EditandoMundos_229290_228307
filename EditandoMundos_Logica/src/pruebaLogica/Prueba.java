/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package pruebaLogica;

import Entidades.Autor;
import negocios.Operacion;
import org.bson.types.ObjectId;

/**
 *
 * @author Miguel
 */
public class Prueba {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Operacion op = new Operacion();
        
//        op.registrarAutor("Octavio Paz", 42, "mexicana");
        Autor autor = new Autor(new ObjectId("6418afd29f794b02c01251cf"), "Octavio Paz", 42, "mexicano");
        op.registrarPublicacionTipoFisico(autor, 250, "Piedra del sol", 30, "Fisico");

        op.consultarPublicaciones().forEach(p->{
            System.out.println(p);
        });
        
    }
    
}
