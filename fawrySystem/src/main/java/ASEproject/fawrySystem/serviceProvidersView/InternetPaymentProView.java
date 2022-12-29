package ASEproject.fawrySystem.serviceProvidersView;

import ASEproject.fawrySystem.serviceProvidersService.InternetPaymentProService;

public class InternetPaymentProView {

 
    private InternetPaymentProService controller;

    public InternetPaymentProService getController() {
        return controller;
    }

    public void setController(InternetPaymentProService controller) {
        this.controller = controller;
    }

    public boolean createForm(){return false;}

    
    
}
