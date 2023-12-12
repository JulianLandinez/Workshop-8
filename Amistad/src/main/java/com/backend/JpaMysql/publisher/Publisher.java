package com.backend.JpaMysql.publisher;

import com.backend.JpaMysql.Dtos.CrearMensajeDto;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@EnableRabbit
public class Publisher {
    @Autowired
    private RabbitTemplate rabbitTemplate;


    @Autowired
    private Queue PublicacionAmistad;

    @Autowired
    private Queue mensajeAmistad;


    public void sendUsuario(Long id){
        this.rabbitTemplate.convertAndSend(PublicacionAmistad.getName(),id);


    }




    public void sendMensaje(Long idusuarioSolicitante) {
        this.rabbitTemplate.convertAndSend(mensajeAmistad.getName(),idusuarioSolicitante);

    }



}
