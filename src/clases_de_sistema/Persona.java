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
public abstract class Persona {
    public String nombre;
    public String no_celular;
    public String correo_electronico;

    public String getCorreo_electronico() {
        return correo_electronico;
    }

    public String getNo_celular() {
        return no_celular;
    }

    public String getNombre() {
        return nombre;
    }

    public void setCorreo_electronico(String correo_electronico) {
        this.correo_electronico = correo_electronico;
    }

    public void setNo_celular(String no_celular) {
        this.no_celular = no_celular;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    public void Eliminar(){
        this.correo_electronico = null;
        this.no_celular = null;
        this.nombre = null;
    }
}
