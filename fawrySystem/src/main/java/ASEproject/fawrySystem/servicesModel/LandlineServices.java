package ASEproject.fawrySystem.servicesModel;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import ASEproject.fawrySystem.serviceProvidersModel.LandlinePro;
import ASEproject.fawrySystem.serviceProvidersModel.MonthlyReciept;
import ASEproject.fawrySystem.serviceProvidersModel.QuarterReciept;
import ASEproject.fawrySystem.serviceProvidersModel.ServiceProviders;

@Component
public class LandlineServices extends Services{

    @Autowired
    private LandlinePro[] listOfProviders= new LandlinePro[2];

    public LandlinePro[] getListOfProviders() {
        return listOfProviders;
    }

    public void setListOfProviders(LandlinePro[] listOfProviders) {
        this.listOfProviders = listOfProviders;
    }

    public LandlineServices()
    {

        LandlinePro  monthly=new MonthlyReciept();
        LandlinePro  quarter=new QuarterReciept();
        
        listOfProviders[0]=monthly;
        listOfProviders[1]=quarter;
        

        setName("Landline");
        setAcceptsCOD(false);
        setId(3);
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
