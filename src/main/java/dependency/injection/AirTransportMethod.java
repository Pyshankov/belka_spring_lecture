package dependency.injection;


import org.springframework.stereotype.Component;

/**
 * Created by pyshankov on 09.12.2016.
 */
@Component
public class AirTransportMethod implements TransportMethod {
    public void doTransport(String item) {
        System.out.println("use aircraft to transport: "+ item);
    }
}
