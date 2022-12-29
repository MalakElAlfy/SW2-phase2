package ASEproject.fawrySystem.service;
import java.lang.annotation.Annotation;
import java.util.ArrayList;

import org.springframework.stereotype.Service;

import ASEproject.fawrySystem.serviceProvidersModel.ServiceProviders;
import ASEproject.fawrySystem.servicesModel.Donations;
import ASEproject.fawrySystem.servicesModel.InternetPayment;
import ASEproject.fawrySystem.servicesModel.LandlineServices;
import ASEproject.fawrySystem.servicesModel.MobileRecharge;
import ASEproject.fawrySystem.servicesModel.Services;
//import ASEproject.fawrySystem.servicesModel.Service;
import ASEproject.fawrySystem.view.ServiceView;


public interface ServicesService
{
    public Services[] getListOfServices();
    //public void setListOfServices(ArrayList<Service> listOfServices);
    //public ServiceView getView() ;
    public void setView(ServiceView view);
    public boolean addDiscount(int serviceID);
    public boolean addDiscountOnAll();
    public Object searchForService(String name);
    //public ServiceProviders selectServiceProvider(String name);
    public Services chooseService(String name);

    
  
}

