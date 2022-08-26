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
    private String temas[];
    private Horario horario;
    private Seccion seccion;

    public String getNombre(){
        return nombre;
    }

    public String[] getTemas() {
        return temas;
    }

    public Horario getHorario() {
        return horario;
    }

    public Seccion getSeccion() {
        return seccion;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setTemas(String[] temas) {
        this.temas = temas;
    }

    public void setHorario(Horario horario) {
        this.horario = horario;
    }

    public void setSeccion(Seccion seccion) {
        this.seccion = seccion;
    }
    
    public void eliminar(){
        this.nombre = null;
        this.temas = null;
    }
}
