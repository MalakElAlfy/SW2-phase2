package ASEproject.fawrySystem.serviceProvidersService;
import org.springframework.stereotype.Service;

import ASEproject.fawrySystem.serviceProvidersModel.NGO;
import ASEproject.fawrySystem.serviceProvidersView.NGOview;

@Service
public class NGOservice extends DonationsProService {

    private NGO model;
    private NGOview view;
    
    public NGO getModel() {
        return model;
    }
    public void setModel(NGO model) {
        this.model = model;
    }
    public NGOview getView() {
        return view;
    }
    public void setView(NGOview view) {
        this.view = view;
    }
    
    
    
}
