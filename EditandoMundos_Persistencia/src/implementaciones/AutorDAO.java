/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package implementaciones;

import Entidades.Autor;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import interfaces.IAutorDAO;
import interfaces.IConexionBD;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author Miguel
 */
public class AutorDAO implements IAutorDAO {
    
    private IConexionBD conexion;
    private MongoDatabase baseDatos;
    
    public AutorDAO(IConexionBD conexion){
        this.conexion = conexion;
        this.baseDatos = this.conexion.crearConexion();
    }
    
    private MongoCollection<Autor> getCollection(){
        return this.baseDatos.getCollection("autores", Autor.class);
    }

    @Override
    public boolean agregar(Autor autor) {
        try{
            MongoCollection coleccion = this.getCollection();
            coleccion.insertOne(autor);
            return true;
        } catch(Exception ex){
            System.out.println(ex.getMessage());
            ex.printStackTrace();
            return false;
        }
    }

    @Override
    public List<Autor> consultarTodos() {
        try{
            MongoCollection coleccion = this.getCollection();
            List<Autor> listaAutores = new LinkedList<>();
            coleccion.find().into(listaAutores);
            return listaAutores;
        } catch(Exception ex){
            System.out.println(ex.getMessage());
            ex.printStackTrace();
            return null;
        }
    }
}
