package fr.lernejo.travelsite;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(
    exclude = {DataSourceAutoConfiguration.class},
    scanBasePackages={"fr.lernejo.travelsite.services", "fr.lernejo.travelsite.controllers"}
)
public class Launcher {
    public static void main(String[] args) {
        SpringApplication.run(Launcher.class, args);
    }
}
