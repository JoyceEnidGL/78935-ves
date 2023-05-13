package uv.mx.salones.controllers;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import uv.mx.salones.models.Maestro;

@RestController
public class MaestroControlador {
    public final List<Maestro> maestros = new ArrayList<>();
    public final List<Maestro> maestros1 = new ArrayList<>();
    public final List<Maestro> maestros2 = new ArrayList<>();
    public final List<Maestro> maestros3 = new ArrayList<>();
    private final AtomicInteger counter = new AtomicInteger();

    Maestro maestro = new Maestro(counter.incrementAndGet(), "Carlos", "Perez", "Español", "f402");
    Maestro maestro2 = new Maestro(counter.incrementAndGet(), "Juan", "Suarez", "Calculo", "102");
    Maestro maestro3 = new Maestro(counter.incrementAndGet(), "Pedro", "Gutierrez", "Matematicas", "102");
    Maestro maestro4 = new Maestro(counter.incrementAndGet(), "Julian", "Chavez", "Programacion", "106");
    Maestro maestro5 = new Maestro(counter.incrementAndGet(), "Maria", "Alvarez", "Lectura y Redaccion", "102");
    Maestro maestro6 = new Maestro(counter.incrementAndGet(), "Fernando", "Garcia", "Calculo", "f402");

    @GetMapping("/maestros")
    public List<Maestro> verMaestros() {
        maestros.add(maestro);
        maestros.add(maestro2);
        maestros.add(maestro3);
        maestros.add(maestro4);
        maestros.add(maestro5);
        maestros.add(maestro6);
        return maestros;
    }

    public List<Maestro> verMaestros1() {
        maestros1.add(maestro);
        maestros1.add(maestro6);
        return maestros1;
    }

    public List<Maestro> verMaestros2() {
        maestros2.add(maestro2);
        maestros2.add(maestro3);
        maestros2.add(maestro5);
        return maestros2;
    }

    public List<Maestro> verMaestros3() {
        maestros3.add(maestro4);
        return maestros3;
    }

    @GetMapping("/maestros/{id}")
    public Maestro verMaestrosById(@PathVariable(value = "id") Integer id){
        return maestros.stream().filter(maestro -> maestro.getId().equals(id)).findFirst().orElse(null);
    }

    @DeleteMapping("/maestros/{id}")
    public void eliminarSalon(@PathVariable(value = "id") Integer maestroId) {
        Maestro maestro = verMaestrosById(maestroId);
        if (maestro.getId().equals(maestroId)) {
            maestros.remove(maestro);
        }
    }
}
