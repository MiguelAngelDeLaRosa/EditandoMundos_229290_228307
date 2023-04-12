/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package implementaciones;

import Entidades.Publicacion;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import interfaces.IConexionBD;
import interfaces.IPublicacionDAO;
import java.util.LinkedList;
import java.util.List;
import java.util.regex.Pattern;
import org.bson.Document;

/**
 *
 * @author Miguel
 */
public class PublicacionDAO implements IPublicacionDAO {

    private final IConexionBD conexion;
    private final MongoDatabase baseDatos;

    public PublicacionDAO(IConexionBD conexion) {
        this.conexion = conexion;
        this.baseDatos = this.conexion.crearConexion();
    }

    private MongoCollection<Publicacion> getCollection() {
        return this.baseDatos.getCollection("publicaciones", Publicacion.class);
    }

    @Override
    public boolean agregar(Publicacion publicacion) {
        try{
            MongoCollection coleccion = this.getCollection();
            coleccion.insertOne(publicacion);
            return true;
        } catch(Exception ex){
            System.out.println(ex.getMessage());
            ex.printStackTrace();
            return false;
        }
    }

    @Override
    public List<Publicacion> consultarTodos() {
        try{
            MongoCollection coleccion = this.getCollection();
            List<Publicacion> listaPublicaciones = new LinkedList<>();
            coleccion.find().into(listaPublicaciones);
            return listaPublicaciones;
        } catch(Exception ex){
            System.out.println(ex.getMessage());
            ex.printStackTrace();
            return null;
        }
    }
    
    @Override
    public List<Publicacion> consultarPublicacionesPorTitulo(String titulo){
        try{
            Document query = new Document("titulo", Pattern.compile(titulo, Pattern.CASE_INSENSITIVE));
            MongoCollection coleccion = this.getCollection();
            List<Publicacion> listaPublicaciones = new LinkedList<>();
            coleccion.find(query).into(listaPublicaciones);
            return listaPublicaciones;
        } catch(Exception ex){
            System.out.println(ex.getMessage());
            ex.printStackTrace();
            return null;
        }
    }

    @Override
    public List<Publicacion> consultarPublicacionesPorTipoPublicacion(String tipoPublicacion) {
        try{
            Document query = new Document("tipoPublicacion", tipoPublicacion);
            MongoCollection coleccion = this.getCollection();
            List<Publicacion> listaPublicaciones = new LinkedList<>();
            coleccion.find(query).into(listaPublicaciones);
            return listaPublicaciones;
        } catch(Exception ex){
            System.out.println(ex.getMessage());
            ex.printStackTrace();
            return null;
        }
    }

    @Override
    public List<Publicacion> consultarPublicacionesPorFechaEntrega(String fechaEntrega) {
        try{
            Document query = new Document("fechaEntrega", fechaEntrega);
            MongoCollection coleccion = this.getCollection();
            List<Publicacion> listaPublicaciones = new LinkedList<>();
            coleccion.find(query).into(listaPublicaciones);
            return listaPublicaciones;
        } catch(Exception ex){
            System.out.println(ex.getMessage());
            ex.printStackTrace();
            return null;
        }
    }

    @Override
    public List<Publicacion> consultarPublicacionesPorTipoPago(String tipoPago) {
        try{
            Document query = new Document("tipoPago", tipoPago);
            MongoCollection coleccion = this.getCollection();
            List<Publicacion> listaPublicaciones = new LinkedList<>();
            coleccion.find(query).into(listaPublicaciones);
            return listaPublicaciones;
        } catch(Exception ex){
            System.out.println(ex.getMessage());
            ex.printStackTrace();
            return null;
        }
    }
}
