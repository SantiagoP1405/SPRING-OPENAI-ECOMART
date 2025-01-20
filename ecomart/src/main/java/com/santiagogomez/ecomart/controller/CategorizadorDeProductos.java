package com.santiagogomez.ecomart.controller;


import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.chat.prompt.ChatOptions;
import org.springframework.ai.chat.prompt.ChatOptionsBuilder;
import org.springframework.web.bind.annotation.*;

import com.knuddels.jtokkit.Encodings;
import com.knuddels.jtokkit.api.EncodingRegistry;
import com.knuddels.jtokkit.api.EncodingType;
import com.knuddels.jtokkit.api.ModelType;


@RestController
@RequestMapping("/categorizador")
public class CategorizadorDeProductos {

    private String model = "gpt-4o-mini";

    private final ChatClient chatClient;
    public CategorizadorDeProductos(ChatClient.Builder chatClientBuilder) {
        this.chatClient = chatClientBuilder
                .defaultOptions(ChatOptionsBuilder
                        .builder()
                        .withModel(model)
                        .build())
                .build();
    }

    @GetMapping
    public String categorizarProductos(String producto) {
        var system = """
                Actúa como un categorizador de productos, y debes responder sólo el nombre de la categoría del producto informado

                Escoge una categoría de la siguiente lista:

                1.Higiene personal
                2. Electrónicos
                3. Deportes
                4. Ropa
                5. Otros

                Ejemplo de uso:
                Producto: Pelota de fútbol
                Respuesta: Deportes
                """;;
        
        var tokens = contadorDeTokens(system, producto);
        System.out.println(tokens);
        return this.chatClient.prompt()
            .system(system)
            .user(producto)
            .options(ChatOptionsBuilder.builder()
                    .withTemperature(0.7).build())
            .call()
            .content();
    }

    private int contadorDeTokens(String system, String user){
        var registry = Encodings.newDefaultEncodingRegistry();
        var enc = registry.getEncodingForModel(ModelType.GPT_4O_MINI);
        return enc.countTokens(system + user);
    }
}
