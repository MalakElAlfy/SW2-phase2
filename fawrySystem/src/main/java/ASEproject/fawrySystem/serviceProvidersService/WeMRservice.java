package ASEproject.fawrySystem.serviceProvidersService;

import java.lang.annotation.Annotation;

import org.springframework.stereotype.Service;

import ASEproject.fawrySystem.serviceProvidersModel.WeMR;
import ASEproject.fawrySystem.serviceProvidersView.WeMRview;


@Service
public class WeMRservice extends MobileRechargeProService implements Service{

    private WeMR model;
    private WeMRview view;
    
    public WeMRview getView() {
        return view;
    }
    public void setView(WeMRview view) {
        this.view = view;
    }
    public WeMR getModel() {
        return model;
    }
    public void setModel(WeMR model) {
        this.model = model;
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
