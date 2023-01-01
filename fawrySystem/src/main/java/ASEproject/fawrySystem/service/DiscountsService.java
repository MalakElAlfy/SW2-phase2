package ASEproject.fawrySystem.service;

import java.lang.annotation.Annotation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ASEproject.fawrySystem.service.servicesModel.Services;


@Service
public class DiscountsService extends Services{

   

    @Autowired
    private ServicesServiceImp serviceController;

    
    public ServicesService getServiceController() 
    {
        return serviceController;
    }
    public void setServiceController(ServicesServiceImp serviceController) 
    {
        this.serviceController = serviceController;
    }
    
    
   

    public boolean addDiscount(int serviceID) 
    {
        return serviceController.addDiscount(serviceID);
    
    }

    
    

    
}
