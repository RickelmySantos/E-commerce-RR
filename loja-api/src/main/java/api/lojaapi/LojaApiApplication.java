package api.lojaapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("api.lojaapi")
public class LojaApiApplication {

    public static void main(String[] args) {
        SpringApplication.run(LojaApiApplication.class, args);
    }

}
