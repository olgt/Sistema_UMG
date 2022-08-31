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
public class Estudiante extends Persona{
    private String carnet;
    private String anio_ingreso;
    private String password;
    
    public Estudiante(String nombre, String telefono, String correo, 
            String carnet, String anio_ingreso, String password){
        this.anio_ingreso = anio_ingreso;
        this.carnet = carnet;
        this.nombre = nombre;
        this.no_celular = no_celular;
        this.correo_electronico = correo;   
        this.password = password;
    }
    
    public String getAnio_ingreso() {
        return anio_ingreso;
    }

    public String getCarnet() {
        return carnet;
    }

    public String getPassword() {
        return password;
    }

    public void setAnio_ingreso(String anio_ingreso) {
        this.anio_ingreso = anio_ingreso;
    }

    public void setCarnet(String carnet) {
        this.carnet = carnet;
    }
    
    public void eliminar(){
        this.anio_ingreso = null;
        this.carnet = null;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    
    @Override
    public String toString(){
        return "Estudiantes(" + "Carnet: " + carnet + " Nombre: " + nombre + ")";
    }
}
