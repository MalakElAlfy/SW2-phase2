package ASEproject.fawrySystem.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ASEproject.fawrySystem.model.transactionsModel.ActiveTransaction;
import ASEproject.fawrySystem.service.servicesModel.AllServices;
import ASEproject.fawrySystem.service.servicesModel.Services;
import ASEproject.fawrySystem.serviceProviders.formModel.CancerHospitalForm;
import ASEproject.fawrySystem.serviceProviders.formModel.EtisalatIPform;
import ASEproject.fawrySystem.serviceProviders.formModel.EtisalatMRform;
import ASEproject.fawrySystem.serviceProviders.formModel.Form;
import ASEproject.fawrySystem.serviceProviders.formModel.MonthlyRecieptForm;
import ASEproject.fawrySystem.serviceProviders.formModel.NGOform;
import ASEproject.fawrySystem.serviceProviders.formModel.OrangeIPform;
import ASEproject.fawrySystem.serviceProviders.formModel.QuarterRecieptForm;
import ASEproject.fawrySystem.serviceProviders.formModel.SchoolsForm;
import ASEproject.fawrySystem.serviceProviders.formModel.VodafoneIPform;
import ASEproject.fawrySystem.serviceProviders.formModel.VodafoneMRform;
import ASEproject.fawrySystem.serviceProviders.formModel.WeIPform;
import ASEproject.fawrySystem.serviceProviders.formModel.WeMRform;
import ASEproject.fawrySystem.serviceProviders.serviceProvidersModel.ServiceProviders;
import ASEproject.fawrySystem.util.Common;

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

    /*
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
    */


    
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


    

    public boolean hasSpecificDiscount(String serviceName) 
    {
        boolean status=false;
        serviceName=serviceName.toLowerCase();

        for(Services s: getListOfServices())
        {
            if(s.getName().toLowerCase().contains(serviceName))
            {
                if(s.isSpecificDisc())
                {
                    status=true;
                }
            }
        
            
        }
        return status;

        
    }


    public Form createCustomForm(Services wantedService, ServiceProviders wantedServiceProvider, ActiveTransaction activeTrans)
    {
        Form form=null;
        switch(wantedService.getId())
        {
            case 1:
            {
                if(wantedServiceProvider.getId()==1)
                {
                    form=new VodafoneMRform();
                    form.setAmountToPay(activeTrans.getAmountPaid());
                    form.setServiceProviderName(wantedServiceProvider.getName());
                    form.setMobileNumber(activeTrans.getMobile());

                    return form;  
                }
                else if(wantedServiceProvider.getId()==2)
                { 
                    form= new EtisalatMRform();
                    form.setAmountToPay(activeTrans.getAmountPaid());
                    form.setServiceProviderName(wantedServiceProvider.getName());
                    form.setMobileNumber(activeTrans.getMobile());

                    return form;  
                }
                else if(wantedServiceProvider.getId()==3)
                { 
                    form= new OrangeIPform();
                    form.setAmountToPay(activeTrans.getAmountPaid());
                    form.setServiceProviderName(wantedServiceProvider.getName());
                    form.setMobileNumber(activeTrans.getMobile());

                    return form;  
                }
                else 
                { 
                    form=new WeMRform();
                    form.setAmountToPay(activeTrans.getAmountPaid());
                    form.setServiceProviderName(wantedServiceProvider.getName());
                    form.setMobileNumber(activeTrans.getMobile());

                    return form;  
                }
                
            }
            case 2:
            {
                if(wantedServiceProvider.getId()==1)
                {
                    System.out.println("Hello");
                    form=new VodafoneIPform();
                    form.setAmountToPay(activeTrans.getAmountPaid());
                    form.setServiceProviderName(wantedServiceProvider.getName());
                    form.setMobileNumber(activeTrans.getMobile());

                    return form;  
                }
                else if(wantedServiceProvider.getId()==2)
                { 
                    form= new EtisalatIPform();
                    form.setAmountToPay(activeTrans.getAmountPaid());
                    form.setServiceProviderName(wantedServiceProvider.getName());
                    form.setMobileNumber(activeTrans.getMobile());

                    return form;  
                }
                else if(wantedServiceProvider.getId()==3)
                { 
                    form= new OrangeIPform();
                    form.setAmountToPay(activeTrans.getAmountPaid());
                    form.setServiceProviderName(wantedServiceProvider.getName());
                    form.setMobileNumber(activeTrans.getMobile());

                    return form;  
                    
                }
                else 
                { 
                    form=new WeIPform();
                    form.setAmountToPay(activeTrans.getAmountPaid());
                    form.setServiceProviderName(wantedServiceProvider.getName());
                    form.setMobileNumber(activeTrans.getMobile());

                    return form;  
                }

            }
            case 3:
            {
                if(wantedServiceProvider.getId()==1)
                {
                    form=new MonthlyRecieptForm();
                    form.setAmountToPay(activeTrans.getAmountPaid());
                    form.setServiceProviderName(wantedServiceProvider.getName());
                    form.setMobileNumber(activeTrans.getMobile());

                    return form;  
                }
                else if(wantedServiceProvider.getId()==2)
                { 
                    form= new QuarterRecieptForm();
                    form.setAmountToPay(activeTrans.getAmountPaid());
                    form.setServiceProviderName(wantedServiceProvider.getName());
                    form.setMobileNumber(activeTrans.getMobile());

                    return form;               
                }
                

            }
            case 4:
            {
                if(wantedServiceProvider.getId()==1)
                {
                    form=new CancerHospitalForm();
                    form.setAmountToPay(activeTrans.getAmountPaid());
                    form.setServiceProviderName(wantedServiceProvider.getName());

                    return form;               
                }
                else if(wantedServiceProvider.getId()==2)
                { 
                    form= new NGOform();
                    form.setAmountToPay(activeTrans.getAmountPaid());
                    form.setServiceProviderName(wantedServiceProvider.getName());

                    return form;
                }
                else
                {
                    form= new SchoolsForm();
                    form.setAmountToPay(activeTrans.getAmountPaid());
                    form.setServiceProviderName(wantedServiceProvider.getName());

                    return form;

                }
                


            }

        }
        return form;
    }







    
    
    

    
    
}

