package dependency.injection;



/**
 * Created by pyshankov on 09.12.2016.
 */

public class Transporter {


    private TransportMethod transportMethod;

    //dependency injection, delegate dependency(property) initialization to someone another
    public Transporter(TransportMethod transportMethod) {
        this.transportMethod = transportMethod;
    }

    //anti-pattern, strong coupling to concrete implementation of dependency
    public Transporter() {
        this.transportMethod = new AirTransportMethod();
    }

    public TransportMethod getTransportMethod() {
        return transportMethod;
    }

    public void setTransportMethod(TransportMethod transportMethod) {
        this.transportMethod = transportMethod;
    }

    public void doTransport(String item){
        transportMethod.doTransport(item);
    }

}
