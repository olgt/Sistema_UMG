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
public class Horario {
    private String hora_inicio;
    private String hora_fin;

    public String getHora_fin() {
        return hora_fin;
    }

    public String getHora_inicio() {
        return hora_inicio;
    }

    public void setHora_fin(String hora_fin) {
        this.hora_fin = hora_fin;
    }

    public void setHora_inicio(String hora_inicio) {
        this.hora_inicio = hora_inicio;
    }
    
    public void eliminar(){
        this.hora_fin = null;
        this.hora_inicio = null;
    }
}
