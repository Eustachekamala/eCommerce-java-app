package com.eustachecode.eCommerce_java_app.config;

import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.OpenAPI;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {
    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("eCommerce API")
                        .version("1.0")
                        .description("API documentation for the eCommerce application")
                        .contact(new Contact()
                                .name("Eustache Kamala")
                                .email("eustachekamala@gmail.com")));
    }
}