package com.mitocode;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.service.VendorExtension;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.ArrayList;

@Configuration
@EnableSwagger2
public class SwaggerConfig {

    private static final Contact DEFAULT_CONTACT = new Contact("MitoCode Network", "https://www.mitocode.com","cursos@mitocodenetwork.com") ;

    private static final ApiInfo DEFAULT_API_INFO = new ApiInfo("Mediapp Api Documentacion", "Mediapp Api Documentacion", "1.0",
        "PREMIUN", DEFAULT_CONTACT,"Apache 2.0","https://www.apache.org/licenses/LICENSE-2.0",
                        new ArrayList<VendorExtension>()) ;

    @Bean
    public Docket api(){
        return new Docket(DocumentationType.SWAGGER_2).apiInfo(DEFAULT_API_INFO);
    }
}
