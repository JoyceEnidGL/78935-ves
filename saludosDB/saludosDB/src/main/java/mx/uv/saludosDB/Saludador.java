package mx.uv.saludosDB;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Saludador{
@Id//indicamos que es la llave primaria
@GeneratedValue(strategy = GenerationType.AUTO)//Define la estrategia de la notacion de los indices/
	private Integer id;
	private String nombre;
    
    public void setId(Integer id) {
        this.id = id;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public Integer getId() {
        return id;
    }
    public String getNombre() {
        return nombre;
    }
}