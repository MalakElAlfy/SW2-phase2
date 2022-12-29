package ASEproject.fawrySystem.serviceProvidersService;

import java.lang.annotation.Annotation;

import org.springframework.stereotype.Service;

import ASEproject.fawrySystem.serviceProvidersModel.QuarterReciept;
import ASEproject.fawrySystem.serviceProvidersView.QuarterlyRecView;

@Service
public class QuarterlyRecService extends LandlineProService implements Service
{

    private QuarterReciept model;
    private QuarterlyRecView view;
    

    public QuarterlyRecView getView() 
    {
        return view;
    }


    public void setView(QuarterlyRecView view) 
    {
        this.view = view;
    }


    public QuarterReciept getModel()
    {
        return model;
    }


    public void setModel(QuarterReciept model) {
        this.model = model;
    }


    public boolean handleForm() {
		char[] num=model.getPhoneNum().toCharArray();
		
		if((model.getPhoneNum().length()==8)&&(model.getCost()>0)) {
            model.setHandle(true);;
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
    

