package ASEproject.fawrySystem.service;

import ASEproject.fawrySystem.service.servicesModel.Services;


public interface ServicesService
{
    public Services[] getListOfServices();
    public boolean addDiscount(int serviceID);
    public Object searchForService(String name);
    //public ServiceProviders selectServiceProvider(String name);
    public Services chooseService(String name);
    

    
  
}

