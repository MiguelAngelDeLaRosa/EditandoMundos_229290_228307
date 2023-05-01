/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package implementaciones;

import Entidades.Autor;
import Entidades.Publicacion;
import Entidades.Usuario;
import interfaces.IAutorDAO;
import interfaces.IFachada;
import interfaces.IPublicacionDAO;
import interfaces.IUsuarioDAO;
import java.util.List;
import org.bson.types.ObjectId;

/**
 *
 * @author Miguel
 */
public class Fachada implements IFachada {
    
    private final IPublicacionDAO publicacionDAO;
    private final IAutorDAO autorDAO;
    private final IUsuarioDAO usuarioDAO;
    
    public Fachada(){
        this.publicacionDAO = DAOSFactory.crearPublicacionDAO();
        this.autorDAO = DAOSFactory.crearAutorDAO();
        this.usuarioDAO = DAOSFactory.crearUsuarioDAO();
    }

    @Override
    public boolean agregarPublicacion(Publicacion publicacion) {
        return publicacionDAO.agregar(publicacion);
    }

    @Override
    public boolean agregarAutor(Autor autor) {
        return autorDAO.agregar(autor);
    }

    @Override
    public List<Publicacion> consultarPublicaciones() {
        return publicacionDAO.consultarTodos();
    }

    @Override
    public List<Autor> consultarAutores() {
        return autorDAO.consultarTodos();
    }

    @Override
    public Usuario consultarUsuario(String nombre) {
        return usuarioDAO.consultarUsuario(nombre);
    }

    @Override
    public List<Publicacion> consultarPublicacionesPorTitulo(String titulo) {
        return publicacionDAO.consultarPublicacionesPorTitulo(titulo);
    }
    
    @Override
    public List<Publicacion> consultarPublicacionesPorTipoPublicacion(String tipoPublicacion){
        return publicacionDAO.consultarPublicacionesPorTipoPublicacion(tipoPublicacion);
    }
    
    @Override
    public List<Publicacion> consultarPublicacionesPorFechaEntrega(String fechaEntrega){
        return publicacionDAO.consultarPublicacionesPorFechaEntrega(fechaEntrega);
    }
    
    @Override
    public List<Publicacion> consultarPublicacionesPorEstado(String estado){
        return publicacionDAO.consultarPublicacionesPorEstado(estado);
    }

    @Override
    public boolean registrarUsuario(Usuario usuario) {
        return usuarioDAO.registrarUsuario(usuario);
    }

    @Override
    public boolean pagarPublicacion(float pago, String estado, ObjectId id) {
        return publicacionDAO.pagarPublicacion(pago, estado, id);
    }
}
