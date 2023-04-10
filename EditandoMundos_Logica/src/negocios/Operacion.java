/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package negocios;

import Entidades.Autor;
import Entidades.Publicacion;
import Entidades.Usuario;
import comunicacion.IOperacion;
import implementaciones.Singleton;
import interfaces.IFachada;
import java.util.List;
import javax.swing.JOptionPane;
import validadores.Validadores;

/**
 *
 * @author Miguel
 */
public class Operacion implements IOperacion {
    
    private final IFachada fachada;
    private final Cotizacion cotizar;
    
    public Operacion() {
        this.fachada = Singleton.getFachada();
        this.cotizar = new Cotizacion();
    }
    
    @Override
    public boolean registrarPublicacionTipoFisico(Autor autor, int nPaginas, String titulo, 
            int paginaInicial, String tipoPublicacion){
        float costoFinal = cotizar.calcularCosto(nPaginas);
        float precioFinal = cotizar.calcularPrecioFisico(autor.getNacionalidad(), costoFinal);
        Publicacion p = new Publicacion(autor, nPaginas, costoFinal, titulo, paginaInicial, precioFinal, tipoPublicacion);
        
        if(fachada.agregarPublicacion(p)){
            JOptionPane.showMessageDialog(null, "Se agrego la publicacion");
            return true;
        }
        return false;
    }
    
    @Override
    public boolean registrarPublicacionTipoDigital(Autor autor, int nPaginas, String titulo, 
            String tipoPublicacion, float tamMegas){
        System.out.println(nPaginas);
        float costoFinal = cotizar.calcularCosto(nPaginas);
        float precioFinal = cotizar.calcularPrecioDigital(tamMegas, costoFinal);
        Publicacion p = new Publicacion(autor, nPaginas, costoFinal, titulo, precioFinal, tipoPublicacion, tamMegas);
        p.setAutor(autor);
        p.setnPaginas(nPaginas);
        p.setCosto(costoFinal);
        p.setTitulo(titulo);
        p.setPrecioVenta(precioFinal);
        p.setTipoPublicacion(tipoPublicacion);
        p.setTamMegas(tamMegas);
        
        if(fachada.agregarPublicacion(p)){
            JOptionPane.showMessageDialog(null, "Se agrego la publicacion");
            return true;
        }
        return false;
    }
    
    @Override
    public boolean registrarAutor(String nombre, int edad, String nacionalidad){
        Autor autor = new Autor(nombre, edad, nacionalidad);
        if(fachada.agregarAutor(autor)){
            JOptionPane.showMessageDialog(null, "Se agrego el autor");
            return true;
        }
        return false;
    }
    
    @Override
    public List<Publicacion> consultarPublicaciones(){
        List<Publicacion> publicaciones = fachada.consultarPublicaciones();
        return publicaciones;
    }
    
    @Override
    public List<Publicacion> consultarPublicacionesPorTitulo(String titulo){
        List<Publicacion> publicaciones = fachada.consultarPublicacionesPorTitulo(titulo);
        return publicaciones;
    }
    
    @Override
    public List<Autor> consultarAutores(){
        List<Autor> autores = fachada.consultarAutores();
        return autores;
    }
    
    @Override
    public boolean verificarUsuario(String nombre, String password){
        boolean valido = false;
        Usuario verificar = fachada.consultarUsuario(nombre);
        if(verificar != null){
            if(verificar.getPassword().equals(password)){
                JOptionPane.showMessageDialog(null, "Bienvenido "+nombre+"");
                return valido = true;
            }
            JOptionPane.showMessageDialog(null, "Contraseña incorrecta");
            return valido;
        }
        JOptionPane.showMessageDialog(null, "Usuario inexistente");
        return valido;
    }

    @Override
    public float mostrarCosto(int nPaginas) {
        float costo = cotizar.calcularCosto(nPaginas);
        return costo;
    }

    @Override
    public float mostrarPrecioFisico(String nacionalidad, float costo) {
        float precioVenta = cotizar.calcularPrecioFisico(nacionalidad, costo);
        return precioVenta;
    }

    @Override
    public float mostrarPrecioDigital(float tamMegas, float costo) {
        float precioVenta = cotizar.calcularPrecioDigital(tamMegas, costo);
        return precioVenta;
    }
    
    @Override
    public boolean validarCadenaEntero(String cadena){
        Validadores validar = new Validadores();
        return validar.validaEntero(cadena);
    }
    
    @Override
    public boolean validarDecimal(String cadena){
        Validadores validar = new Validadores();
        return validar.validaDoble(cadena);
    }
}
