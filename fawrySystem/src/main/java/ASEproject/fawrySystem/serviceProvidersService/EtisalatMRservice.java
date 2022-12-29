package ASEproject.fawrySystem.serviceProvidersService;

import java.lang.annotation.Annotation;

import org.springframework.stereotype.Service;

import ASEproject.fawrySystem.serviceProvidersModel.EtisalatMR;
import ASEproject.fawrySystem.serviceProvidersView.EtisalatMRview;


@Service
public class EtisalatMRservice extends MobileRechargeProService{

    private EtisalatMR model;
    private EtisalatMRview view;
    
    public EtisalatMRview getView() {
        return view;
    }

    public void setView(EtisalatMRview view) {
        this.view = view;
    }

    public EtisalatMR getModel() {
        return model;
    }

    public void setModel(EtisalatMR model) {
        this.model = model;
    }


    @Override
	public boolean handleForm() {
		char[] num=model.getMobileNum().toCharArray();
		
		if((model.getMobileNum().length()== 11)&&(num[0]==0)&&(num[1]==1)&&(num[2]==1)&&(model.getCost()>0)) {
            model.setHandle(true);
			return model.isHandle();
		}
        else 
		{
             model.setHandle(false);
			 return model.isHandle();
        }
}


/* 
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
    */
}
