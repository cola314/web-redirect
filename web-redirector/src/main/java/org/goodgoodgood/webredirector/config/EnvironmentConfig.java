package org.goodgoodgood.webredirector.config;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Getter
@Configuration
public class EnvironmentConfig {

    @Value("${environment.REDIRECT_URL}")
    private String redirectUrl;
}
