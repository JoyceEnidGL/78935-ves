package com.example.demo;

public class Alumnos {

    String nombre;
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    Integer edad;
    public Integer getEdad() {
        return edad;
    }
    /**
     * @param edad
     */
    public void setEdad(Integer edad) {
        this.edad = edad;
    }

    /**
     * @param nombre
     * @param edad
     */
    public Alumnos(String nombre, Integer edad){
        this.nombre = nombre;
        this.edad = edad;
    }

}