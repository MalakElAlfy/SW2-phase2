package ASEproject.fawrySystem.serviceProviders.serviceProvidersModel;

import org.springframework.stereotype.Service;

@Service
public abstract class DonationsPro implements ServiceProviders{

    private String name;
	private double cost;
	public int id;
	private boolean handle;

	public DonationsPro() {}

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
    
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
