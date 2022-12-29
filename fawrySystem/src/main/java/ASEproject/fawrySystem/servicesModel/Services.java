package ASEproject.fawrySystem.servicesModel;

import org.springframework.stereotype.Component;

import ASEproject.fawrySystem.model.Discounts;
import ASEproject.fawrySystem.serviceProvidersModel.MobileRechargePro;
import ASEproject.fawrySystem.serviceProvidersModel.ServiceProviders;


@Component
public abstract class Services {

    protected Discounts specificDiscount;
    protected Discounts overAllDiscount;

    
    public String name;
    private int id;
    public double total=0;
    private boolean acceptsCOD;
    private boolean specificDisc;
    private boolean overAllDisc;
    
    public boolean isOverAllDisc() {
        return overAllDisc;
    }
    public void setOverAllDisc(boolean overAllDisc) {
        this.overAllDisc = overAllDisc;
    }
    public boolean isSpecificDisc() {
        return specificDisc;
    }
    public void setSpecificDisc(boolean specificDisc) {
        this.specificDisc = specificDisc;
    }
    
    public double calcTotal()
    {
        if(isSpecificDisc())
        {
            return total*=specificDiscount.calcTotal();

        }

        if(isOverAllDisc())
        {
            return total*=overAllDiscount.calcTotal();
        }
        return 0.0;
        
    }

    public boolean getAcceptsCOD() {
        return acceptsCOD;
    }

    public void setAcceptsCOD(boolean acceptsCOD) {
        this.acceptsCOD = acceptsCOD;
    }

    //public double calcTotal()
    //{
    //  return total;
    //};

	public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    
    public ServiceProviders selectServiceProvider(String name) {
        return null;
    }
    



}