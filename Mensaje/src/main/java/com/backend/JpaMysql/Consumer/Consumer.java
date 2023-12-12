

package com.backend.JpaMysql.Consumer;

import com.backend.JpaMysql.Dtos.CrearMensajeDto;
import com.backend.JpaMysql.Services.MensajeService;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

@Component
public class Consumer {
    @Autowired
    MensajeService Service;

    @RabbitListener(queues = {"friend_message"})
    public void receive(@Payload Long usuarioSolicitante){
        CrearMensajeDto defaultDto = new CrearMensajeDto("han aceptado tu solicitud de amistad ya puedes iniciar una conversacion con tu nuevo amigo",usuarioSolicitante,usuarioSolicitante);
        this.Service.Crear(defaultDto);
    }

}


