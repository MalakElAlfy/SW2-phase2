package ASEproject.fawrySystem.serviceProviders.serviceProvidersModel;

import org.springframework.stereotype.Service;

import ASEproject.fawrySystem.serviceProviders.formModel.Form;

@Service
public class EtisalatMR extends MobileRechargePro{

    public EtisalatMR() {
		setName("Etisalat mobile recharge");
		id=2;
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
