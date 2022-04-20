package com.api.customersupport.configs;

import com.api.customersupport.models.OrderServiceModel;
import com.api.customersupport.models.ResolverModel;
import com.fasterxml.classmate.TypeResolver;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

import java.util.ArrayList;

@Configuration
public class SwaggerConfig {

    @Bean
    public Docket scheduleApi(TypeResolver typeResolver) {
        return new Docket(DocumentationType.SWAGGER_2)
                .additionalModels(
                        typeResolver.resolve(ResolverModel.class),
                        typeResolver.resolve(OrderServiceModel.class)
                )
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.api.customersupport"))
                .paths(PathSelectors.regex("/.*"))
                .build()
                .apiInfo(metaInfo());
    }

    private ApiInfo metaInfo() {

        return new ApiInfo(
                "Incident API REST",
                "API REST de painel de resolvedores de incidentes.",
                "1.0",
                "Terms of Service",
                new Contact("José Souza", "https://www.linkedin.com/in/joseluisdesouza/",
                        "joseluisdesouzaa@gmail.com"),
                "Apache License Version 2.0",
                "https://www.apache.org/licesen.html", new ArrayList<>()
        );
    }
}
