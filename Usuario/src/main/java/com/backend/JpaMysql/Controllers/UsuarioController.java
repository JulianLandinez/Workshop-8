package com.backend.JpaMysql.Controllers;

import com.backend.JpaMysql.Dtos.CrearUsuarioDto;
import com.backend.JpaMysql.Entities.Usuario;
import com.backend.JpaMysql.Services.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/usuario")
public class UsuarioController {
    private final UsuarioService service;

    @Autowired
    public UsuarioController(UsuarioService service) {
        this.service = service;
    }

    @PostMapping
    public Usuario crearUsuario(@RequestBody CrearUsuarioDto dto){
        return this.service.Crear(dto);

    }


    @GetMapping
    public List<Usuario> ListarUsuarios(){
        return this.service.listar();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> eliminarUsuario(@PathVariable Usuario id){
        return this.service.eliminar(id);
    }
}
