package ASEproject.fawrySystem.serviceProvidersView;

import java.util.Scanner;

import ASEproject.fawrySystem.serviceProvidersService.SchoolsService;

public class SchoolsView extends DonationsProView{

    private SchoolsService controller;

    public SchoolsService getController() {
        return controller;
    }

    public void setController(SchoolsService controller) {
        this.controller = controller;
    }

    @Override
    public boolean createForm() 
    {

		//System.out.println("Please enter the school name:");
		//schoolName=input.nextLine();
		//setSchoolName(schoolName);

		System.out.println("Please enter the amount of money:");
		Scanner input=new Scanner(System.in);
		double cost=input.nextDouble();
		controller.getModel().setCost(cost);
		return controller.handleForm();
	}
    
}
