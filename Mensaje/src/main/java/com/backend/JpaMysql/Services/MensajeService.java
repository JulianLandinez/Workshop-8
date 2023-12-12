package com.backend.JpaMysql.Services;

import com.backend.JpaMysql.Dtos.CrearMensajeDto;
import com.backend.JpaMysql.Entities.Comentario;
import com.backend.JpaMysql.Entities.Mensaje;
import com.backend.JpaMysql.Entities.Publicacion;
import com.backend.JpaMysql.Entities.Usuario;
import com.backend.JpaMysql.Exceptions.RedSocialApiException;
import com.backend.JpaMysql.Repositories.ImensajesRepository;
import com.backend.JpaMysql.Repositories.IusuarioRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.StreamSupport;

@Service
public class MensajeService {
    IusuarioRepository repository;
    ImensajesRepository imensajesRepository;


    @Autowired
    public MensajeService(IusuarioRepository repository,ImensajesRepository imensajesRepository){
        this.repository=repository;
        this.imensajesRepository=imensajesRepository;

    }


    public Mensaje Crear(CrearMensajeDto dto){

        // implementamos una excepcion para que el contenido se obligatorio, pra que no sea nulo o vacio
        if (dto.getContenido() == null || dto.getContenido().isEmpty()) {
            throw new RedSocialApiException("El contenido del mensaje es obligatorio", HttpStatus.BAD_REQUEST);
        }

        //buscamos el emisor y en caso de no encontrarlo arrogar una excepcion

        Usuario emisor = this.repository
                .findById(dto.getEmisor())
                .orElseThrow(() -> new NoSuchElementException("El usuario solicitado no existe"));

        //buscamos el receptor y en caso de no encontrarlo arrogar una excepcion

        Usuario receptor = this.repository
                .findById(dto.getReceptor())
                .orElseThrow(() ->new NoSuchElementException("El usuario solicitado no existe"));


        // creamos el mensaje con los siguientes parametros
        Mensaje mensaje= new Mensaje(dto.getContenido(),emisor,receptor);


        // guardamos el mensaje y lo retornamos
        return this.imensajesRepository.save(mensaje);


    }


/*
    private Publicacion crearpublicacionpordefectoold(Long userid){
        RestTemplate template= new RestTemplate();
        CrearPublicacionDto publicacionDto=new CrearPublicacionDto("mi primera publicacion","el contenido",userid);
        ResponseEntity <Publicacion> ResponseEntity=template.postForEntity("http://localhost:8081/api/v1/publicacion", publicacionDto,Publicacion.class);
        return ResponseEntity.getBody();

    }

 */

    // creamos un metodo para listar todos los mensajes
    public List<Mensaje> listar(){
        // de esta forma se en lista las publicaciones con crudrepository
        return StreamSupport.stream(this.imensajesRepository.findAll().spliterator(),false)
                .toList();
    }


    // creamos un metodo para eliminar mensajes por el id, en caso de no existir el mensaje arrogar una excepcion
    public ResponseEntity<String> eliminar(Long id) {
        Mensaje mensaje = this.imensajesRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("El mensaje  no existe"));

        this.imensajesRepository.delete(mensaje);
        return new ResponseEntity<>("mensaje eliminado correctamente", HttpStatus.OK);
    }

}
