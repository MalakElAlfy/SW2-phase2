package ASEproject.fawrySystem.serviceProviders.serviceProvidersModel;

import org.springframework.stereotype.Service;

import ASEproject.fawrySystem.serviceProviders.formModel.Form;

@Service
public class VodafoneIP extends InternetPaymentPro{

    public VodafoneIP() 
	{
		setName("Vodafone internet payment");
		id=1;
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
