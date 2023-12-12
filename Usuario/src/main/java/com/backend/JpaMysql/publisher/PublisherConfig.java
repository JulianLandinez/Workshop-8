package com.backend.JpaMysql.publisher;

import org.springframework.amqp.core.Queue;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class PublisherConfig {
    @Value("${redsocial.rabbit.queue.crearUsuario}")
    private String name;


    @Bean
    public Queue publicacionUsuario(){

        return new Queue(this.name);

    }


}
