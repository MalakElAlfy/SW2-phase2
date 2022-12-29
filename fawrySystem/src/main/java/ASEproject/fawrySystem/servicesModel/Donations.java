package ASEproject.fawrySystem.servicesModel;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import ASEproject.fawrySystem.serviceProvidersModel.CancerHospital;
import ASEproject.fawrySystem.serviceProvidersModel.DonationsPro;
import ASEproject.fawrySystem.serviceProvidersModel.NGO;
import ASEproject.fawrySystem.serviceProvidersModel.Schools;
import ASEproject.fawrySystem.serviceProvidersModel.ServiceProviders;

@Component
public class Donations extends Services{

    @Autowired
    private DonationsPro[] listOfProviders=new DonationsPro[3];

    public DonationsPro[]  getListOfProviders() {
        return listOfProviders;
    }

    public void setListOfProviders(DonationsPro[]  listOfProviders) {
        this.listOfProviders = listOfProviders;
    }

    public Donations()
    {
        DonationsPro  cancerHospital=new CancerHospital();
        DonationsPro  ngo=new NGO();
        DonationsPro  schools=new Schools();
    

        listOfProviders[0]=cancerHospital;
        listOfProviders[1]=ngo;
        listOfProviders[2]=schools;

        setName("Donations");
        setAcceptsCOD(true);
        setId(4);
    };

    public double calcTotal()
    {
        return total;
    };    

    @Override
    public ServiceProviders selectServiceProvider(String name) {

        name=name.toLowerCase();

        for(ServiceProviders s: getListOfProviders())
        {
            if(s.getName().toLowerCase().contains(name))
            return s;
        }
        return null;
    }
}
