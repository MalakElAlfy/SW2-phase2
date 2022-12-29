package ASEproject.fawrySystem.serviceProvidersService;

import java.lang.annotation.Annotation;

import org.springframework.stereotype.Service;

import ASEproject.fawrySystem.serviceProvidersModel.MonthlyReciept;
import ASEproject.fawrySystem.serviceProvidersView.MonthlyRecView;


@Service
public class MonthlyRecService extends LandlineProService implements Service{


    private MonthlyReciept model;
    private MonthlyRecView view;

    public MonthlyRecView getView() {
        return view;
    }

    public void setView(MonthlyRecView view) {
        this.view = view;
    }

    public MonthlyReciept getModel() {
        return model;
    }

    public void setModel(MonthlyReciept model) {
        this.model = model;
    }


    public boolean handleForm() 
    {
		char[] num=model.getPhoneNum().toCharArray();
		
		if((model.getPhoneNum().length()==8)&&(model.getCost()>0)) {
			 model.setHandle(true);
             return model.isHandle();
		}
		else  
        {
            model.setHandle(false);
            return model.isHandle();

        }

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
