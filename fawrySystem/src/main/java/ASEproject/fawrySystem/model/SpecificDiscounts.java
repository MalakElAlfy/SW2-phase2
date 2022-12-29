package ASEproject.fawrySystem.model;

import org.springframework.stereotype.Component;

@Component
public class SpecificDiscounts extends Discounts{
    
    public double calcTotal()
    {
        return 0.8;
    };

}
