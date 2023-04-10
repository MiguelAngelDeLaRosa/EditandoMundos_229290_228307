/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entidades;

import java.util.Objects;
import org.bson.types.ObjectId;

/**
 *
 * @author Miguel
 */
public class Usuario {
    
    private ObjectId id;
    private String nombreUsuario;
    private String password;
    private String nombreCliente;
    private String telefono;
    private String direccion;
    private String email;
    private boolean esAutor;
    

    public Usuario(){
        
    }

    public Usuario(String nombreUsuario, String password, boolean esAutor) {
        this.nombreUsuario = nombreUsuario;
        this.password = password;
        this.esAutor = esAutor;
    }

    public Usuario(String nombreUsuario, String password, String nombreCliente, String telefono, String direccion, String email, boolean esAutor) {
        this.nombreUsuario = nombreUsuario;
        this.password = password;
        this.nombreCliente = nombreCliente;
        this.telefono = telefono;
        this.direccion = direccion;
        this.email = email;
        this.esAutor = esAutor;
    }

    public Usuario(ObjectId id, String nombreUsuario, String password, String nombreCliente, String telefono, String direccion, String email, boolean esAutor) {
        this.id = id;
        this.nombreUsuario = nombreUsuario;
        this.password = password;
        this.nombreCliente = nombreCliente;
        this.telefono = telefono;
        this.direccion = direccion;
        this.email = email;
        this.esAutor = esAutor;
    }

    public ObjectId getId() {
        return id;
    }

    public void setId(ObjectId id) {
        this.id = id;
    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    public String getPassword() {
        return password;
    }

    public String getNombreCliente() {
        return nombreCliente;
    }

    public void setNombreCliente(String nombreCliente) {
        this.nombreCliente = nombreCliente;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public boolean isEsAutor() {
        return esAutor;
    }

    public void setEsAutor(boolean esAutor) {
        this.esAutor = esAutor;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 59 * hash + Objects.hashCode(this.id);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Usuario other = (Usuario) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Usuario{" + "id=" + id + ", nombreUsuario=" + nombreUsuario + ", password=" + password + ", nombreCliente=" + nombreCliente + ", telefono=" + telefono + ", direccion=" + direccion + ", email=" + email + ", esAutor=" + esAutor + '}';
    }
    
}
