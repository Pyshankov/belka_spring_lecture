package inversion.control.aop;

import org.springframework.stereotype.Component;

import java.lang.reflect.Method;

/**
 * Created by pyshankov on 10.12.2016.
 */
@Component
public class LogAspect implements Log {

    public void doLog(Method method, String place) {
        System.out.println(place+":"+method.getName());
    }
}
