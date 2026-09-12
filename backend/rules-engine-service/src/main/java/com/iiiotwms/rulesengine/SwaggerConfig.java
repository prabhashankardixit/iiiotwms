package com.iiiotwms.rulesengine;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {

    @Bean
    public OpenAPI rulesEngineOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("Rules Engine & Putaway API")
                        .description("Warehouse rules engine and putaway strategy management APIs")
                        .version("1.0.0"));
    }
}
