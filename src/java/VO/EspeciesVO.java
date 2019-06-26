/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package VO;

/**
 *
 * @author Admin
 */
public class EspeciesVO {

     private int especie;
    private String nombre;

    public EspeciesVO(int especie, String nombre) {
        this.especie = especie;
        this.nombre = nombre;
    }

    public EspeciesVO() {
    }

    public int getEspecie() {
        return especie;
    }

    public void setEspecie(int especie) {
        this.especie = especie;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

}
