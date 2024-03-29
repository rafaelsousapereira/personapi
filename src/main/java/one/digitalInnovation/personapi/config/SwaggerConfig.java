package one.digitalInnovation.personapi.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {

    // Configurações do Swagger 2

    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors
                        .basePackage("one.digitalInnovation.personapi.controller")
                )
                .paths(PathSelectors.any())
                .build()
                .apiInfo(buildApiInfo());
    }
    // configura o caminho para poder documentar a documentação

    private ApiInfo buildApiInfo() {
        return new ApiInfoBuilder()
                .title("API Person")
                .description("REST API Person para gerenciamento de pessoas.")
                .version("1.0.0")
                .contact(new Contact(
                        "Rafael Sousa Pereira",
                        "https://github.com/rafaelofficial",
                        "developer.rafael.sousa@gmail.com"))
                .build();
    }
    // informações da documentação
}
