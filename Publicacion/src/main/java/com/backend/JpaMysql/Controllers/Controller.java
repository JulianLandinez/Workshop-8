package com.backend.JpaMysql.Controllers;

import com.backend.JpaMysql.Dtos.CrearDto;
import com.backend.JpaMysql.Entities.Publicacion;
import com.backend.JpaMysql.Exceptions.RedSocialApiException;
import com.backend.JpaMysql.Services.ServicePublicaciones;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/publicacion")
public class Controller {
    private ServicePublicaciones servicePublicaciones;

    @Autowired
    public Controller(ServicePublicaciones servicePublicaciones) {
        this.servicePublicaciones = servicePublicaciones;
    }

    @PostMapping
    public Publicacion crearPublicacion(@RequestBody CrearDto dto){
        return this.servicePublicaciones.Crear(dto);

    }

    @GetMapping
    public List<Publicacion> ListarPublicacion(){
        return this.servicePublicaciones.listar();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> eliminarPublicacion(@PathVariable Publicacion id){
        return this.servicePublicaciones.eliminar(id);
    }
}
