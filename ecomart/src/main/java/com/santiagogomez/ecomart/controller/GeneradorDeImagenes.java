package com.santiagogomez.ecomart.controller;


import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.image.ImageModel;
import org.springframework.ai.image.ImageOptionsBuilder;
import org.springframework.ai.image.ImagePrompt;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/imagen")
public class GeneradorDeImagenes {

    private final ImageModel imageModel;

    public GeneradorDeImagenes(ImageModel imageModel) {
        this.imageModel = imageModel;
    }

    @GetMapping
    public String generadorDeImagenes(String prompt) {
        var options = ImageOptionsBuilder.builder()
            .withHeight(1024)
            .withWidth(1024)
            .build();
        var response = imageModel.call(new ImagePrompt(prompt, options));
        return response.getResult().getOutput().getUrl();
    }
    
}
