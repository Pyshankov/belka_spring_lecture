package inversion.control.aop;

import dependency.injection.Transporter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;

/**
 * Created by pyshankov on 10.12.2016.
 * defines a rule how to implement proxy for object
 */

public class LogInvocationHandler implements MethodInterceptor {

    private Log log;

    private Object replaceObj;

    public LogInvocationHandler(Log log, Object replaceObj) {
        this.log = log;
        this.replaceObj=replaceObj;
    }

    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        log.doLog(method,"before"); //<-joinpoint
        method.invoke(replaceObj,objects);
        log.doLog(method,"after");//<-joinpoint
        return o;
    }
}
