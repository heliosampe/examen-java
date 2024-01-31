package com.helio.examen2.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.helio.examen2.model.UsuarioPojo;
import com.helio.examen2.service.UsuarioService;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

    private final UsuarioService usuarioService;

    @Autowired
    public UsuarioController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    // Define el endpoint REST
    @GetMapping("/exportar-json")
    public ResponseEntity<String> exportarUsuariosJson() {
        // Obtener la lista de usuarios desde el servicio
    	
    	System.out.println("Solicitud GET recibida en /usuarios/exportar-json");
        List<UsuarioPojo> usuarios = usuarioService.obtenerUsuarios();
        // Crear un nuevo ObjectMapper y agregar el módulo
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.registerModule(new JavaTimeModule());

        System.out.println(usuarios != null);
        System.out.println(!usuarios.isEmpty());
        
        if (usuarios != null && !usuarios.isEmpty()) {
            // Llamar al método convertirUsuariosAJson con la lista de usuarios y el nuevo ObjectMapper
            String jsonUsuarios = usuarioService.convertirUsuariosAJson(usuarios, objectMapper);
            return ResponseEntity.ok(jsonUsuarios);
        } else {
            // Manejar el caso en que la lista de usuarios está vacía o nula
            return ResponseEntity.status(404).body("No hay usuarios para exportar.");
        }
    }
}