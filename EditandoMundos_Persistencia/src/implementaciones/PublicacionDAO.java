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
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.regex.Pattern;
import org.bson.Document;
import org.bson.types.ObjectId;

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
            SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
            Document filtro = new Document(fechaEntrega, new Document("$gte", formato.parse("01/01/2023")));
            Document orden = new Document(fechaEntrega, -1);
            MongoCollection coleccion = this.getCollection();
            List<Publicacion> listaPublicaciones = new LinkedList<>();
            coleccion.find(filtro).sort(orden).into(listaPublicaciones);
            return listaPublicaciones;
        } catch(Exception ex){
            System.out.println(ex.getMessage());
            ex.printStackTrace();
            return null;
        }
    }

    @Override
    public List<Publicacion> consultarPublicacionesPorEstado(String estado) {
        try{
            Document query = null;
            if (estado.equals("Pagado")){
                query = new Document("estado", estado);
            } else {
                estado = "Pendiente por pagar";
                query = new Document("estado", estado);
            }
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
    public boolean pagarPublicacion(float pago, String estado, ObjectId id) {
        try {
            MongoCollection<Publicacion> coleccion = this.getCollection();
            Document filtro = new Document("_id", id);
            Document cambios = new Document();
            cambios.append("costo", pago);
            cambios.append("estado", estado);
            Document nuevo = new Document("$set", cambios);
            coleccion.updateOne(filtro, nuevo);
            return true;
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            ex.printStackTrace();
            return false;
        }
    }
}
