package com.iiiotwms.outbound;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {

    @Bean
    public OpenAPI outboundServiceOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("Outbound Service API")
                        .description("Sales Order and Shipment management APIs")
                        .version("1.0.0"));
    }
}
