package ASEproject.fawrySystem.serviceProvidersModel;

import org.springframework.stereotype.Service;

@Service
public class QuarterReciept extends LandlinePro
{

    public QuarterReciept() {
        setName("Quarter reciept");
        id=2;
    }
	public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    

}
