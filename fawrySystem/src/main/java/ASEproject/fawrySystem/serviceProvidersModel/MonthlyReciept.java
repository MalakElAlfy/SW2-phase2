package ASEproject.fawrySystem.serviceProvidersModel;

import org.springframework.stereotype.Service;

@Service
public class MonthlyReciept extends LandlinePro
{
    

    public MonthlyReciept() {
        setName("Monthly reciept");
        id=1;
    }
	public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    
    
}
