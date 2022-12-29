package ASEproject.fawrySystem.view;

import java.util.Scanner;

import ASEproject.fawrySystem.service.UserServiceImp;
import ASEproject.fawrySystem.transactionsModel.ActiveTransaction;

public class UserView {

    public UserServiceImp controller;

    public UserView(UserServiceImp controller)
    { 
        this.controller=controller;
    }


    public void requestRefundForm()
    {
        System.out.println("Enter the ID of the transaction you want to get a refund on: ");
        Scanner input1=new Scanner(System.in);
        int id=input1.nextInt();
        controller.requestRefund(id);
    }

    //Get the amount in the parameter form the service's calcTotal in main
    public void paymentOptionsForm(ActiveTransaction active)
    {
        System.out.println("How would you like for this service: ");
        System.out.println("1- Credit card ");
        System.out.println("2- Wallet ");
        //if service has cod -> 3- COD
           Scanner input=new Scanner(System.in);
           int choice=input.nextInt();

           switch(choice)
           {
            case 1: controller.payWithCard();
            case 2: controller.payWithWallet();
            case 3: controller.payWithCOD();

           }

    }


    public void paymentFailure() 
    {
        System.out.println("Payment proccess failure!");
        System.out.println("You don't have enough credit.");
    }



    public void printUserDetails(String userName, String email){
        System.out.println("Name: " + userName);
        System.out.println("Email: " + email);
    }


     

}
