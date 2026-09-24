package mx.uv.fei.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@SpringBootApplication
public class SaludarControlador {

    String nombre;

	@GetMapping("/getSaludo")
	public String saludar(){
		return "¡hola mundo! " + nombre;
	}
    @GetMapping("/getDespedida")
    public String adios(){
        return "Adiós mundo!";
    }
    @PostMapping("/postNombre")
    public void nombre(){
        String nombre = "Gus";
    }


}