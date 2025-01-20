package com.santiagogomez.ecomart.controller;


import org.springframework.ai.chat.client.ChatClient;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/generador")
public class GeneradorDeProductosController {

    private final ChatClient chatClient;
    public GeneradorDeProductosController(ChatClient.Builder chatClientBuilder) {
        this.chatClient = chatClientBuilder.build();
    }

    @GetMapping
    public String generadorDeProductos(String userInput) {
        var pregunta = "Genera 5 productos ecológicos con nombres de animales";
        return this.chatClient.prompt()
            .user(pregunta)
            .call()
            .content();
    }
}
