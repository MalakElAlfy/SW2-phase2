package ASEproject.fawrySystem.serviceProvidersView;

import java.util.Scanner;

import ASEproject.fawrySystem.serviceProvidersService.EtisalatMRservice;

public class EtisalatMRview extends MobileRechargeProView{

    private EtisalatMRservice controller;
 
    public EtisalatMRservice getController() {
        return controller;
    }

    public void setController(EtisalatMRservice controller) {
        this.controller = controller;
    }

    @Override
    public boolean createForm() {
		
		boolean status;
		System.out.println("Please enter the mobile number:");
		Scanner in=new Scanner(System.in);
		String mobileNum=in.nextLine();
		controller.getModel().setMobileNum(mobileNum);
		System.out.println("Please enter the amount of money:");
		double cost=in.nextDouble();
		controller.getModel().setCost(cost);
		status=controller.handleForm();
		
		return status;
	}
}
