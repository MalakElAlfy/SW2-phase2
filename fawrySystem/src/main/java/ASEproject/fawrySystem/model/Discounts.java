package ASEproject.fawrySystem.model;

import org.springframework.stereotype.Component;

import ASEproject.fawrySystem.servicesModel.Services;


public abstract class Discounts extends Services{

    protected Services discountedService;

    public double calcTotal()
    {
        return discountedService.calcTotal();
    };
    
}
