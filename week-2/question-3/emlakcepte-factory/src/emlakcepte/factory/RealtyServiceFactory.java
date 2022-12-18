package emlakcepte.factory;

import emlakcepte.interfaces.IRealtyService;
import emlakcepte.service.RealtyService;

public class RealtyServiceFactory {
    public IRealtyService getIRealtyService(String realtyServiceType){
        if(realtyServiceType==null){
            return null;
        }
        if(realtyServiceType.equalsIgnoreCase("REALTYSERVICE")){
            return  new RealtyService();
        }
        return null;
    }
}
