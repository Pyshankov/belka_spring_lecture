package inversion.control.aop;

import java.lang.reflect.Method;

/**
 * Created by pyshankov on 10.12.2016.
 */
public interface Log {
    void doLog(Method method, String place);
}
