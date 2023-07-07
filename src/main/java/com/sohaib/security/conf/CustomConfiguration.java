package com.sohaib.security.conf;


import jakarta.annotation.PostConstruct;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Getter
@Configuration
@PropertySource(value="classpath:custom.properties",ignoreResourceNotFound=true)
// @RefreshScope
public class CustomConfiguration {

    private static CustomConfiguration configuration;


    @Value("${debug}")
    private String isModeDebug;

    @Value("${custom.prop}")
    private String msg;


    @PostConstruct
    public void init() {
        CustomConfiguration.setConfiguration(this);
    }

    private static void setConfiguration(CustomConfiguration conf) {
        CustomConfiguration.configuration = conf;
    }

    public static CustomConfiguration getConfiguration() {
        return CustomConfiguration.configuration;
    }

}
