package ASEproject.fawrySystem.serviceProvidersService;

import java.lang.annotation.Annotation;

import org.springframework.stereotype.Service;

import ASEproject.fawrySystem.serviceProvidersModel.EtisalatIP;
import ASEproject.fawrySystem.serviceProvidersView.EtisalatIPview;


@Service
public class EtisalatIPservice extends InternetPaymentProService implements Service{

    private EtisalatIP model;
    private EtisalatIPview view;


    public EtisalatIPview getView() {
        return view;
    }

    public void setView(EtisalatIPview view) {
        this.view = view;
    }

    public EtisalatIP getModel() {
        return model;
    }

    public void setModel(EtisalatIP model) {
        this.model = model;
    }

    public boolean handleForm() {
		char[] num=model.getMobileNum().toCharArray();
		
		if((model.getMobileNum().length()== 11)&&(num[0]==0)&&(num[1]==1)&&(num[2]==1)&&(model.getCost()>0)) {
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
