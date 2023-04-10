/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package interfaces;

import Entidades.Publicacion;
import java.util.List;

/**
 *
 * @author Miguel
 */
public interface IPublicacionDAO {
    
    public boolean agregar(Publicacion publicacion);
    
    public List<Publicacion> consultarTodos();
    
    public List<Publicacion> consultarPublicacionesPorTitulo(String titulo);
}
