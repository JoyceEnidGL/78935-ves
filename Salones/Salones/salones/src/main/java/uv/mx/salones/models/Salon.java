package uv.mx.salones.models;

import java.util.List;

public class Salon {
    private Integer id;
    private String nombre;
    private String edificio;
    private List<Maestro> maestros;

    
    public Salon(Integer id, String nombre, String edificio, List<Maestro> maestros) {
        this.id = id;
        this.nombre = nombre;
        this.edificio = edificio;
        this.maestros = maestros;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEdificio() {
        return edificio;
    }

    public void setEdificio(String edificio) {
        this.edificio = edificio;
    }

    public List<Maestro> getMaestros() {
        return maestros;
    }

    public void setMaestros(List<Maestro> maestros) {
        this.maestros = maestros;
    }

}
