package ASEproject.fawrySystem.serviceProvidersService;

import java.lang.annotation.Annotation;

import org.springframework.stereotype.Service;

import ASEproject.fawrySystem.serviceProvidersModel.VodafoneMR;
import ASEproject.fawrySystem.serviceProvidersView.VodafoneMRview;


@Service
public class VodafoneMRservice extends MobileRechargeProService implements Service{

    private VodafoneMR model;
    private VodafoneMRview view;
    
    public VodafoneMRview getView() {
        return view;
    }

    public void setView(VodafoneMRview view) {
        this.view = view;
    }

    public VodafoneMR getModel() {
        return model;
    }

    public void setModel(VodafoneMR model) {
        this.model = model;
    }


    @Override
    public boolean handleForm() {
		char[] num=model.getMobileNum().toCharArray();
		
		if((model.getMobileNum().length()==8)&&(model.getCost()>0)) {
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
