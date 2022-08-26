/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clases_de_sistema;
import java.io.*;
import java.lang.*;
import java.util.*;

/**
 *
 * @author olgt1
 */
public class Registro_Universidad {
    private String id;
    private String fecha;
    private List<Asignacion> asignaciones = new ArrayList<Asignacion>();
    private List<Estudiante> estudiantes = new ArrayList<Estudiante>();
    private List<Catedratico> catedraticos = new ArrayList<Catedratico>();
    
    public String getId() {
        return id;
    }

    public String getFecha() {
        return fecha;
    }

    public List<Asignacion> getAsignaciones() {
        return asignaciones;
    }

    public List<Estudiante> getEstudiantes() {
        return estudiantes;
    }

    public List<Catedratico>  getCatedraticos() {
        return catedraticos;
    }
    
    
    
    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setAsignaciones(List<Asignacion> asignaciones) {
        this.asignaciones = asignaciones;
    }

    public void setEstudiantes(List<Estudiante> estudiantes) {
        this.estudiantes = estudiantes;
    }

    public void setCatedraticos(List<Catedratico> catedraticos) {
        this.catedraticos = catedraticos;
    }
    
    public void Eliminar(){
        this.fecha = null;
        this.id = null;
        this.asignaciones = null;
    }
    
    public void registrarEstudiante(Estudiante nuevoEstudiante){
        this.estudiantes.add(nuevoEstudiante);
    }
    
    public boolean devolverStatusIngreso(String correo, String password){
        String correoActual = null;
        String passwordActual = null;
        
        for (int i = 0; i < this.estudiantes.size(); i++) {
            correoActual = estudiantes.get(i).getCorreo_electronico();
            passwordActual = estudiantes.get(i).getPassword();
            System.out.println("Credenciales Actuales : " + correoActual + " " + passwordActual);
            if(correoActual.equals(correo) & password.equals(password)){
                return true;
            }
        }
        System.out.println("Credenciales ingresadas: " + correo + " " + password);
        return false;
    }
    
    public void ImprimirEstudiantes(){
        for(int i = 0; i<this.estudiantes.size(); i++){
            System.out.println(this.estudiantes.get(i).getCorreo_electronico());
        }
    }
}
