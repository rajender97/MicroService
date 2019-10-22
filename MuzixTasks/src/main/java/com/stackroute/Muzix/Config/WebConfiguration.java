
package com.stackroute.Muzix.Config;


//import org.h2.server.web.WebServlet;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import static springfox.documentation.builders.PathSelectors.regex;

import org.springframework.context.annotation.Profile;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
//@Profile("prod")
public class WebConfiguration {
  //  @Bean
    //ServletRegistrationBean h2ServletRegistration(){
      //  ServletRegistrationBean registrationBean = new ServletRegistrationBean(new WebdavServlet());
        //registrationBean.addUrlMappings("/console/*");
       // return registrationBean;

    @Bean
    public Docket productApi(){
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.stackrote.Muzix.Controller"))
                .paths(regex("/api.*"))
                .build();
    }


    }
