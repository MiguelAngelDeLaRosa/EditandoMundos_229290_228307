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
public class Publicacion {
    
    private ObjectId id;
    private Autor autor;
    private int nPaginas;
    private float costo;
    private String titulo;
    private int paginaInicial;
    private float precioVenta;
    private String tipoPublicacion;
    private float tamMegas;

    public Publicacion(){
        
    }
    
    public Publicacion(Autor autor, int nPaginas, float costo, String titulo, int paginaInicial, float precioVenta, String tipoPublicacion) {
        this.autor = autor;
        this.nPaginas = nPaginas;
        this.costo = costo;
        this.titulo = titulo;
        this.paginaInicial = paginaInicial;
        this.precioVenta = precioVenta;
        this.tipoPublicacion = tipoPublicacion;
    }

    public Publicacion(ObjectId id, Autor autor, int nPaginas, float costo, String titulo, int paginaInicial, float precioVenta, String tipoPublicacion) {
        this.id = id;
        this.autor = autor;
        this.nPaginas = nPaginas;
        this.costo = costo;
        this.titulo = titulo;
        this.paginaInicial = paginaInicial;
        this.precioVenta = precioVenta;
        this.tipoPublicacion = tipoPublicacion;
    }

    public Publicacion(Autor autor, int nPaginas, float costo, String titulo, float precioVenta, String tipoPublicacion, float tamMegas) {
        this.autor = autor;
        this.nPaginas = nPaginas;
        this.costo = costo;
        this.titulo = titulo;
        this.precioVenta = precioVenta;
        this.tipoPublicacion = tipoPublicacion;
        this.tamMegas = tamMegas;
    }

    public Publicacion(ObjectId id, Autor autor, int nPaginas, float costo, String titulo, float precioVenta, String tipoPublicacion, float tamMegas) {
        this.id = id;
        this.autor = autor;
        this.nPaginas = nPaginas;
        this.costo = costo;
        this.titulo = titulo;
        this.precioVenta = precioVenta;
        this.tipoPublicacion = tipoPublicacion;
        this.tamMegas = tamMegas;
    }

    public ObjectId getId() {
        return id;
    }

    public void setId(ObjectId id) {
        this.id = id;
    }

    public Autor getAutor() {
        return autor;
    }

    public void setAutor(Autor autor) {
        this.autor = autor;
    }

    public int getnPaginas() {
        return nPaginas;
    }

    public void setnPaginas(int nPaginas) {
        this.nPaginas = nPaginas;
    }

    public float getCosto() {
        return costo;
    }

    public void setCosto(float costo) {
        this.costo = costo;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public int getPaginaInicial() {
        return paginaInicial;
    }

    public void setPaginaInicial(int paginaInicial) {
        this.paginaInicial = paginaInicial;
    }

    public float getPrecioVenta() {
        return precioVenta;
    }

    public void setPrecioVenta(float precioVenta) {
        this.precioVenta = precioVenta;
    }

    public String getTipoPublicacion() {
        return tipoPublicacion;
    }

    public void setTipoPublicacion(String tipoPublicacion) {
        this.tipoPublicacion = tipoPublicacion;
    }

    public float getTamMegas() {
        return tamMegas;
    }

    public void setTamMegas(float tamMegas) {
        this.tamMegas = tamMegas;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 67 * hash + Objects.hashCode(this.id);
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
        final Publicacion other = (Publicacion) obj;
        return Objects.equals(this.id, other.id);
    }

    @Override
    public String toString() {
        return "Publicacion{" + "id=" + id + ", autor=" + autor + ", nPaginas=" + nPaginas + ", costo=" + costo + ", titulo=" + titulo + ", paginaInicial=" + paginaInicial + ", precioVenta=" + precioVenta + ", tipoPublicacion=" + tipoPublicacion + ", tamMegas=" + tamMegas + '}';
    }

}
