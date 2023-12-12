package com.backend.JpaMysql.Controllers;

import com.backend.JpaMysql.Dtos.CrearMensajeDto;
import com.backend.JpaMysql.Entities.Comentario;
import com.backend.JpaMysql.Entities.Mensaje;
import com.backend.JpaMysql.Services.MensajeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/mensaje")
public class MensajeController {
    private MensajeService service;

    @Autowired
    public MensajeController(MensajeService service) {
        this.service = service;
    }

    @PostMapping
    public Mensaje crearMensaje(@RequestBody CrearMensajeDto dto){
        return this.service.Crear(dto);

    }

    @GetMapping
    public List<Mensaje> ListarMensaje(){
        return this.service.listar();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> eliminarPublicacion(@PathVariable Long id){
        return this.service.eliminar(id);
    }
}
