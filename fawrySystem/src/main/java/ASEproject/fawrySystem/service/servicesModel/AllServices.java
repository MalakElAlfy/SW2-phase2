package ASEproject.fawrySystem.service.servicesModel;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class AllServices {

    @Autowired
    public static Services[] listOfServices= new Services[4];

    public static Services[] getListOfServices() 
    {
        return listOfServices;
    }


    public AllServices()
    {
        MobileRecharge MR=new MobileRecharge();
        InternetPayment IP=new InternetPayment();
        LandlineServices LLS=new LandlineServices();
        Donations D=new Donations();

        listOfServices[0]=MR;
        listOfServices[1]=IP;
        listOfServices[2]=LLS;
        listOfServices[3]=D;

    }
    
}
