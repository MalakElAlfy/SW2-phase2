package ASEproject.fawrySystem.serviceProvidersService;

import java.lang.annotation.Annotation;

import org.springframework.stereotype.Service;

import ASEproject.fawrySystem.serviceProvidersModel.VodafoneIP;
import ASEproject.fawrySystem.serviceProvidersView.VodafoneIPview;


@Service
public class VodafoneIPservice extends InternetPaymentProService implements Service{

    private VodafoneIP model;
    private VodafoneIPview view;

    public VodafoneIPview getView() {
        return view;
    }

    public void setView(VodafoneIPview view) {
        this.view = view;
    }

    public VodafoneIP getModel() {
        return model;
    }

    public void setModel(VodafoneIP model) {
        this.model = model;
    }

    public boolean handleForm() {
		char[] num=model.getMobileNum().toCharArray();
		
		if((model.getMobileNum().length()== 11)&&(num[0]==0)&&(num[1]==1)&&(num[2]==0)&&(model.getCost()>0)) {
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
