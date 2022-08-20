/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.quasar.quasardemo.swaggerconfig;

import java.util.Collections;
import java.util.List;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.ApiKey;
import springfox.documentation.service.AuthorizationScope;
import springfox.documentation.service.Contact;
import springfox.documentation.service.SecurityReference;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spi.service.contexts.SecurityContext;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 *
 * @author Lenovo
 */

@EnableSwagger2
@Configuration
public class SwaggerConfig {
    
  @Bean
  public Docket springBootApis() {
    return new Docket(DocumentationType.SWAGGER_2)
        //.apiInfo(apiInfo())
        .securityContexts(Collections.singletonList(securityContext()))
        .securitySchemes(Collections.singletonList(apiToken()))
        .useDefaultResponseMessages(false) 
        .enable(true)
        .select()
        .apis(RequestHandlerSelectors.basePackage("com.quasar.quasardemo"))
        //.paths(PathSelectors.any())
        .build();
  }
  
  private ApiKey apiToken() {
    return new ApiKey("apiToken", "x-api-token", "header");
  }

  private SecurityContext securityContext() {
    return SecurityContext.builder().securityReferences(defaultAuth()).build();
  }

  private List<SecurityReference> defaultAuth() {
    AuthorizationScope authorizationScope = new AuthorizationScope("global", "accessEverything");
    AuthorizationScope[] authorizationScopes = new AuthorizationScope[1];
    authorizationScopes[0] = authorizationScope;
    return Collections.singletonList(new SecurityReference("merchantToken", authorizationScopes));
  }
  
  private ApiInfo apiInfo() {
    return new ApiInfo(
        "Your Backend Service APIs",
        "Description of your project.",
        "1.0",
        "",
        new Contact("Support", "", "christian.millan@correounivalle.edu.co"),
        "",
        "",
        Collections.emptyList());
  }
}
