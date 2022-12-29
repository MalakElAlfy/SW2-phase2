package ASEproject.fawrySystem.service;

import java.lang.annotation.Annotation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ASEproject.fawrySystem.model.Discounts;
import ASEproject.fawrySystem.servicesModel.Services;
import ASEproject.fawrySystem.view.DiscountsView;

@Service
public class DiscountsService extends Services{

   // @Autowired
    private Discounts model;
    private DiscountsView view;

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
    public DiscountsView getView() 
    {
        return view;
    }
    public void setView(DiscountsView view) {
        this.view = view;
    }
    
    public Discounts getModel() {
        return model;
    }

    public void setModel(Discounts model) {
        this.model = model;
    }

    public boolean addDiscount(int serviceID) 
    {
        return serviceController.addDiscount(serviceID);
    
    }

    public boolean addDiscountOnAll()
    {
        return serviceController.addDiscountOnAll();

    }
    

    
}
