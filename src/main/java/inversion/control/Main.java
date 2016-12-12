package inversion.control;

import dependency.injection.Transporter;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by pyshankov on 09.12.2016.
 */
public class Main {

    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(ContextConfiguration.class);
//        ApplicationContext context = new ClassPathXmlApplicationContext("context-config.xml");

        System.out.println(context.getBean("helloWorld"));

        Transporter transporter = context.getBean("transporter",Transporter.class);
        transporter.doTransport("my item");

        // вот так @PreDestroy для bean с singleton scope точно сработает, так как создали контекст вручную
        // то закрываем также
        ((ConfigurableApplicationContext)context).close();

    }
}