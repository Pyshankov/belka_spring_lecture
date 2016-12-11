package inversion.control.bpp;

import dependency.injection.Transporter;
import inversion.control.aop.Log;
import inversion.control.aop.LogInvocationHandler;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.cglib.proxy.Enhancer;
import org.springframework.stereotype.Component;

/**
 * Created by pyshankov on 10.12.2016.
 */

public class HelloWorldBeanPostProcessor implements BeanPostProcessor {

    @Autowired
    Log logger;

    public Object postProcessBeforeInitialization(Object o, String s) throws BeansException {
        if(o instanceof String){
            System.out.println("before: "+o);
        }
        return o;
    }

    public Object postProcessAfterInitialization(Object o, String s) throws BeansException {
        if(o instanceof String){
            System.out.println("after: "+o);
        }
        if(o instanceof Transporter){
            o = Enhancer.create(Transporter.class,new LogInvocationHandler(logger,o));
        }
        return o;
    }
}
