package mx.uv.fei.demo;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

@RestController
public class SaludarControlador {

    private String nombre;
    private Saludador saludador;

    // Ruta en sustantivo plural
    @GetMapping("/saludos")
    public String saludar() {
        return "¡hola mundo! " + (nombre != null ? nombre : "");
    }

    @GetMapping("/despedidas")
    public String adios() {
        return "¡Adiós mundo!";
    }

    @PostMapping("/nombramientos")
    public void nombre() {
        this.nombre = "Danna";
    }

    @PutMapping("/nombramientos")
    public void met1() {
        this.nombre = "Nuevo Nombre";
    }

    @DeleteMapping("/nombramientos")
    public void met2() {
        this.nombre = null;
    }

    @GetMapping("/saludar/{nombre}")
    public Saludador met3(@PathVariable String nombre) { 
        System.out.println(nombre); 
        return new Saludador(nombre);
    }

    @GetMapping("/saludar2/{nombreX}")
    public Saludador met4(@PathVariable("nombreX") String nombre) { 
        System.out.println(nombre); 
        return new Saludador(nombre);
    }

    @PostMapping("/crearSaludador")
    public String crearSaludador(@RequestBody String nombre) {
        this.saludador = new Saludador(nombre);
        return "Saludador creado: " + nombre;
    }

    @GetMapping("/obtenerSaludador")
    public Saludador obtenerSaludador() {
        return saludador;
    }

    // Método que mapea la raíz (/)
    @RequestMapping("/")
    public String raiz() {
        String contenido = """
            <h1> Menú de opciones </h1>
            <ul>
                <li> <a href='/saludos'>/saludos</a></li>
                <li> <a href='/despedidas'>/despedidas</a></li>
                <li> <a href='/nombramientos'>/nombramientos (P|P|D)</a> </li>
                <li> <a href='/saludar/default'>/saludar/{nombre}</a></li>
                <li> <a href='/saludar2/default2'>/saludar/{nombre}</a></li>
                <li> <a href='/crearSaludador'>/crearSaludador (Post - json)</a> </li>
                <li> <a href='/obtenerSaludador'>/obtenerSaludador</a></li>
                <li> <a href='/query1'>/query1?nombre=valor&paterno=valor2[&materno=valor3]</a></li>
                <li> <a href='/query2'>/query2[?nombre=valor]</a></li>
            </ul>
            """;
        return contenido;
    }
    @GetMapping("/query1")
    public String query1(@RequestParam String nombre){
        System.out.println(nombre);
        return nombre;
    }

    @GetMapping("/query2")
    public String query2(@RequestParam(defaultValue = "defaul") String nombre){
        System.out.println(nombre);
        return nombre;
    }
}