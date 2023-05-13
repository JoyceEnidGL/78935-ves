package com.example.demo;

import java.util.ArrayList;
import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@SpringBootApplication
public class DemoApplication {

	//ArrayList<String> alumno = new ArrayList<String>();
	ArrayList<Profesores> profesor = new ArrayList<Profesores>();
	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	@RequestMapping("/")
	public String name1(){
		return "PROFESORES";
	}

	@RequestMapping(value = "/profesores", method = RequestMethod.POST)
	public String name2(){
		return "profesor creado";
	}

	@RequestMapping(value = "/profesores", method = RequestMethod.DELETE)
	public String name3(){
		return "profesor borrado";
	}

	@RequestMapping(value = "/profesores", method = RequestMethod.GET)
	public ArrayList<Profesores> name4(){
		//alumno.add("pepito");
		//alumno.add("sutanito");
		Profesores a = new Profesores(1,"Rojano","Tecnologias Web","f402");
		Profesores b = new Profesores(2,"Alessandra","Desarrollo Movil","f402");
		Profesores c = new Profesores(3,"Marinero","Programacion Avanzada","f402");
		profesor.add(a);
		profesor.add(b);
		profesor.add(c);
		
		return profesor;
	}
}
