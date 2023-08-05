package com.etiya.crmlite;

import org.apache.catalina.connector.Connector;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.embedded.tomcat.TomcatConnectorCustomizer;
import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory;
import org.springframework.boot.web.servlet.server.ConfigurableServletWebServerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.support.ResourceBundleMessageSource;

@SpringBootApplication
public class CrmLiteApplication {
    public static void main(String[] args) {
        SpringApplication.run(CrmLiteApplication.class, args);
    }

    @Bean
    public ConfigurableServletWebServerFactory webServerFactory() {
        TomcatServletWebServerFactory factory = new TomcatServletWebServerFactory();
        factory.addConnectorCustomizers(new TomcatConnectorCustomizer() {
            @Override
            public void customize(Connector connector) {
                connector.setProperty("relaxedQueryChars", "|{}[]");
            }
        });
        return factory;
    }
    @Bean
    public ResourceBundleMessageSource bundleMessageSource(){
        // Veritabanı bağlantısı..
        // Dosyadan çekme işlemi..
        ResourceBundleMessageSource messageSource = new ResourceBundleMessageSource();
        // Konfigurasyonlar
        // Veritabanına git
        // Select * from Languages Where code='tr' and key='greetings'
        // isteğinden dönen cevap senin çevirindir.
        messageSource.setBasename("messages");
        //
        return messageSource;
    }
}