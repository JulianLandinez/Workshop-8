package com.backend.JpaMysql.Consumer;

import com.backend.JpaMysql.Dtos.CrearDto;
import com.backend.JpaMysql.Dtos.DtoAmistad;
import com.backend.JpaMysql.Exceptions.RedSocialApiException;
import com.backend.JpaMysql.Repositories.IpublicacionRepository;
import com.backend.JpaMysql.Services.ServicePublicaciones;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Component
public class Consumer {
    @Autowired
    ServicePublicaciones Service;

    @RabbitListener(queues = {"user_create"})
    public void recive(@Payload Long id){
        System.out.println("crear una publicacion para el usuario"+ id);
        CrearDto defaul=new CrearDto("Mi primera publicacion","contenido",id);
        this.Service.Crear(defaul);
    }


    @RabbitListener(queues = {"friend_created"})
    public void recivesolicitado(@Payload Long id){
        System.out.println("crear una publicacion para la nueva amistad"+ id);
        CrearDto defaul=new CrearDto("ahora tienes un nuevo amigo en tu red social ","contenido",id);
        this.Service.Crear(defaul);
    }






}
