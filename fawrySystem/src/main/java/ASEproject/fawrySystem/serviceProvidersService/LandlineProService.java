package ASEproject.fawrySystem.serviceProvidersService;

import ASEproject.fawrySystem.serviceProvidersModel.LandlinePro;
import ASEproject.fawrySystem.serviceProvidersView.LandlineProView;

public abstract class LandlineProService {

    private LandlinePro model;
    private LandlineProView view;

    public LandlineProView getView() {
        return view;
    }

    public void setView(LandlineProView view) {
        this.view = view;
    }

    public LandlinePro getModel() {
        return model;
    }

    public void setModel(LandlinePro model) {
        this.model = model;
    }

    
}
