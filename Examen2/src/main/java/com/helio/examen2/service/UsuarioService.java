package com.helio.examen2.service;

import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.helio.examen2.model.UsuarioPojo;




@Service
public class UsuarioService {
	private List<UsuarioPojo> usuarios; // Lista para almacenar los usuarios cargados desde el archivo
	private final ResourceLoader resourceLoader;
	
	@Autowired
    public UsuarioService(ResourceLoader resourceLoader) {
		this.resourceLoader = resourceLoader;
		
	}
	public void cargaDatosDesdeArchivo() {
	try {
		// Cargar el archivo desde el classpath
        InputStream inputStream = resourceLoader.getResource("classpath:data/texto.txt").getInputStream();
        List<String> lines = IOUtils.readLines(inputStream, StandardCharsets.UTF_8);

        usuarios = new ArrayList<>();
        
        for (String line : lines) {
            // Dividir la línea por el delimitador (por ejemplo, coma)
            String[] campos = line.split(",");
            System.out.println("Línea del archivo: " + line);
            // Crear una instancia de Usuario y asignar valores desde los campos
            UsuarioPojo usuarioPojo = new UsuarioPojo();
            usuarioPojo.setId(Long.parseLong(campos[0]));
            usuarioPojo.setClave(campos[1]);
            usuarioPojo.setTipo(campos[2]);
            usuarioPojo.setNombre(campos[3]);
            usuarioPojo.setUsername(campos[4]);
            usuarioPojo.setApellidoPaterno(campos[5]);
            usuarioPojo.setApellidoMaterno(campos[6]);
            usuarioPojo.setPassword(campos[7]);
            usuarioPojo.setTipoUsuario(campos[8]);
            
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"); // Ajusta el formato según tu archivo
            LocalDateTime fechaInicioSesion = LocalDateTime.parse(campos[9], formatter);
            
            usuarioPojo.setFechaInicioSesion(fechaInicioSesion);
            
            DateTimeFormatter formatterfin = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"); // Ajusta el formato según tu archivo
            LocalDateTime fechaFinSesion = LocalDateTime.parse(campos[10], formatterfin);
            usuarioPojo.setFechaFinSesion(fechaFinSesion);
            
            
            usuarioPojo.setTiempoEnLinea(campos[11]);
         // Asignar el campo 'estatus' como booleano
            usuarioPojo.setEstatus("1".equals(campos[12]));
            System.out.println("Línea del archivo: " + line);
            System.out.println("Nuevo usuario creado: " + usuarioPojo);
            usuarios.add(usuarioPojo);
        }

        // Cerrar el flujo de entrada
        inputStream.close();
    } catch (IOException e) {
        e.printStackTrace(); // Manejar la excepción adecuadamente en producción
	}
	
	
	
	}
    // Exportar a Json
    public String convertirUsuariosAJson(List<UsuarioPojo> usuarios) {
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            return objectMapper.writeValueAsString(usuarios);
        } catch (JsonProcessingException e) {
            e.printStackTrace(); // Manejar la excepción adecuadamente en producción
            return "Error al convertir usuarios a JSON";
        }
    }

    // Método para obtener la lista de usuarios cargados desde el archivo
    public List<UsuarioPojo> obtenerUsuarios() {
        return usuarios;
    }
}
