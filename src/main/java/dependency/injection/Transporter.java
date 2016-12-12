package dependency.injection;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

/**
 * Created by pyshankov on 09.12.2016.
 */
@Component
public class Transporter {

    @Autowired
    private TransportMethod transportMethod;

    //dependency injection, delegate dependency(property) initialization to someone another
    public Transporter(TransportMethod transportMethod) {
        this.transportMethod = transportMethod;
    }

    //anti-pattern, strong coupling to concrete implementation of dependency
    public Transporter() {
//        this.transportMethod = new AirTransportMethod();
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

    @PostConstruct
    private void init(){
        System.out.println("init: "+this.getClass().getSimpleName());
    }

    @PreDestroy
    private void destroy(){
        System.out.println("destroy: "+this.getClass().getSimpleName());
    }

}
