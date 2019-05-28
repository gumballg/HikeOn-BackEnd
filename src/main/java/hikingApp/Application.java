package hikingApp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class Application {
    public static void main(String[] args){
        System.out.println("Hiking App Backend");
        SpringApplication.run(Application.class, args);
    }
}
