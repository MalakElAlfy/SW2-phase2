package ASEproject.fawrySystem.serviceProvidersView;

import java.util.Scanner;

import ASEproject.fawrySystem.serviceProvidersService.OrangeMRservice;

public class OrangeMRview extends MobileRechargeProView{

    private OrangeMRservice controller;

    public OrangeMRservice getController() {
        return controller;
    }

    public void setController(OrangeMRservice controller) {
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
