package com.santiagogomez.ecomart.controller;


import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.chat.prompt.ChatOptions;
import org.springframework.ai.chat.prompt.ChatOptionsBuilder;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/categorizador")
public class CategorizadorDeProductos {

    private final ChatClient chatClient;
    public CategorizadorDeProductos(ChatClient.Builder chatClientBuilder) {
        this.chatClient = chatClientBuilder.build();
    }

    @GetMapping
    public String categorizarProductos(String producto) {
        var system = "Tú eres un categorizador de productos";
        
        return this.chatClient.prompt()
            .system(system)
            .user(producto)
            .options(ChatOptionsBuilder.builder()
                    .withTemperature(0.7).build())
            .call()
            .content();
    }
}
