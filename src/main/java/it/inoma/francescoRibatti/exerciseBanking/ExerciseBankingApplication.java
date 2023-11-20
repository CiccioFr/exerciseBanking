package it.inoma.francescoRibatti.exerciseBanking;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;


@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
public class ExerciseBankingApplication {

    public static void main(String[] args) {
        SpringApplication.run(ExerciseBankingApplication.class, args);
    }

}
