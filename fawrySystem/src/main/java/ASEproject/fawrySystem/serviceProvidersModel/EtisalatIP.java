package ASEproject.fawrySystem.serviceProvidersModel;

import org.springframework.stereotype.Service;

@Service
public class EtisalatIP extends InternetPaymentPro{

  public EtisalatIP()
  {
    setName("Etisalat internet payment");
		id=2;
	}
    
}
