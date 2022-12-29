package ASEproject.fawrySystem.serviceProvidersView;

import java.util.Scanner;

import ASEproject.fawrySystem.serviceProvidersService.EtisalatIPservice;

public class EtisalatIPview extends InternetPaymentProView{

private EtisalatIPservice controller;

public EtisalatIPservice getController() {
    return controller;
}

public void setController(EtisalatIPservice controller) {
    this.controller = controller;
}

    public boolean createForm() {
		System.out.println("Please enter the mobile number:");
		Scanner input=new Scanner(System.in);
        Scanner input1=new Scanner(System.in);

		String mobileNum=input.nextLine();
		controller.getModel().setMobileNum(mobileNum);
		System.out.println("Please enter the amount of money:");
		double cost=input1.nextDouble();
		controller.getModel().setCost(cost);
		return controller.handleForm();
	}
    
}
