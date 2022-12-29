package ASEproject.fawrySystem.servicesModel;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import ASEproject.fawrySystem.serviceProvidersModel.EtisalatIP;
import ASEproject.fawrySystem.serviceProvidersModel.InternetPaymentPro;
import ASEproject.fawrySystem.serviceProvidersModel.OrangeIP;
import ASEproject.fawrySystem.serviceProvidersModel.ServiceProviders;
import ASEproject.fawrySystem.serviceProvidersModel.VodafoneIP;
import ASEproject.fawrySystem.serviceProvidersModel.WeIP;

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
    }

    public double calcTotal()
    {
        return total;
    };

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
