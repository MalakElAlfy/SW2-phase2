package ASEproject.fawrySystem.serviceProvidersService;
import ASEproject.fawrySystem.serviceProvidersModel.InternetPaymentPro;
import ASEproject.fawrySystem.serviceProvidersView.InternetPaymentProView;

public abstract class InternetPaymentProService {
    
    private InternetPaymentPro model;
    private InternetPaymentProView view;

    public InternetPaymentProView getView() {
        return view;
    }

    public void setView(InternetPaymentProView view) {
        this.view = view;
    }

    public InternetPaymentPro getModel() {
        return model;
    }

    public void setModel(InternetPaymentPro model) {
        this.model = model;
    }

    public boolean handleForm() {return model.isHandle();}
}
