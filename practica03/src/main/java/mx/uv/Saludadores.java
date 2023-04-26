package mx.uv;

import org.springframework.boot.autoconfigure.integration.IntegrationAutoConfiguration;

import jakarta.annotation.Generated;
import jakarta.xml.bind.annotation.XmlID;

@Entity
public class Saudadores {
    @XmlID
    @Id
    @GeneratedVolume(strategy = GenerationType.AUTO)
    private Integer id;
    private String nombre;

    public String getNombre(){
        return nombre;
    }
    public Integer getId(){
        return id;
    }
    public void setNombre(){
        this.nombre = nombre;
    }
    public void setId(){
        this.id = id;
    }
}
