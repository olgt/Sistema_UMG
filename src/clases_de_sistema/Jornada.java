/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clases_de_sistema;

/**
 *
 * @author olgt1
 */
public class Jornada {
    private String nombre;
    private String diasDeClase[];

    public String[] getDiasDeClase() {
        return diasDeClase;
    }

    public String getNombre() {
        return nombre;
    }

    public void setDiasDeClase(String[] diasDeClase) {
        this.diasDeClase = diasDeClase;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    public void eliminar(){
        this.diasDeClase = null;
        this.nombre = null;
    }
    
    
}
