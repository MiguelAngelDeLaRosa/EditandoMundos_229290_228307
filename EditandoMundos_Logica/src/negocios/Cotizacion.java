/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package negocios;

/**
 *
 * @author Miguel
 */
public class Cotizacion {

    public Cotizacion() {
    }
    
    public float calcularCosto(int nPaginas){
        float costoFinal = 0f;
        
        if(nPaginas < 300){
            return costoFinal = nPaginas*300f;
        } else {
            return costoFinal = nPaginas*200f;
        }
    }
    
    public float calcularPrecioFisico(String nacionalidad, float costo){
        float precioVenta = 0f;
        
        if(nacionalidad.equalsIgnoreCase("mexicano") || nacionalidad.equalsIgnoreCase("mexicana")){
            return precioVenta = costo + (costo*0.15f);
        } else {
            return precioVenta = costo + (costo*0.25f);
        }
    }
    
    public float calcularPrecioDigital(float tamMegas, float costo){
        float precioVenta = 0f;
        
        if(tamMegas <= 2.5){
            return precioVenta = costo + (costo*0.10f);
        } else {
            return precioVenta = costo + (costo*0.15f);
        }
    }
}
