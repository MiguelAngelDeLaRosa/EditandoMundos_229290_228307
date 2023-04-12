/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entidades;

import java.util.Calendar;
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
    private String tipoPago;
    private String fechaInicio;
    private String fechaEntrega;

    public Publicacion(){
        
    }

    public Publicacion(Autor autor, int nPaginas, float costo, String titulo, int paginaInicial, 
            float precioVenta, String tipoPublicacion, String tipoPago, String fechaInicio, String fechaEntrega) {
        this.autor = autor;
        this.nPaginas = nPaginas;
        this.costo = costo;
        this.titulo = titulo;
        this.paginaInicial = paginaInicial;
        this.precioVenta = precioVenta;
        this.tipoPublicacion = tipoPublicacion;
        this.tipoPago = tipoPago;
        this.fechaInicio = fechaInicio;
        this.fechaEntrega = fechaEntrega;
    }

    public Publicacion(Autor autor, int nPaginas, float costo, String titulo, 
            float precioVenta, String tipoPublicacion, float tamMegas, String tipoPago) {
        this.autor = autor;
        this.nPaginas = nPaginas;
        this.costo = costo;
        this.titulo = titulo;
        this.precioVenta = precioVenta;
        this.tipoPublicacion = tipoPublicacion;
        this.tamMegas = tamMegas;
        this.tipoPago = tipoPago;
    }

    public Publicacion(ObjectId id, Autor autor, int nPaginas, float costo, 
            String titulo, int paginaInicial, float precioVenta, String tipoPublicacion, String tipoPago, String fechaInicio, String fechaEntrega) {
        this.id = id;
        this.autor = autor;
        this.nPaginas = nPaginas;
        this.costo = costo;
        this.titulo = titulo;
        this.paginaInicial = paginaInicial;
        this.precioVenta = precioVenta;
        this.tipoPublicacion = tipoPublicacion;
        this.tipoPago = tipoPago;
        this.fechaInicio = fechaInicio;
        this.fechaEntrega = fechaEntrega;
    }

    public Publicacion(ObjectId id, Autor autor, int nPaginas, float costo, 
            String titulo, float precioVenta, String tipoPublicacion, float tamMegas, String tipoPago) {
        this.id = id;
        this.autor = autor;
        this.nPaginas = nPaginas;
        this.costo = costo;
        this.titulo = titulo;
        this.precioVenta = precioVenta;
        this.tipoPublicacion = tipoPublicacion;
        this.tamMegas = tamMegas;
        this.tipoPago = tipoPago;
    }

    public Publicacion(ObjectId id, Autor autor, int nPaginas, float costo, 
            String titulo, int paginaInicial, float precioVenta, 
            String tipoPublicacion, float tamMegas, String tipoPago, String fechaInicio, String fechaEntrega) {
        this.id = id;
        this.autor = autor;
        this.nPaginas = nPaginas;
        this.costo = costo;
        this.titulo = titulo;
        this.paginaInicial = paginaInicial;
        this.precioVenta = precioVenta;
        this.tipoPublicacion = tipoPublicacion;
        this.tamMegas = tamMegas;
        this.tipoPago = tipoPago;
        this.fechaInicio = fechaInicio;
        this.fechaEntrega = fechaEntrega;
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

    public String getTipoPago() {
        return tipoPago;
    }

    public void setTipoPago(String tipoPago) {
        this.tipoPago = tipoPago;
    }

    public String getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(String fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public String getFechaEntrega() {
        return fechaEntrega;
    }

    public void setFechaEntrega(String fechaEntrega) {
        this.fechaEntrega = fechaEntrega;
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
        return "Publicacion{" + "autor=" + autor + ", nPaginas=" + nPaginas + ", costo=" + costo + 
                ", titulo=" + titulo + ", paginaInicial=" + paginaInicial + ", precioVenta=" + precioVenta + 
                ", tipoPublicacion=" + tipoPublicacion + ", tamMegas=" + tamMegas + ", tipoPago=" + tipoPago + 
                ", fechaInicio=" + fechaInicio + ", fechaEntrega=" + fechaEntrega + '}';
    }

}
