/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package implementaciones;

import Entidades.Usuario;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import interfaces.IConexionBD;
import interfaces.IUsuarioDAO;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import org.bson.Document;

/**
 *
 * @author Miguel
 */
public class UsuarioDAO implements IUsuarioDAO {
    
    private IConexionBD conexion;
    private MongoDatabase baseDatos;

    public UsuarioDAO(IConexionBD conexion) {
        this.conexion = conexion;
        this.baseDatos = this.conexion.crearConexion();
    }
    
    private MongoCollection<Usuario> getCollection(){
        return this.baseDatos.getCollection("usuarios", Usuario.class);
    }

    @Override
    public Usuario consultarUsuario(String nombre) {
        try{
            MongoCollection<Usuario> coleccion = this.getCollection();
            List<Document> etapas = new ArrayList<>();
            etapas.add(new Document().append("$match", new Document()
                    .append("nombre", nombre)));
            List<Usuario> usuario = new LinkedList<>();
            coleccion.aggregate(etapas).into(usuario);
            if(usuario.get(0) == null){
                return null;
            }
            return usuario.get(0);
        } catch(Exception ex){
            System.out.println(ex.getMessage());
            ex.printStackTrace();
            return null;
        }
    }
}
