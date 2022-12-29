package ASEproject.fawrySystem.serviceProvidersView;

import java.util.Scanner;

import ASEproject.fawrySystem.serviceProvidersService.NGOservice;

public class NGOview extends DonationsProView{

    private NGOservice controller;

    public NGOservice getController() {
        return controller;
    }

    public void setController(NGOservice controller) {
        this.controller = controller;
    }


    @Override
    public boolean createForm() {
		//System.out.println("Please enter the organization name:");
		//orgName=in.nextLine();
		//setOrgName(orgName);
		System.out.println("Please enter the amount of money:");
		Scanner in=new Scanner(System.in);
		double cost=in.nextDouble();
		controller.getModel().setCost(cost);
		return controller.handleForm();
	}
    
}
