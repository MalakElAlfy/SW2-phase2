package ASEproject.fawrySystem.serviceProviders.serviceProvidersModel;

import org.springframework.stereotype.Service;

@Service
public abstract class InternetPaymentPro implements ServiceProviders{

    public String name;
	public String mobileNum;
	public double cost;
	public int id;
	private boolean handle;

	public boolean isHandle() {
        return handle;
    }

    public void setHandle(boolean handle) {
        this.handle = handle;
    }

    public InternetPaymentPro(){}

	public void setCost(double cost) {
		this.cost=cost;
	}
	public double getCost() {
		return cost;
	}

	public void setName(String name) 
	{
		this.name=name;
	}

	public String getName() 
	{
		return name;
	}

	public void setMobileNum(String mobileNum) {
		this.mobileNum = mobileNum;
	}
	public String getMobileNum() {
		return mobileNum;
	}

    
}
