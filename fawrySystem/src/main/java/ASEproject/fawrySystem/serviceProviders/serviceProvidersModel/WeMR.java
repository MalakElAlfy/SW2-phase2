package ASEproject.fawrySystem.serviceProviders.serviceProvidersModel;

import org.springframework.stereotype.Service;

import ASEproject.fawrySystem.serviceProviders.formModel.Form;

@Service
public class WeMR extends MobileRechargePro{

    public WeMR()
	{
		setName("We mobile recharge");
		id=4;
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
