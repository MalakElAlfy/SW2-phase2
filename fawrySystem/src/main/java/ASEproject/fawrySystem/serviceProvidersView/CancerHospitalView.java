package ASEproject.fawrySystem.serviceProvidersView;

import java.util.Scanner;

import ASEproject.fawrySystem.serviceProvidersService.CancerHospitalService;

public class CancerHospitalView extends DonationsProView{

    private CancerHospitalService controller;

    public CancerHospitalService getController() {
        return controller;
    }

    public void setController(CancerHospitalService controller) {
        this.controller = controller;
    }

    @Override
	public boolean createForm()
	{
		//System.out.println("Please enter the hospital name:");
		//String hospitalName=in.nextLine();
		
		System.out.println("Please enter the amount of money:");
		Scanner input=new Scanner(System.in);
		double cost=input.nextDouble();
		controller.getModel().setCost(0);;
		return controller.handleForm();
	}
    
}
