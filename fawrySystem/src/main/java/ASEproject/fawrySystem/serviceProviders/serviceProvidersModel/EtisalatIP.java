package ASEproject.fawrySystem.serviceProviders.serviceProvidersModel;

import org.springframework.stereotype.Service;

import ASEproject.fawrySystem.serviceProviders.formModel.Form;

@Service
public class EtisalatIP extends InternetPaymentPro{

  public EtisalatIP()
  {
    setName("Etisalat internet payment");
		id=2;
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
