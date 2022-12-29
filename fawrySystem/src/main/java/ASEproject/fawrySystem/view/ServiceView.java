package ASEproject.fawrySystem.view;

import java.util.Scanner;

import ASEproject.fawrySystem.service.ServicesService;
import ASEproject.fawrySystem.service.ServicesServiceImp;
import ASEproject.fawrySystem.servicesModel.Services;

public class ServiceView {

    private ServicesServiceImp controller;

    public ServicesService getController() {
        return controller;
    }

    public void setController(ServicesServiceImp controller) {
        this.controller = controller;
    }

    public int displayServices()
	{
		int choice, id;
		Services listOfServices[]=new Services[4];
		listOfServices=controller.getListOfServices();
		
		for(int i=0;i<controller.getListOfServices().length;i++)
		{
			System.out.println((i+1)+ "- " + listOfServices[i].name);
		}
		
		System.out.println("Enter the number of service: ");
		
		Scanner input=new Scanner(System.in);
		choice=input.nextInt();
		
		choice--;
		
		id=listOfServices[choice].getId();
		
		return id;
		
		
	};
    
}
