package inversion.control;

import dependency.injection.AirTransportMethod;
import dependency.injection.RailTransportMethod;
import dependency.injection.TransportMethod;
import dependency.injection.Transporter;
import inversion.control.bpp.HelloWorldBeanPostProcessor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/**
 * Created by pyshankov on 09.12.2016.
 */
@Configuration
@ComponentScan("inversion.control")
public class ContextConfiguration {

    @Bean
    String helloWorld(){
        return "hello world!";
    }

    @Bean
    @Scope("prototype")
    TransportMethod railTransportMethod(){
        return new RailTransportMethod();
    }

    @Bean
    Transporter transporter(TransportMethod railTransportMethod){
        Transporter transporter = new Transporter(railTransportMethod);
        return transporter;
    }
    @Bean
    HelloWorldBeanPostProcessor helloWorldBeanPostProcessor(){
        return new HelloWorldBeanPostProcessor();
    }


}
