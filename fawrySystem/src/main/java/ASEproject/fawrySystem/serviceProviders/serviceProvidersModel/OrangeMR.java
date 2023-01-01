package ASEproject.fawrySystem.serviceProviders.serviceProvidersModel;

import org.springframework.stereotype.Service;

import ASEproject.fawrySystem.serviceProviders.formModel.Form;

@Service
public class OrangeMR extends MobileRechargePro{

  public OrangeMR() 
  {
    setName("Orange mobile recharge");
		id=3;
	}

  @Override
    public boolean handleForm(Form form)
    {
        return isHandle();
        
    }

  @Override
  public int getId()
  {
    return id;
  }
    
}
