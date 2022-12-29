package ASEproject.fawrySystem.model;

import org.springframework.stereotype.Component;

@Component
public class OverAllDiscount extends Discounts{

    public double calcTotal()
    {
        return 0.9;
    };
    
}
