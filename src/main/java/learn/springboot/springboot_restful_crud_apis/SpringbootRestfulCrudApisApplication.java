package learn.springboot.springboot_restful_crud_apis;

import io.swagger.v3.oas.annotations.ExternalDocumentation;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;
import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@OpenAPIDefinition(info = @Info(title = "Spring Boot Rest API Documentation",
        description = "Spring Boot Rest API Documentation",
        version = "v1.0",
        contact = @Contact(
                name = "Rakesh",
                email = "sample@api.com",
                url = "https://www.youtube.com"
        ),
        license = @License(
                name = "Apache 2.0",
                url = "https://www.google.com/apache"
        )),
        externalDocs = @ExternalDocumentation(
                description = "Spring Boot External Documentation with the description",
                url = "https://www.google.com/externalDocumentaion"
        )

)
public class SpringbootRestfulCrudApisApplication {

    @Bean
    public ModelMapper modelMapper() {
        return new ModelMapper();
    }

    public static void main(String[] args) {
        SpringApplication.run(SpringbootRestfulCrudApisApplication.class, args);
    }

}
