/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package comunicacion;

import Entidades.Autor;
import Entidades.Publicacion;
import Entidades.Usuario;
import java.util.List;

/**
 *
 * @author Miguel
 */
public interface IOperacion {
    
    public boolean registrarPublicacionTipoFisico(Autor autor, int nPaginas, String titulo, 
            int paginaInicial, String tipoPublicacion, String medioPago, String fechaInicio, String fechaEntrega);
    
    public boolean registrarPublicacionTipoDigital(Autor autor, int nPaginas, String titulo, 
            String tipoPublicacion, float tamMegas, String medioPago);
    
    public boolean registrarAutor(String nombre, int edad, String nacionalidad);
    
    public List<Publicacion> consultarPublicaciones();
    
    public List<Publicacion> consultarPublicacionesPorTitulo(String titulo);
    
    public List<Publicacion> consultarPublicacionesPorTipoPublicacion(String tipoPublicacion);
    
    public List<Publicacion> consultarPublicacionesPorFechaEntrega(String fechaEntrega);
    
    public List<Publicacion> consultarPublicacionesPorTipoPago(String tipoPago);
    
    public List<Autor> consultarAutores();
    
    public Usuario consultarTipoDeUsuario(String nombre);
    
    public boolean verificarUsuario(String nombre, String password);
    
    public boolean registrarUsuario(String nombreUsuario, String password, String nombreCliente, 
            String telefono, String direccion, String email, boolean esAutor);
    
    public float mostrarCosto(int nPaginas);
    
    public float mostrarPrecioFisico(String nacionalidad, float costo);
    
    public float mostrarPrecioDigital(float tamMegas, float costo);
    
    public boolean validarCadenaEntero(String cadena);
    
    public boolean validarDecimal(String cadena);
    
    public boolean validarTelefono(String cadena);
    
    public boolean validarEmail(String cadena);
    
    public boolean validarFecha(String cadena);
    
    public String[] calcularFechas(int nPaginas);
}
