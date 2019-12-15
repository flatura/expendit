package code.flatura.expendit;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories("code.flatura.expendit.repository")
public class ExpenditApplication {

    public static void main(String[] args) {
        SpringApplication.run(ExpenditApplication.class, args);
    }
}