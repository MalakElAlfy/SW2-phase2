package ASEproject.fawrySystem.serviceProviders.serviceProvidersModel;

import org.springframework.stereotype.Service;

import ASEproject.fawrySystem.serviceProviders.formModel.Form;

@Service
public class WeIP extends InternetPaymentPro{

    public WeIP() 
	{
		setName("We internet payment");
		id=4;
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
