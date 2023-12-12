package com.backend.JpaMysql.Services;

import com.backend.JpaMysql.Dtos.CrearAmistadDto;
import com.backend.JpaMysql.Dtos.CrearMensajeDto;
import com.backend.JpaMysql.Entities.Amistad;
import com.backend.JpaMysql.Entities.Usuario;
import com.backend.JpaMysql.Exceptions.RedSocialApiException;

import com.backend.JpaMysql.Repositories.IamistadRepository;
import com.backend.JpaMysql.Repositories.IusuarioRepository;

import com.backend.JpaMysql.publisher.Publisher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class AmistadService {
    IusuarioRepository repository;
    IamistadRepository iamistadRepository;
    Publisher publisher;


    @Autowired
    public AmistadService(IusuarioRepository repository, IamistadRepository iamistadRepository,Publisher publisher){
        this.repository=repository;
        this.iamistadRepository=iamistadRepository;
        this.publisher=publisher;



    }

    // se implementa el metodo para crear las amistades
    public ResponseEntity<String> Crear(CrearAmistadDto dto){
        // verificamos que la amistad exista
        boolean existeAmistad = iamistadRepository.existsBySolicitanteIdAndSolicitadoId(dto.getSolicitante(), dto.getSolicitado());
        // si la amistad existe no se puede crear la misma
        if (existeAmistad) {
            throw new RedSocialApiException("La amistad ya existe", HttpStatus.CONFLICT);
        }

        // se busca el solicitante y en caso de no existir se arroga una excepcion

            Usuario solicitante = this.repository
                    .findById(dto.getSolicitante())
                    .orElseThrow(() -> new RedSocialApiException("El usuario solicitante no existe", HttpStatus.NOT_FOUND));
        // se busca el solicitado y en caso de no existir se arroga una excepcion
            Usuario solicitado = this.repository
                    .findById(dto.getSolicitado())
                    .orElseThrow(() -> new NoSuchElementException("El usuario solicitado no existe"));

        //se crea la amistad
            Amistad amistad = new Amistad(dto.getIsaceptado(), dto.getDesde(), solicitante, solicitado);


        // si la amistad no es aceptada se arroga una excepxion para no crear la amistad
            if (!dto.getIsaceptado()){
                throw new RedSocialApiException("La amistad no se ha creado", HttpStatus.NOT_FOUND);

            }

            // se guarda la amistad

            Amistad savedAmistad = this.iamistadRepository.save(amistad);


            // se crea una publicacion para mostrarle al solicitante que tiene un nuevo amigo
            crearPublicacionPorDefecto(savedAmistad.getSolicitante().getId());

            // se crea un mensaje para mostrarle al solicitante que ya puede hablar con ese nuevo amigo
            crearMensajePorDefecto(savedAmistad.getSolicitante().getId());


            // retornamos una respuesta cuando se crea la amistad
            return new ResponseEntity<>("La amistad se ha creado", HttpStatus.OK);

    }


        // se crea el metodo para crear la publicacion por defecto
    public void crearPublicacionPorDefecto(Long solicitanteId) {
       this.publisher.sendUsuario(solicitanteId);
    }


    // se crea el metodo para crear el mensaje por defecto
    public void crearMensajePorDefecto(Long idUsuarioSolicitante) {

        this.publisher.sendMensaje(idUsuarioSolicitante);
    }








/*
    private Publicacion crearpublicacionpordefectoold(Long userid){
        RestTemplate template= new RestTemplate();
        CrearPublicacionDto publicacionDto=new CrearPublicacionDto("mi primera publicacion","el contenido",userid);
        ResponseEntity <Publicacion> ResponseEntity=template.postForEntity("http://localhost:8081/api/v1/publicacion", publicacionDto,Publicacion.class);
        return ResponseEntity.getBody();

    }

 */

    public List<Amistad> listar(){

        return iamistadRepository.findByIsaceptadoIsTrue();

        // de esta forma se en lista las publicaciones con crudrepository
       // return StreamSupport.stream(this.iamistadRepository.findAll().spliterator(),false)
          //      .toList();
    }

    public ResponseEntity<String> eliminar(Long id) {
        Amistad mensaje = this.iamistadRepository.findById(id)
                .orElseThrow(() -> new RedSocialApiException("La amistad no existe"));

        this.iamistadRepository.delete(mensaje);
        return new ResponseEntity<>("la amistad se ha eliminado correctamente", HttpStatus.OK);
    }

}
