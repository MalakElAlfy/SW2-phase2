package ASEproject.fawrySystem.serviceProviders.serviceProvidersModel;

import org.springframework.stereotype.Service;

import ASEproject.fawrySystem.serviceProviders.formModel.Form;

@Service
public class VodafoneMR extends MobileRechargePro
{
    public VodafoneMR()
    {
		setName("Vodafone mobile recharge");
		id=1;
	}

	@Override
    public boolean handleForm(Form form)
    {
        return isHandle();
        
    }

	@Override
	public int getId() {
		return id;
	}


    
}
