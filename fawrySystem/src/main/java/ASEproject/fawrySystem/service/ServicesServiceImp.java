package ASEproject.fawrySystem.service;
import java.lang.annotation.Annotation;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ASEproject.fawrySystem.serviceProvidersModel.ServiceProviders;
import ASEproject.fawrySystem.servicesModel.AllServices;
import ASEproject.fawrySystem.servicesModel.Donations;
import ASEproject.fawrySystem.servicesModel.InternetPayment;
import ASEproject.fawrySystem.servicesModel.LandlineServices;
import ASEproject.fawrySystem.servicesModel.MobileRecharge;
//import ASEproject.fawrySystem.servicesModel.Service;
import ASEproject.fawrySystem.servicesModel.Services;
import ASEproject.fawrySystem.util.Common;
import ASEproject.fawrySystem.view.ServiceView;

@Service

public class ServicesServiceImp implements ServicesService{

    //private ServiceView view;

    @Autowired
    private AllServices allServices;

    
    public AllServices getAllServices() {
        return allServices;
    }
    
    
    public void setAllServices(AllServices allServices) {
        this.allServices = allServices;
    }


    public ServicesServiceImp()
    {
        allServices= new AllServices();
    }
    
    @Override
    public Services[] getListOfServices() {
        
        return AllServices.getListOfServices();
    }
 

    /* 
    @Override
    public ServiceView getView() {
        //return view;
    }
    */

    @Override
    public void setView(ServiceView view) {
        //this.view = view;
    }

    @Override
    public boolean addDiscount(int serviceID) 
    {
        
        for(Services s: AllServices.getListOfServices())
        {

            if(s.getId()==serviceID)
            {
                s.setSpecificDisc(true);
                return true;
            }
        }

        return false;

    
    }

    @Override
    public boolean addDiscountOnAll()
    {
        for(Services s: AllServices.getListOfServices())
        {
            s.setOverAllDisc(true);
            return true;
        }
        return false;

    }


    
   @Override
   public Services searchForService(String name)
   {
        name=name.toLowerCase();

        for(Services s: getListOfServices())
        {
            if(s.getName().toLowerCase().contains(name))
            return s;
        }
        return null;
        
    }

    @Override
   public Services chooseService(String name)
   {
        name=name.toLowerCase();

        for(Services s: getListOfServices())
        {
            if(s.getName().toLowerCase().contains(name))
            return s;
        }
        return null;
        
    }







    
    
    

    
    
}

