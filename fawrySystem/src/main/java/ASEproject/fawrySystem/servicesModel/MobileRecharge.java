package ASEproject.fawrySystem.servicesModel;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import ASEproject.fawrySystem.serviceProvidersModel.EtisalatMR;
import ASEproject.fawrySystem.serviceProvidersModel.MobileRechargePro;
import ASEproject.fawrySystem.serviceProvidersModel.OrangeMR;
import ASEproject.fawrySystem.serviceProvidersModel.ServiceProviders;
import ASEproject.fawrySystem.serviceProvidersModel.VodafoneMR;
import ASEproject.fawrySystem.serviceProvidersModel.WeMR;


@Component
public class MobileRecharge extends Services{


    @Autowired
    private MobileRechargePro[] listOfProviders=new MobileRechargePro[4];//= new ArrayList<MobileRechargePro>();

    public MobileRechargePro[] getListOfProviders() {
        return listOfProviders;
    }

    public void setListOfProviders(MobileRechargePro[] listOfProviders) {
        this.listOfProviders = listOfProviders;
    }

    public MobileRecharge()
    {

        MobileRechargePro  vodafone=new VodafoneMR();
        MobileRechargePro  etisalat=new EtisalatMR();
        MobileRechargePro  orange=new OrangeMR();
        MobileRechargePro  we=new WeMR();

        listOfProviders[0]=vodafone;
        listOfProviders[1]=etisalat;
        listOfProviders[2]=orange;
        listOfProviders[3]=we;
        
        setName("Mobile recharge");
        setAcceptsCOD(false);
        setId(1);
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
