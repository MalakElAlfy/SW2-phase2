package ASEproject.fawrySystem.serviceProvidersService;

import java.lang.annotation.Annotation;

import org.springframework.stereotype.Service;

import ASEproject.fawrySystem.serviceProvidersModel.WeIP;
import ASEproject.fawrySystem.serviceProvidersView.WeIPview;


@Service
public class WeIPservice extends InternetPaymentProService implements Service{

    private WeIPview view;
    private WeIP model;

    public WeIP getModel() {
        return model;
    }

    public void setModel(WeIP model) {
        this.model = model;
    }

    public WeIPview getView() {
        return view;
    }

    public void setView(WeIPview view) {
        this.view = view;
    }

    public boolean handleForm() {
		char[] num=model.getMobileNum().toCharArray();
		
		if((model.getMobileNum().length()== 11)&&(num[0]==0)&&(num[1]==1)&&(num[2]==5)&&(model.getCost()>0)) {
			model.setHandle(true);
            return model.isHandle();
		}
		    model.setHandle(false);
            return model.isHandle();
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
