package ASEproject.fawrySystem.serviceProvidersService;
import java.lang.annotation.Annotation;

import org.springframework.stereotype.Service;

import ASEproject.fawrySystem.serviceProvidersModel.*;
import ASEproject.fawrySystem.serviceProvidersView.*;


@Service
public class CancerHospitalService extends DonationsProService implements Service{

	
	private CancerHospital model;
	private CancerHospitalView view;

	public CancerHospital getModel() {
		return model;
	}


	public void setModel(CancerHospital model) {
		this.model = model;
	}

	
	public CancerHospitalView getView() {
		return view;
	}


	public void setView(CancerHospitalView view) {
		this.view = view;
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
