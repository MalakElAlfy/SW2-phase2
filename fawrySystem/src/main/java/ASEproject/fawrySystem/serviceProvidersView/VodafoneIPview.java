package ASEproject.fawrySystem.serviceProvidersView;

import java.util.Scanner;

import ASEproject.fawrySystem.serviceProvidersService.VodafoneIPservice;

public class VodafoneIPview extends InternetPaymentProView{

    private VodafoneIPservice controller;


    public VodafoneIPservice getController() {
        return controller;
    }


    public void setController(VodafoneIPservice controller) {
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
