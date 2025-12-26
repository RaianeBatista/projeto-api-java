package one.digital.lab_padroes_projeto_spring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
Projeto Spring Boot gerado via Spring Initializr:
Os seguintes módulos foram selecionados:
- Spring Data JPA
- Spring Web
- H2 Database
- OpenFeign
@author RaianeBatista

http://localhost:8080/swagger-ui/index.html
*/

@EnableFeignClients
@SpringBootApplication
public class Application {

	public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
	}

}
