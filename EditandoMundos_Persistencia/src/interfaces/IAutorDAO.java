/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package interfaces;

import Entidades.Autor;
import java.util.List;

/**
 *
 * @author Miguel
 */
public interface IAutorDAO {
    
    public boolean agregar(Autor autor);
    
    public List<Autor> consultarTodos();
}
