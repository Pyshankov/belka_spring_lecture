package dependency.injection;

import org.springframework.stereotype.Component;

/**
 * Created by pyshankov on 09.12.2016.
 */
public class RailTransportMethod implements TransportMethod {
    public void doTransport(String item) {
        System.out.println("use rail to transport: "+item);
    }
}
