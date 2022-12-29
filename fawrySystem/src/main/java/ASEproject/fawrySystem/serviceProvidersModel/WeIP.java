package ASEproject.fawrySystem.serviceProvidersModel;

import org.springframework.stereotype.Service;

@Service
public class WeIP extends InternetPaymentPro{

    public WeIP() 
	{
		setName("We internet payment");
		id=4;
	}
    
}
