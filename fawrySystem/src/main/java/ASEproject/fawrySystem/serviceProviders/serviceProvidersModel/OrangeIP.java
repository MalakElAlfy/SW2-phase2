package ASEproject.fawrySystem.serviceProviders.serviceProvidersModel;

import org.springframework.stereotype.Service;

import ASEproject.fawrySystem.serviceProviders.formModel.Form;

@Service
public class OrangeIP extends InternetPaymentPro{

    public OrangeIP() 
	{
		setName("Orange internet payment");
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
