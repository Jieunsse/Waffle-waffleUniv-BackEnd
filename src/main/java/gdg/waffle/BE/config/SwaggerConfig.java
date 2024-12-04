package gdg.waffle.BE.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {

    @Bean
    public OpenAPI openAPI() {
        Info info = new Info()
                .version("v1.0")
                .title("goStock API")
                .description("goStock 커뮤니티 프로젝트 API");

        return new OpenAPI()
                .info(info);
    }
}
