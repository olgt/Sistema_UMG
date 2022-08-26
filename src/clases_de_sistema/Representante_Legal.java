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
public class Representante_Legal extends Persona{
    private String id;
    private String titulo;

    public String getId() {
        return id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }
    
    public void eliminar(){
        this.id = null;
        this.titulo = null;
    }
}
