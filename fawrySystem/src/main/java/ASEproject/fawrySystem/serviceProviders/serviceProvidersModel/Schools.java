package ASEproject.fawrySystem.serviceProviders.serviceProvidersModel;

import org.springframework.stereotype.Service;

import ASEproject.fawrySystem.serviceProviders.formModel.Form;

@Service
public class Schools extends DonationsPro{


	public Schools()
    {
		setName("Schools");
		id=3;
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
