package ASEproject.fawrySystem.serviceProviders.serviceProvidersModel;

import org.springframework.stereotype.Service;

import ASEproject.fawrySystem.serviceProviders.formModel.Form;

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

    @Override
    public boolean handleForm(Form form)
    {
        return isHandle();
        
    }

    @Override
	public int getId() {
		// TODO Auto-generated method stub
		return id;
	}
    

}
