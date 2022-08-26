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
public class Seccion {
    private String nombre;
    private char letra;

    public char getLetra() {
        return letra;
    }

    public String getNombre() {
        return nombre;
    }

    public void setLetra(char letra) {
        this.letra = letra;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    public void eliminar(){
        this.letra = 0;
        this.nombre = null;
    }
}
