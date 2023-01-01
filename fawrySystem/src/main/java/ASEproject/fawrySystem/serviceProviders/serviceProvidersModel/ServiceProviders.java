package ASEproject.fawrySystem.serviceProviders.serviceProvidersModel;

import ASEproject.fawrySystem.serviceProviders.formModel.Form;

public interface ServiceProviders {

    public String getName();
    public int getId();


    public boolean handleForm(Form form);
    
}
