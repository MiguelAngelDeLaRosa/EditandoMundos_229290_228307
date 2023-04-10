/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package interfaces;

import Entidades.Autor;
import Entidades.Publicacion;
import Entidades.Usuario;
import java.util.List;

/**
 *
 * @author Miguel
 */
public interface IFachada {
    
    public boolean agregarPublicacion(Publicacion publicacion);
    
    public boolean agregarAutor(Autor autor);
    
    public List<Publicacion> consultarPublicaciones();
    
    public List<Publicacion> consultarPublicacionesPorTitulo(String titulo);
    
    public List<Autor> consultarAutores();
    
    public Usuario consultarUsuario(String nombre);
}
