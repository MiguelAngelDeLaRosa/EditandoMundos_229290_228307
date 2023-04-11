/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package negocios;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 *
 * @author Miguel
 */
public class CalculoFecha {
    
    
    public CalculoFecha(){
        
    }
    
    public String[] calcularFechas(int nPaginas){
        Calendar[] fechas = new Calendar[2];
        fechas[0] = Calendar.getInstance();
        fechas[1] = Calendar.getInstance();
        fechas[1].setTime(new Date());
        if (nPaginas < 500){
            fechas[1].add(Calendar.DAY_OF_MONTH, 3);
        }
        if (nPaginas > 500 && nPaginas < 1000){
            fechas[1].add(Calendar.DAY_OF_MONTH, 5);
        }
        if (nPaginas > 1000){
            fechas[1].add(Calendar.DAY_OF_MONTH, 7);
        }
        String fechaForm[] = new String[2];
        for (int i = 0; i < fechas.length; i++){
            Date date = fechas[i].getTime();
            SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
            fechaForm[i] = formato.format(date);
        }
        return fechaForm;
    }

}
