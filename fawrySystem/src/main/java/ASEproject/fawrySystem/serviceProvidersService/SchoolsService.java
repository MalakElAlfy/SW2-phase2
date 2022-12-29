package ASEproject.fawrySystem.serviceProvidersService;

import java.lang.annotation.Annotation;

import org.springframework.stereotype.Service;

import ASEproject.fawrySystem.serviceProvidersModel.Schools;
import ASEproject.fawrySystem.serviceProvidersView.SchoolsView;


@Service
public class SchoolsService extends DonationsProService implements Service{

    private Schools model;
    private SchoolsView view;
    
    public SchoolsView getView() {
        return view;
    }
    public void setView(SchoolsView view) {
        this.view = view;
    }
    public Schools getModel() {
        return model;
    }
    public void setModel(Schools model) {
        this.model = model;
    }
    @Override
    public Class<? extends Annotation> annotationType() {
        // TODO Auto-generated method stub
        return null;
    }
    @Override
    public String value() {
        // TODO Auto-generated method stub
        return null;
    }
    
}
