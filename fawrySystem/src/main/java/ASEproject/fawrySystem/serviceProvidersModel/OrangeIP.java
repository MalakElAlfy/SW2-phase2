package ASEproject.fawrySystem.serviceProvidersModel;

import org.springframework.stereotype.Service;

@Service
public class OrangeIP extends InternetPaymentPro{

    public OrangeIP() 
	{
		setName("Orange internet payment");
		id=3;
	}
    
}
