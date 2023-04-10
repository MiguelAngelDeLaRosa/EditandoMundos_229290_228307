/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package pruebas;

import Entidades.Autor;
import Entidades.Publicacion;
import implementaciones.Singleton;
import interfaces.IFachada;
import org.bson.types.ObjectId;

/**
 *
 * @author Miguel
 */
public class Test {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        IFachada fachada = Singleton.getFachada();

        Autor autor = new Autor();
        autor.setId(new ObjectId("6414cc1a522cb67ffad44019"));
        autor.setNombre("Archi");
        autor.setEdad(28);
        autor.setNacionalidad("Mexicana");
//        fachada.agregarAutor(autor);
//        fachada.consultarAutores().forEach(autores->{
//            System.out.println(autores);
//        });
        
        Publicacion publicacion = new Publicacion();
        publicacion.setAutor(autor);
        publicacion.setTitulo("Nameless");
        publicacion.setCosto(400);
        publicacion.setnPaginas(250);
        publicacion.setPrecioVenta(700);
        publicacion.setTipoPublicacion("Digital");
        publicacion.setTamMegas(7.5f);
//        fachada.agregarPublicacion(publicacion);
//        fachada.consultarPublicaciones().forEach(publicaciones->{
//            System.out.println(publicaciones);
//        });
        fachada.consultarPublicacionesPorTitulo("P").forEach(p->{
            System.out.println(p);
        });
    }
    
}
