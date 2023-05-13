package uv.mx.salones.controllers;

import org.springframework.web.bind.annotation.RestController;

import uv.mx.salones.models.Salon;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

@RestController
public class SalonControlador {
    MaestroControlador m = new MaestroControlador();

    private final List<Salon> salones = new ArrayList<>();
    private final AtomicInteger counter = new AtomicInteger();

    Salon salon = new Salon(counter.incrementAndGet(), "f402", "A", m.verMaestros1());
    Salon salon2 = new Salon(counter.incrementAndGet(), "102", "B", m.verMaestros2());
    Salon salon3 = new Salon(counter.incrementAndGet(), "106", "B", m.verMaestros3());

    @PostMapping("/salones")
    public Salon crearSalon(@RequestBody Salon salon) {
        salon.setId(counter.incrementAndGet());
        salon.setMaestros(m.maestros);
        salones.add(salon);
        return salon;
    }

    
     /*curl -X POST http://localhost:8080/salones/crear -H
     "Content-Type: application/json" -d "{"nombre":"f402","edificio":"A"}"
    */

    @GetMapping("/salones")
    public List<Salon> verSalones() {
        salones.add(salon);
        salones.add(salon2);
        salones.add(salon3);
        return salones;
    }
    // curl -v http://localhost:8082/spring-rest/foos/9

    @GetMapping("/salones/{id}")
    public Salon verSalonesById(@PathVariable(value = "id") Integer salonId) {
        return salones.stream().filter(salon -> salon.getId().equals(salonId)).findFirst().orElse(null);
    }

    /* @GetMapping("/salones/{nombre}")
    public Salon verSalonesByName(@PathVariable(value = "nombre") String nombre) {
        int i2=0;
        for(int i=1; salones.size()<=i; i++){
            if(nombre == salones.get(i).getNombre()){
                i2=i;
            }
        }
        return salones.get(i2);
    } */

    
    @GetMapping("/salones/f402")
     public Salon verSalones1() {
     return salones.get(0);
     }
     
     @GetMapping("/salones/102")
     public Salon verSalones2() {
     return salones.get(1);
     }
     
     @GetMapping("/salones/106")
     public Salon verSalones3() {
     return salones.get(2);
     } 
    

    @PutMapping("/salones/{id}")
    public Salon editarSalonById(@PathVariable(value = "id") Integer salonId, @RequestBody Salon actualizarSalon) {
        Salon salon = verSalonesById(salonId);
        if (salon != null) {
            salon.setNombre(actualizarSalon.getNombre());
            salon.setEdificio(actualizarSalon.getEdificio());
        }
        return salon;
    }
    // curl -d @request.json -H 'Content-Type: application/json' -X PUT
    // http://localhost:8082/spring-rest/foos/9

    @DeleteMapping("/salones/{id}")
    public void eliminarSalon(@PathVariable(value = "id") Integer salonId) {
        Salon salon = verSalonesById(salonId);
        if (salon.getId().equals(salonId)) {
            salones.remove(salon);
        }
    }
    // curl -X DELETE http://localhost:8082/spring-rest/foos/9

    @PatchMapping("salones/{id}")
    public Salon editarSalon(@PathVariable(value = "id") Integer salonId, @RequestBody Salon actualizarSalon) {
        Salon salon = verSalonesById(salonId);
        if (salones != null) {
            salon.setNombre(actualizarSalon.getNombre());
            salon.setEdificio(actualizarSalon.getEdificio());
        }
        return salon;
    }
}
