package BibliotecaInclusiva.AtivIndividual.Config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenAPIConfig {

    @Bean
    public OpenAPI myOpenAPI(){
        Contact contato = new Contact();
        contato.setEmail("alcreis2303@gmail.com");
        contato.setName("Ana Luísa");
        contato.url("https://serratec.org/");

        License apacheLicense = new License()
                .name("Apache License")
                .url("https://www.apache.org/licenses/LICENSE-2.0");

        Info info = new Info()
                .title("API de Biblioteca Inclusiva")
                .version("1.0")
                .contact(contato)
                .description("API para cadastro, busca, atualização e exclusão de itens de uma biblioteca.")
                .termsOfService("https://serratec.org/")
                .license(apacheLicense);

        return  new OpenAPI().info(info);

    }
}
