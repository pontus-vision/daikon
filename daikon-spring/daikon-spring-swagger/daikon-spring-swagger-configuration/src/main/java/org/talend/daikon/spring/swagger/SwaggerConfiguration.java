package org.talend.daikon.spring.swagger;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger.web.UiConfiguration;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfiguration {

    @Bean
    public Docket produceApi() {
        return new Docket(DocumentationType.SWAGGER_2).select().build();
    }

    @Bean
    public UiConfiguration uiConfig() {
        return new UiConfiguration(null, "list", "alpha", "example", //
                UiConfiguration.Constants.DEFAULT_SUBMIT_METHODS, false, true, 30000L);
    }
}
