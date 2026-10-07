package com.example.demo2;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class ControladorInicio {
    private List<Usuario> baseFalsa = new ArrayList<>();

    public ControladorInicio(){
        baseFalsa.add(new Usuario("admin", 99));
    }

    @GetMapping("/prueba")
    public String probarServidor(){
        return "El servidor responde correctamente!";
    }

    @GetMapping("/perfil")
    public Usuario obtenerPerfil(){
        Usuario nuevoUsuario = new Usuario("Alejorro", 19);
        return nuevoUsuario;
    }

    @GetMapping("/usuarios")
    public List<Usuario> obtenerUsuarios(){
        return baseFalsa;
    }

    @PostMapping("/usuarios")
    public String registrarUsuario(@RequestBody Usuario nuevoUsuario){
        baseFalsa.add(nuevoUsuario);

        System.out.println("Ha llegado un nuevo usuario");
        System.out.println("Nombre: " + nuevoUsuario.getNombre());
        System.out.println("Edad: " + nuevoUsuario.getEdad());

        return "El usuario " + nuevoUsuario.getNombre() + " ha sido registrado exitosamente!";
    }
}
