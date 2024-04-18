package api.lojaapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
// @ComponentScan(basePackages = {"api.lojaapi", "", "api.lojaapi.mapper"})
public class LojaApiApplication {

    public static void main(String[] args) {
        SpringApplication.run(LojaApiApplication.class, args);
    }

}
