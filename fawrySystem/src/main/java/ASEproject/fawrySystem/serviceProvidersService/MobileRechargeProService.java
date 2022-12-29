package ASEproject.fawrySystem.serviceProvidersService;

import ASEproject.fawrySystem.serviceProvidersModel.MobileRechargePro;
import ASEproject.fawrySystem.serviceProvidersView.MobileRechargeProView;

public abstract class MobileRechargeProService {

    private MobileRechargePro model;
    private MobileRechargeProView view;

    public MobileRechargeProView getView() {
        return view;
    }

    public void setView(MobileRechargeProView view) {
        this.view = view;
    }

    public MobileRechargePro getModel() {
        return model;
    }

    public void setModel(MobileRechargePro model) {
        this.model = model;
    }

    public boolean handleForm() {return false;}

    
    
}
