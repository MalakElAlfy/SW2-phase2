package ASEproject.fawrySystem.serviceProvidersModel;

import org.springframework.stereotype.Service;

@Service
public class VodafoneIP extends InternetPaymentPro{

    public VodafoneIP() 
	{
		setName("Vodafone internet payment");
		id=1;
	}
    
}
