package com.hotelreservation.microservices.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Tag;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * Created by e068635 on 6/7/2019.
 */

@Configuration
@EnableSwagger2
public class SwaggerConfig {

    @Bean
    public Docket productApi() {
        return new Docket(DocumentationType.SWAGGER_2).select()
                .apis(RequestHandlerSelectors.basePackage("com.hotelreservation.microservices")).build()
                .apiInfo(apiInfo())
                .tags(new Tag("Room Services", "A set of services to provide data access to rooms."),
                        new Tag("tag2", "Tag 2 description."),
                        new Tag("tag2", "Tag 3 description."));
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder().title("Hotel rooms search engine").version("1.0.0").build();
    }
}
