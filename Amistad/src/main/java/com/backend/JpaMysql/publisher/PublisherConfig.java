package com.backend.JpaMysql.publisher;

import org.springframework.amqp.core.Queue;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class PublisherConfig {


    @Value("${redsocial.rabbit.queue.crearAmistad}")
    private String name1;

    @Value("${redsocial.rabbit.queue.enviarMensaje}")
    private String name2;




    @Bean
    public Queue PublicacionAmistad(){

        return new Queue(this.name1);

    }

    @Bean
    public Queue mensajeAmistad(){

        return new Queue(this.name2);

    }


}
