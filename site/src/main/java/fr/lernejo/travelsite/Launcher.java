package fr.lernejo.travelsite;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.Bean;
import retrofit2.Retrofit;

@SpringBootApplication(
    exclude = {DataSourceAutoConfiguration.class},
    scanBasePackages={"fr.lernejo.travelsite.services", "fr.lernejo.travelsite.controllers"}
)
public class Launcher {
    public static void main(String[] args) {
        SpringApplication.run(Launcher.class, args);
    }

    @Bean
    PredictionEngineClient predictionEngineClient() {
        Retrofit retrofit = new Retrofit.Builder()
            .baseUrl("http://localhost:7080/")
            .build();

        return retrofit.create(PredictionEngineClient.class);
    }
}


