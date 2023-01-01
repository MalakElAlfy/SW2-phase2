package ASEproject.fawrySystem.service.servicesModel;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import ASEproject.fawrySystem.serviceProviders.serviceProvidersModel.EtisalatIP;
import ASEproject.fawrySystem.serviceProviders.serviceProvidersModel.InternetPaymentPro;
import ASEproject.fawrySystem.serviceProviders.serviceProvidersModel.OrangeIP;
import ASEproject.fawrySystem.serviceProviders.serviceProvidersModel.ServiceProviders;
import ASEproject.fawrySystem.serviceProviders.serviceProvidersModel.VodafoneIP;
import ASEproject.fawrySystem.serviceProviders.serviceProvidersModel.WeIP;

@Component
public class InternetPayment extends Services{

    @Autowired
    private InternetPaymentPro[] listOfProviders=new InternetPaymentPro[4];

    public InternetPaymentPro[] getListOfProviders() {
        return listOfProviders;
    }

    public void setListOfProviders(InternetPaymentPro[] listOfProviders) {
        this.listOfProviders = listOfProviders;
    }

    public InternetPayment()
    {

        InternetPaymentPro  vodafone=new VodafoneIP();
        InternetPaymentPro  etisalat=new EtisalatIP();
        InternetPaymentPro  orange=new OrangeIP();
        InternetPaymentPro  we=new WeIP();

        listOfProviders[0]=vodafone;
        listOfProviders[1]=etisalat;
        listOfProviders[2]=orange;
        listOfProviders[3]=we;

        setName("Internet payment");
        setAcceptsCOD(false);
        setId(2);
        setSpecificDisc(true);
    }
/* 
    public double calcTotal()
    {
        return total;
    };
*/

    @Override
    public ServiceProviders selectServiceProvider(String name) 
    {
        name=name.toLowerCase();

        for(ServiceProviders s: getListOfProviders())
        {
            if(s.getName().toLowerCase().contains(name))
            return s;
        }
        return null;
        
    }
    
}
