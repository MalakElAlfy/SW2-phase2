package ASEproject.fawrySystem.serviceProvidersView;

import java.util.Scanner;

import ASEproject.fawrySystem.serviceProvidersService.MonthlyRecService;

public class MonthlyRecView extends LandlineProView{

    private MonthlyRecService controller;


    public MonthlyRecService getController() {
        return controller;
    }


    public void setController(MonthlyRecService controller) {
        this.controller = controller;
    }


    @Override
    public boolean createForm() {
		System.out.println("Please enter the phone number:");
		Scanner input=new Scanner(System.in);
        Scanner input1=new Scanner(System.in);
		String phoneNum=input.nextLine();
		controller.getModel().setPhoneNum(phoneNum);
		System.out.println("Please enter the amount of money:");
		double cost=input1.nextDouble();
		controller.getModel().setCost(cost);
		return controller.handleForm();
	}
    
}
