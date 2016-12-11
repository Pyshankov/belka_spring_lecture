package dependency.injection;


/**
 * Created by pyshankov on 09.12.2016.
 */

public class AirTransportMethod implements TransportMethod {
    public void doTransport(String item) {
        System.out.println("use aircraft to transport: "+ item);
    }
}
