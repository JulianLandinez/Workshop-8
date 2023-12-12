package com.backend.JpaMysql.Services;

import com.backend.JpaMysql.Dtos.CrearDto;
import com.backend.JpaMysql.Dtos.DtoAmistad;
import com.backend.JpaMysql.Entities.Publicacion;
import com.backend.JpaMysql.Entities.Usuario;
import com.backend.JpaMysql.Exceptions.RedSocialApiException;
import com.backend.JpaMysql.Repositories.IpublicacionRepository;
import com.backend.JpaMysql.Repositories.IusuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.StreamSupport;

@Service
public class ServicePublicaciones {
    IpublicacionRepository repository;
    IusuarioRepository iusuarioRepository;

    @Autowired
    public ServicePublicaciones(IpublicacionRepository repository, IusuarioRepository iusuarioRepository) {
        this.repository = repository;
        this.iusuarioRepository = iusuarioRepository;

    }
    // se implementa este metodo para crear una publicacion
    public Publicacion Crear(CrearDto dto) {
        // se busca el usuario existente de no existir arrogar excepcion
        Usuario usuario = this.iusuarioRepository
                .findById(dto.getUsuarioid())
                .orElseThrow(() ->new NoSuchElementException("El usuario solicitado no existe"));


        /*Publicacion existe = this.repository.findByTitulo(dto.getTitulo());
        if (existe != null) {
            throw new RedSocialApiException("post ya existe", HttpStatusCode.valueOf(400));
        }
        if (dto.getTitulo() == null || dto.getTitulo().isEmpty() || dto.getContenido() == null || dto.getContenido().isEmpty()) {
            throw new RedSocialApiException("el nombre y el apellido es obligatorio", HttpStatus.BAD_REQUEST);

        }

         */
        // se crea la publicacion
        Publicacion nuevaPublicacion = new Publicacion(dto.getTitulo(), dto.getContenido(), usuario);
       // se guarda la publicacion
        return this.repository.save(nuevaPublicacion);
    }
/*
    public Publicacion crearPublicacionAmistad(DtoAmistad dto){

        Usuario solicitado = this.iusuarioRepository.findByNombre(dto.getSolicitado());
        if (solicitado == null) {
            throw new RedSocialApiException("El usuario solicitado no existe");
        }


        Publicacion nuevaPublicacion = new Publicacion(dto.getTitulo(), dto.getContenido(), solicitado);
        return this.repository.save(nuevaPublicacion);

    }

 */

   // se crea un metodo para listar todas las publicaciones
    public List<Publicacion> listar(){
        // de esta forma se en lista las publicaciones con crudrepository
        return StreamSupport.stream(this.repository.findAll().spliterator(),false)
                .toList();



        // de esta forma genera un error por que se esta haciendo con  jparepository y en
        // la intrefaz ipublicacionesrepository está con crudrepository, se debe hacer con crudrepository
        //return this.repository.findAll();
    }

    // se crea el metodo para eliminar publicacion por id

    public ResponseEntity<String> eliminar(Publicacion id) {
        Publicacion publicacion = this.repository.findById(id.getId())
                .orElseThrow(() -> new NoSuchElementException("la publicacion no existe"));

        this.repository.delete(publicacion);
        return new ResponseEntity<>("Publicación eliminada correctamente", HttpStatus.OK);
    }


}
