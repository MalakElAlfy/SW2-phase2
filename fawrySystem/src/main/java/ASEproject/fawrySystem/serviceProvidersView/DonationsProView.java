package ASEproject.fawrySystem.serviceProvidersView;

import ASEproject.fawrySystem.serviceProvidersService.DonationsProService;

public class DonationsProView {

private DonationsProService controller;

public DonationsProService getController() 
{
    return controller;
}

public void setController(DonationsProService controller)
{
    this.controller = controller;
}

public boolean createForm()
{return false;}
    
}
