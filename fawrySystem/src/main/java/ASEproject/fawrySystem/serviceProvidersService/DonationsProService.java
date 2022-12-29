package ASEproject.fawrySystem.serviceProvidersService;

//import ASEproject.fawrySystem.service.Service;
import ASEproject.fawrySystem.serviceProvidersModel.DonationsPro;
import ASEproject.fawrySystem.serviceProvidersView.DonationsProView;


public abstract class DonationsProService {

    private DonationsPro model;
    private DonationsProView view;

    public DonationsProView getView() {
        return view;
    }

    public void setView(DonationsProView view) {
        this.view = view;
    }

    public DonationsPro getModel() {
        return model;
    }

    public void setModel(DonationsPro model) {
        this.model = model;
    }

    public boolean createForm(){return false;}

    public boolean handleForm() {
		if(model.getCost()>0) {
			model.setHandle(true);
            return model.isHandle() ;
		}
		else 
        {
            model.setHandle(false);
            return model.isHandle() ;
        }
	}    
    
}
