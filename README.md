# Ecomart - Aplicación con Spring AI y OpenAI

## Descripción

**Ecomart** es una aplicación construida con **Spring Boot**, desarrollada como parte del curso "Spring AI: Integra una aplicación con OpenAI" del programa ONE de Alura Latam y Oracle. Integra la API de **OpenAI** para generar productos ecológicos, generar imágenes basadas en prompts y categorizar productos. Utilizando **Spring AI**, esta aplicación demuestra cómo interactuar con la API de OpenAI para realizar tareas como la generación de productos con nombres de animales, la creación de imágenes personalizadas y la categorización de productos en diversas categorías (por ejemplo, higiene personal, electrónicos, deportes, ropa, entre otros).

## Tecnologías Implementadas

- **Spring Boot**: Para la creación y configuración de la aplicación backend.
- **Spring AI**: Para integrar la inteligencia artificial en la aplicación, permitiendo la interacción con la API de OpenAI.
- **OpenAI API**: Para generar productos y realizar tareas de categorización de productos y generación de imágenes.
- **Maven**: Como herramienta de gestión de dependencias y construcción del proyecto.

## Endpoints

### 1. **Generación de Productos Ecológicos**
   - **Ruta**: `/generador`
   - **Método**: `GET`
   - **Descripción**: Genera 5 productos ecológicos con nombres de animales a partir de un prompt.
   
### 2. **Generación de Imágenes**
   - **Ruta**: `/imagen`
   - **Método**: `GET`
   - **Descripción**: Genera imágenes a partir de un prompt con opciones personalizadas (tamaño 1024x1024).
   
### 3. **Categorización de Productos**
   - **Ruta**: `/categorizador`
   - **Método**: `GET`
   - **Descripción**: Categoriza productos en las siguientes categorías:
     - Higiene personal
     - Electrónicos
     - Deportes
     - Ropa
     - Otros

## Dependencias

- **Spring Boot Starter Web**: Para crear aplicaciones web y servicios REST.
- **Spring AI OpenAI Starter**: Para integrar la API de OpenAI con Spring Boot.
- **Jtokkit**: Biblioteca para contar tokens en los mensajes enviados a la API de OpenAI.
- **Spring Boot DevTools**: Para mejorar la productividad en el desarrollo de la aplicación.
- **Spring Boot Starter Test**: Para realizar pruebas unitarias y de integración.

## Configuración

### Generación de la API Key de OpenAI

1. Regístrate en OpenAI y ve a [https://platform.openai.com/signup](https://platform.openai.com/signup).
2. Una vez registrado, ve a la sección de **API Keys** en [https://platform.openai.com/account/api-keys](https://platform.openai.com/account/api-keys).
3. Genera una nueva **API Key** y cópiala.

### Configuración de la API Key en la aplicación

En el archivo `application.properties`, agrega la siguiente línea para configurar tu clave API:

properties
spring.ai.openai.api-key=${GPT_KEY}

Donde ${GPT_KEY} debe ser reemplazado con tu clave API de OpenAI.

Nota importante: Para poder obtener una clave API de OpenAI, es necesario añadir un método de pago a tu cuenta de OpenAI. La API de OpenAI tiene costos asociados dependiendo del modelo y uso de la misma.

Otros parámetros importantes en application.properties:

## properties
  - Copiar
  - Editar
  - spring.application.name=ecomart
  - spring.ai.openai.chat.options.model=gpt-4o-mini
  - spring.ai.retry.max-attempts=10
  - spring.ai.retry.backoff.max=300
  - logging.level.org.springframework.ai.chat.client.advisor=DEBUG
  - spring.ai.openai.chat.options.model: Define el modelo de OpenAI a utilizar. En este caso, gpt-4o-mini es el modelo elegido para la categorización de productos.
  - spring.ai.retry.max-attempts: Número máximo de intentos para realizar una solicitud a la API de OpenAI.
  - spring.ai.retry.backoff.max: Tiempo máximo de espera entre intentos en milisegundos.
  - Consideraciones Adicionales
  - Método de Pago de OpenAI: Para poder acceder a la API de OpenAI, necesitarás asociar un método de pago a tu cuenta. OpenAI ofrece una cuota gratuita inicial, pero los costos aumentan según el uso y el modelo seleccionado.
  - G-estión de Errores: La aplicación está preparada para manejar errores de la API de OpenAI. Si se produce un error, se generarán logs que pueden ser útiles para depurar el problema. Asegúrate de revisar los logs para obtener detalles sobre cualquier fallo.
  - Tasa de Tokens: El modelo GPT-4 o Mini tiene un costo asociado que depende de la cantidad de tokens utilizados en la interacción. La aplicación incluye un contador de tokens que puede ayudarte a entender el impacto de las solicitudes.
  - Uso de Modelos de OpenAI: En esta aplicación, se utiliza el modelo gpt-4o-mini, pero es posible modificar la configuración para utilizar otros modelos más grandes, como gpt-4, dependiendo de tus necesidades y presupuesto.
  - Escalabilidad y Flexibilidad: La aplicación está diseñada para ser flexible y escalable. Se pueden agregar otros proveedores de IA modificando las dependencias en el archivo pom.xml y ajustando las configuraciones necesarias en application.properties.

