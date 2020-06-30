package com.example.demo.configuration;

import org.springframework.boot.web.server.ErrorPage;
import org.springframework.boot.web.server.WebServerFactoryCustomizer;
import org.springframework.boot.web.servlet.server.ConfigurableServletWebServerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpStatus;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@org.springframework.context.annotation.Configuration
public class ConfigurationNotFound implements WebMvcConfigurer {

@Override
public void addViewControllers(ViewControllerRegistry registry) {
    registry.addViewController("/Login/Login").setViewName("Menu/Login");
}


@Bean
public WebServerFactoryCustomizer<ConfigurableServletWebServerFactory> containerCustomizer() {
    return container -> {
        container.addErrorPages(new ErrorPage(HttpStatus.NOT_FOUND,
                "/Login/Login"));
    };
  }

}