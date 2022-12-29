package ASEproject.fawrySystem.serviceProvidersView;

import java.util.Scanner;

import ASEproject.fawrySystem.serviceProvidersService.OrangeIPservice;

public class OrangeIPview extends InternetPaymentProView{

    private OrangeIPservice controller;

    public OrangeIPservice getController() {
        return controller;
    }

    public void setController(OrangeIPservice controller) {
        this.controller = controller;
    }

    public boolean createForm() {
		System.out.println("Please enter the mobile number:");
		Scanner input=new Scanner(System.in);
		String mobileNum=input.nextLine();
		controller.getModel().setMobileNum(mobileNum);
		System.out.println("Please enter the amount of money:");
		double cost=input.nextDouble();
		controller.getModel().setCost(cost);
		return controller.handleForm();
	}
    
}
