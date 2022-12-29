package ASEproject.fawrySystem.view;

import java.util.*;

import ASEproject.fawrySystem.model.RefundRequest;
import ASEproject.fawrySystem.service.AdminServiceImp;
import ASEproject.fawrySystem.servicesModel.Services;

public class AdminView {

    public AdminServiceImp controller;

    public AdminView( AdminServiceImp controller)
    {
        this.controller=controller;

    }

    

    public int displayAllServices()
    {

        Services listOfServices[]= new Services[4];
        listOfServices=controller.getServicesController().getListOfServices();

        for(Services s: listOfServices)
        {
            int i=1;
            System.out.println((i++) + "- " + s.name);
        }
        Scanner input=new Scanner(System.in);
        int choice=input.nextInt();

        choice--;
        int serviceID=listOfServices[choice].getId();
        return serviceID;

    }

    public void addDiscountsForm()
    {

        System.out.println("1- Over all");
        System.out.println("2- Specific");

        Scanner input=new Scanner(System.in);
        int choice=input.nextInt();

        switch(choice)
        {
            case 1:
            controller.addDiscountOnAll();

            case 2: 
            int serviceID=displayAllServices();
            controller.addDiscount(serviceID);
        }
       

    }

    
    public void printAdminDetails(String userName, String email){
        System.out.println("Name: " + userName);
        System.out.println("Email: " + email);
    }

    public void displayRequest(RefundRequest req) 
    {
        System.out.println("Request ID: " + req.getReqID());
        System.out.println("Transaction ID: " + req.getTransID());
        

    }

}
