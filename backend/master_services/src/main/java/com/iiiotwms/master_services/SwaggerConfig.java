package com.iiiotwms.master_services;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {

    @Bean
    public OpenAPI masterServicesOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("Master Services API")
                        .description("Master data management APIs")
                        .version("1.0.0"));
    }
}
