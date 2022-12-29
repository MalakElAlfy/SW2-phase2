package ASEproject.fawrySystem.serviceProvidersService;

import java.lang.annotation.Annotation;

import org.springframework.stereotype.Service;

import ASEproject.fawrySystem.serviceProvidersModel.OrangeIP;
import ASEproject.fawrySystem.serviceProvidersView.OrangeIPview;

@Service
public class OrangeIPservice extends InternetPaymentProService implements Service{

    private OrangeIP model;
    private OrangeIPview view;

    public OrangeIPview getView() {
        return view;
    }

    public void setView(OrangeIPview view) {
        this.view = view;
    }

    public OrangeIP getModel() {
        return model;
    }

    public void setModel(OrangeIP model) {
        this.model = model;
    }

    public boolean handleForm() {
		char[] num=model.getMobileNum().toCharArray();
		
		if((model.getMobileNum().length()== 11)&&(num[0]==0)&&(num[1]==1)&&(num[2]==2)&&(model.getCost()>0)) {
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
