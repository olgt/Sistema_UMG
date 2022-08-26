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
public class Asignacion {
    private String fecha;
    private String id;
    private int pago;
    private Curso cursos[];
    private Jornada jornada;
    private Facultad facultad;
    private Estudiante estudiante;
    

    public String getFecha() {
        return fecha;
    }

    public String getId() {
        return id;
    }

    public int getPago() {
        return pago;
    }

    public Curso[] getCursos() {
        return cursos;
    }

    public Estudiante getEstudiante() {
        return estudiante;
    }

    public Facultad getFacultad() {
        return facultad;
    }

    public Jornada getJornada() {
        return jornada;
    }
    
    

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setPago(int pago) {
        this.pago = pago;
    }

    public void setCursos(Curso[] cursos) {
        this.cursos = cursos;
    }

    public void setEstudiante(Estudiante estudiante) {
        this.estudiante = estudiante;
    }

    public void setFacultad(Facultad facultad) {
        this.facultad = facultad;
    }

    public void setJornada(Jornada jornada) {
        this.jornada = jornada;
    }
    
    public void eliminar(){
        this.fecha = null;
        this.id = null;
        this.pago = 0;
        this.cursos = null;
        this.estudiante = null;
        this.facultad = null;
        this.jornada = null;
    }
}
