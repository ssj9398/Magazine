package week.pro;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class SecondWeekApplication {

    public static void main(String[] args) {
        SpringApplication.run(SecondWeekApplication.class, args);
    }

}
