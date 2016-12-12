package inversion.control;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * Created by pyshankov on 09.12.2016.
 */
@Configuration
@ComponentScan({"inversion.control","dependency.injection"})
public class ContextConfiguration {

    @Bean
    String helloWorld(){
        return "hello world!";
    }

}
