package ASEproject.fawrySystem.serviceProvidersView;

import java.util.Scanner;

import ASEproject.fawrySystem.serviceProvidersService.WeMRservice;

public class WeMRview extends MobileRechargeProView{

    private WeMRservice controller;

    public WeMRservice getController() {
        return controller;
    }

    public void setController(WeMRservice controller) {
        this.controller = controller;
    }

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
