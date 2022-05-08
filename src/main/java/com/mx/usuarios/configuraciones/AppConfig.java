package com.mx.usuarios.configuraciones;

import java.text.SimpleDateFormat;
import java.util.Collections;

import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.data.web.config.EnableSpringDataWebSupport;
import org.springframework.util.StringUtils;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.mx.ipn.usuarios.dominio.bean.UsuariosBean;

import lombok.extern.slf4j.Slf4j;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;

@Configuration
@EnableSwagger2
@EnableSpringDataWebSupport
@EnableJpaAuditing(auditorAwareRef ="auditorAware")
@Slf4j
public class AppConfig implements WebMvcConfigurer{

	private final static Logger log = LoggerFactory.getLogger(UsuariosBean.class);

    @SuppressWarnings("deprecation")
	@Bean
    public ObjectMapper objectMapper() {
        log.info("Inicio Log");
        return new ObjectMapper().disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES)
                .disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS)
                .setPropertyNamingStrategy(PropertyNamingStrategy.SNAKE_CASE).findAndRegisterModules();
    }
    
    // Swagger
    @Bean
    public Docket apiDocket() {
        return new Docket(DocumentationType.SWAGGER_2)
        		.select()
                .apis(RequestHandlerSelectors
                		.basePackage("com.mx.usuarios.controladores"))
                .paths(PathSelectors.any())
                .build();
    }
	
	@SuppressWarnings("unused")
	private ApiInfo getApiInfo() {
		return new ApiInfo(
				"Order Service API",
				"Order Service API Description",
				"1.0",
				"http://codmind.com/terms",
				new Contact("mausanch", "https://github.com/mausanch", "msanchezm1409@alumno.ipn.mx"),
				"LICENSE",
				"LICENSE URL",
				Collections.emptyList()
				);
	}
	
	@Bean (name="SimpleDateTime")
	public SimpleDateFormat simpleDateTimeFormat (){
		return new SimpleDateFormat("dd/MM/yyyy");
    }

    
	@Bean
    public LocalValidatorFactoryBean validator(MessageSource messageSource) {
        LocalValidatorFactoryBean localValidatorFactoryBean = new LocalValidatorFactoryBean();
        localValidatorFactoryBean.setValidationMessageSource(messageSource);
        return localValidatorFactoryBean;
    }
   
 
    @Bean
    public ModelMapper modelMapper() {
        return new ModelMapper();
    } 
     
    @Bean
    public WebMvcConfigurer corsConfigurer() {
		return new WebMvcConfigurer() {
			@Override
			public void addCorsMappings(CorsRegistry registry) {
				registry.addMapping("/proveedores/**")
                .allowedOrigins("http://localhost:4200","http://localhost:4201")
                .allowedMethods("OPTIONS","POST","GET","PUT","PATCH","DELETE");
			}
		};
	}

}