package com.example.demo;

public class Profesores {
    Integer id;
    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    
    String nombre;
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    String materia;
    public String getMateria() {
        return materia;
    }
    public void setMateria(String materia) {
        this.materia = materia;
    }

    String salon;
    public String getSalon() {
        return salon;
    }
    public void setSalon(String salon) {
        this.salon = salon;
    }
    
    public Profesores(Integer id,String nombre, String materia, String salon){
        this.id = id;
        this.nombre = nombre;
        this.materia = materia;
        this.salon = salon;
    }
}
