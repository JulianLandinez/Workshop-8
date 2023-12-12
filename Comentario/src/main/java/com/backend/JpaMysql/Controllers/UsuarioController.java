package com.backend.JpaMysql.Controllers;

import com.backend.JpaMysql.Dtos.CrearComentarioDto;
import com.backend.JpaMysql.Dtos.RespuestaComentarioDto;
import com.backend.JpaMysql.Entities.Comentario;
import com.backend.JpaMysql.Entities.Publicacion;
import com.backend.JpaMysql.Entities.Usuario;
import com.backend.JpaMysql.Services.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/usuario")
public class UsuarioController {
    private UsuarioService service;

    @Autowired
    public UsuarioController(UsuarioService service) {
        this.service = service;
    }

    @PostMapping
    public RespuestaComentarioDto crearComentario(@RequestBody CrearComentarioDto dto){
        return this.service.Crear(dto);

    }

    @GetMapping
    public List<Comentario> Listarcomentarios(){
        return this.service.listar();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> eliminarPublicacion(@PathVariable Long id){
        return this.service.eliminar(id);
    }
}
