package ASEproject.fawrySystem.serviceProvidersModel;

import org.springframework.stereotype.Service;

@Service
public abstract class LandlinePro implements ServiceProviders{

    public String name; 
	public String phoneNum;
	public double cost;
	public int id;
	private boolean handle;

    public LandlinePro() {}
	public boolean isHandle() {
        return handle;
    }
    public void setHandle(boolean handle) {
        this.handle = handle;
    }
	public void setCost(double cost) {
		this.cost=cost;
	}
	public double getCost() {
		return cost;
	}
	public void setPhoneNum(String phoneNum) {
		this.phoneNum = phoneNum;
	}	
	public String getPhoneNum() {
		return phoneNum;
	}
    
    
}
