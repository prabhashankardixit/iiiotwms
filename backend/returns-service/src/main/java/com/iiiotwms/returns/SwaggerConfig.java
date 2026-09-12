package com.iiiotwms.returns;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {

    @Bean
    public OpenAPI returnsServiceOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("Returns Service API")
                        .description("Reverse logistics and returns management APIs")
                        .version("1.0.0"));
    }
}
