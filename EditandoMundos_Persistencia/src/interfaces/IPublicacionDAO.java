/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package interfaces;

import Entidades.Publicacion;
import java.util.List;
import org.bson.types.ObjectId;

/**
 *
 * @author Miguel
 */
public interface IPublicacionDAO {
    
    public boolean agregar(Publicacion publicacion);
    
    public List<Publicacion> consultarTodos();
    
    public List<Publicacion> consultarPublicacionesPorTitulo(String busqueda);
    
    public List<Publicacion> consultarPublicacionesPorTipoPublicacion(String tipoPublicacion);
    
    public List<Publicacion> consultarPublicacionesPorFechaEntrega(String fechaEntrega);
    
    public List<Publicacion> consultarPublicacionesPorTipoPago(String tipoPago);
    
    public boolean pagarPublicacion(String pago, ObjectId id);
}
