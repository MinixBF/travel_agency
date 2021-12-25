package fr.lernejo.travelsite;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@ComponentScan(basePackages = {"fr.lernejo.travelsite.services", "fr.lernejo.travelsite.controllers", "fr.lernejo.travelsite.repositories"})
@EnableJpaRepositories(basePackages = {"fr.lernejo.travelsite.repositories"})
@SpringBootApplication(
    exclude = {DataSourceAutoConfiguration.class},
    scanBasePackages={"fr.lernejo.travelsite.services", "fr.lernejo.travelsite.controllers", "fr.lernejo.travelsite.repositories"}
)
public class Launcher {
    public static void main(String[] args) {
        SpringApplication.run(Launcher.class, args);
    }
}
