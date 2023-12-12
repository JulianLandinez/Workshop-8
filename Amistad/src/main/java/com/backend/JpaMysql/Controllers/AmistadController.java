package com.backend.JpaMysql.Controllers;

import com.backend.JpaMysql.Dtos.CrearAmistadDto;
import com.backend.JpaMysql.Entities.Amistad;
import com.backend.JpaMysql.Services.AmistadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/mensaje")
public class AmistadController {
    private AmistadService service;

    @Autowired
    public AmistadController(AmistadService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<String> crearAmistad(@RequestBody CrearAmistadDto dto) {

           return this.service.Crear(dto);


    }


    @GetMapping
    public List<Amistad> ListarAmistad(){
        return this.service.listar();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> eliminarAmistad(@PathVariable Long id){
        return this.service.eliminar(id);
    }
}
