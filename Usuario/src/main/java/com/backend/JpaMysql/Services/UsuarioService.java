package com.backend.JpaMysql.Services;

import com.backend.JpaMysql.Dtos.CrearUsuarioDto;
import com.backend.JpaMysql.Entities.Publicacion;
import com.backend.JpaMysql.Entities.Usuario;
import com.backend.JpaMysql.Exceptions.RedSocialApiException;

import com.backend.JpaMysql.Repositories.IamistadRepository;
import com.backend.JpaMysql.Repositories.IusuarioRepository;

import com.backend.JpaMysql.publisher.Publisher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.StreamSupport;

@Service
public class UsuarioService {
    IusuarioRepository repository;

    IamistadRepository iamistadRepository;
    Publisher publisher;

    @Autowired
    public UsuarioService(IusuarioRepository repository, Publisher publisher,IamistadRepository iamistadRepository){
        this.repository=repository;
        this.publisher=publisher;
        this.iamistadRepository=iamistadRepository;

    }

    // se implementa este metodo para crear un usuario

    public Usuario Crear(CrearUsuarioDto dto){

        // se busca si el usuario existe
        Usuario existe=this.repository.findByNombre(dto.getNombre());
        // se verifica si el usuario existe sino existe arrogar una excepcion
        if (existe != null){
            throw new RedSocialApiException("Usuario ya existe", HttpStatusCode.valueOf(400));
        }
        // el usuario no puede ser nulo o vacio
        if (dto.getNombre()==null || dto.getNombre().isEmpty() || dto.getApellido()==null || dto.getApellido().isEmpty()) {
            throw new RedSocialApiException("el nombre y el apellido es obligatorio", HttpStatus.BAD_REQUEST);

        }

        // se crea el usuario
        Usuario nuevoUsuario = new Usuario(dto.getNombre(), dto.getApellido(), dto.getDireccion(), dto.getEdad());
        // se guarda el usuario
        this.repository.save(nuevoUsuario);
        // se imprime el usuario
        System.out.println(nuevoUsuario);


       // se crea publicacion por defecto  al crear un usuario
        crearpublicacionpordefecto(nuevoUsuario.getId());
        return nuevoUsuario;
    }

/*
    public Amistad CrearPublicacionAmistad(CrearUsuarioDto dto){

        Usuario solicitante = this.repository
                .findById(dto.getI())
                .orElseThrow(() -> new RedSocialApiException("el usuario no existe"));

        Usuario solicitado = this.repository
                .findById(dto.getI())
                .orElseThrow(() -> new RedSocialApiException("el usuario no existe"));

        Amistad amistad = new Amistad(solicitante,solicitado);
        return this.iamistadRepository.save(amistad);
    }

 */

    // se implementa este metodo para crear por defecto la publicacion al crear el usuario
    public void crearpublicacionpordefecto(Long userid){
        this.publisher.sendUsuario(userid);

    }


/*
    private Publicacion crearpublicacionpordefectoold(Long userid){
        RestTemplate template= new RestTemplate();
        CrearPublicacionDto publicacionDto=new CrearPublicacionDto("mi primera publicacion","el contenido",userid);
        ResponseEntity <Publicacion> ResponseEntity=template.postForEntity("http://localhost:8081/api/v1/publicacion", publicacionDto,Publicacion.class);
        return ResponseEntity.getBody();
    }

 */
   // se crea este metodo para listar todos los usuarios
    public List<Usuario> listar(){
        // de esta forma se en lista las publicaciones con crudrepository
        return StreamSupport.stream(this.repository.findAll().spliterator(),false)
                .toList();
    }

    // se crea este metodo para eliminar por id el usuario

    public ResponseEntity<String> eliminar(Usuario id) {
        Usuario usuario = this.repository.findById(id.getId())
                .orElseThrow(() -> new NoSuchElementException("el usuario no existe"));

        this.repository.delete(usuario);
        return new ResponseEntity<>("Usuario eliminado correctamente", HttpStatus.OK);
    }
}



