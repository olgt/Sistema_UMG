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
public class Curso {
    private String nombre;
    private String descripcion;
    
    public Curso(String nombre, String descripcion){
        this.descripcion = descripcion;
        this.nombre = nombre;
    }

    public String getNombre(){
        return nombre;
    }

    public String getDescripcion(){
        return descripcion;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
        public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
        
    public void eliminar(){
        this.nombre = null;
        this.descripcion = null;
    }
  
}
