package com.backend.JpaMysql.Services;

import com.backend.JpaMysql.Dtos.CrearComentarioDto;
import com.backend.JpaMysql.Dtos.RespuestaComentarioDto;
import com.backend.JpaMysql.Entities.Comentario;
import com.backend.JpaMysql.Entities.Publicacion;
import com.backend.JpaMysql.Entities.Usuario;
import com.backend.JpaMysql.Exceptions.RedSocialApiException;
import com.backend.JpaMysql.Repositories.IcomentarioRepository;
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
public class UsuarioService {
    IusuarioRepository repository;
    IcomentarioRepository icomentarioRepository;
    IpublicacionRepository ipublicacionRepository;


    @Autowired
    public UsuarioService(IusuarioRepository repository,IcomentarioRepository icomentarioRepository,IpublicacionRepository ipublicacionRepository){
        this.repository=repository;
        this.icomentarioRepository=icomentarioRepository;
        this.ipublicacionRepository=ipublicacionRepository;

    }


    // se crea un metodo para obtener publicacion por id en caso de no existir arrogar una excepcion
    public Publicacion obtenerPublicacionPorId(Long publicacionId) {
        return ipublicacionRepository.findById(publicacionId)
                .orElseThrow(() -> new NoSuchElementException("La publicacion no existe"));
    }

    // se crea un metodo para crear el comentario

    public RespuestaComentarioDto Crear(CrearComentarioDto dto){

        // se verifica que el contenido no sea nulo y no este vacio
        if (dto.getContenido() == null || dto.getContenido().isEmpty()) {
            throw new RedSocialApiException("El contenido del comentario es obligatorio", HttpStatus.BAD_REQUEST);
        }

        // se busca el usuraio por id y en caso de no existir arrogar una excepcion

        Usuario usuario = this.repository
                .findById(dto.getUsuarioid())
                .orElseThrow(() -> new NoSuchElementException("El usuario solicitado no existe"));

        // se obtiene la publicacion por id
        Publicacion publicacion = obtenerPublicacionPorId(dto.getPublicacionid());

        // se crea el comentario
        Comentario nuevoComentario = new Comentario(dto.getContenido(),usuario,publicacion);
        // se guarda el comentario
         this.icomentarioRepository.save(nuevoComentario);
         // se crea la respuesta que va atener el cuerpo postman
        RespuestaComentarioDto respuestaComentarioDto = new RespuestaComentarioDto(
                publicacion.getId(),
                publicacion.getTitulo(),
                nuevoComentario.getContenido(),
                usuario.getId(),
                usuario.getNombre(),
                usuario.getApellido()


                );

         return respuestaComentarioDto;


    }


/*
    private Publicacion crearpublicacionpordefectoold(Long userid){
        RestTemplate template= new RestTemplate();
        CrearPublicacionDto publicacionDto=new CrearPublicacionDto("mi primera publicacion","el contenido",userid);
        ResponseEntity <Publicacion> ResponseEntity=template.postForEntity("http://localhost:8081/api/v1/publicacion", publicacionDto,Publicacion.class);
        return ResponseEntity.getBody();

    }

 */
        // se crea el metodo para listar todos los comentarios
    public List<Comentario> listar(){
        // de esta forma se en lista las publicaciones con crudrepository
        return StreamSupport.stream(this.icomentarioRepository.findAll().spliterator(),false)
                .toList();
    }


    // se crea este metodo para eliminar comentarios por id y en casod e no existir arrogar una excepcion
    public ResponseEntity<String> eliminar(Long id) {
        Comentario comentario = this.icomentarioRepository.findById(id)
                .orElseThrow(() -> new RedSocialApiException("el comentario no existe"));

        this.icomentarioRepository.delete(comentario);
        return new ResponseEntity<>("el comentario  se ha eliminado correctamente", HttpStatus.OK);
    }
}
