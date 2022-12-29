package ASEproject.fawrySystem.service;

import java.lang.annotation.Annotation;
import java.util.Collection;
import java.util.Iterator;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ASEproject.fawrySystem.model.Admin;
import ASEproject.fawrySystem.model.RefundRequest;
import ASEproject.fawrySystem.observerPattern.MyObserver;
import ASEproject.fawrySystem.transactionsModel.PaidTransactions;
import ASEproject.fawrySystem.util.Common;
import ASEproject.fawrySystem.view.AdminView;
//import lombok.RequiredArgsConstructor;

//import ASEproject.fawrySystem.model.Admin;
//import ASEproject.fawrySystem.view.AdminView;

//@RestController
//@EnableAutoConfiguration

@Service
//@RequiredArgsConstructor
public class AdminServiceImp implements MyObserver,AdminService{

   @Autowired
   private Admin model;
   //private AdminView view;
   @Autowired
   private DiscountsService discountController;
   @Autowired
   private ServicesServiceImp servicesController;

   
   /*
   public AdminServiceImp(Admin model/*  AdminView view, DiscountsService discountController, ServicesServiceImp servicesController)
   {
      this.discountController=discountController;
      this.servicesController=servicesController;
      this.model = model;
      //this.view = view;
   }
   */

   @Override
   public ServicesServiceImp getServicesController() {
      return servicesController;
   }

   @Override
   public void setServicesController(ServicesServiceImp servicesController) {
      this.servicesController = servicesController;
   }
   
   @Override
   public DiscountsService getDiscountController() 
   {
      return discountController;
   }
   
   @Override
   public void setDiscountController(DiscountsService discountController) 
   {
      this.discountController = discountController;
   }
      
   @Override
   public void setUsername(String userName){
      model.setUsername(userName);		
   }

   @Override
   public String getUsername(){
      return model.getUsername();		
   }

   @Override
   public void setPassword(String password){
      model.setPassword(password);		
   }

   @Override
   public String getPassword(){
      return model.getPassword();		
   }

   @Override
   public void update(RefundRequest req) {
      System.out.println("A new refund request has been added: "  );
      //view.displayRequest(req);
   }	

   @Override
   public void updateView(){				
     // view.printAdminDetails(model.getUsername(), model.getPassword());
   }

   @Override
   public boolean addDiscount(int serviceID) 
   {
      boolean status;
      status=discountController.addDiscount(serviceID);
      return status;
   }

   @Override
   public boolean addDiscountOnAll()
   {
      return discountController.addDiscountOnAll();
   }

   @Override
   public RefundRequest[] getAllRequests(){
      try {
       //Set<String> usernames = Common.users.keySet();
       RefundRequest[] all = new RefundRequest[Common.refundRequests.size()];
       
       Collection getValues = Common.refundRequests.values();
       Set keys = Common.refundRequests.keySet();
       Iterator i = keys.iterator();
       i = getValues.iterator();

       int j = 0;
       while (i.hasNext()) {
           all[j]=(RefundRequest) i.next();
           j++;
        }
       return all;
      } catch (Exception e) {
       System.out.println("Exception in getAllRequests as" + e.getMessage());
      }
      return null;
    }


    @Override
   public PaidTransactions[] getAllTransactions(){
      try {
       //Set<String> usernames = Common.users.keySet();
       PaidTransactions[] all = new PaidTransactions[Common.completeTrans.size()];
       
       Collection getValues = Common.completeTrans.values();
       Set keys = Common.completeTrans.keySet();
       Iterator i = keys.iterator();
       i = getValues.iterator();

       int j = 0;
       while (i.hasNext()) {
           all[j]=(PaidTransactions) i.next();
           j++;
        }
       return all;
      } catch (Exception e) {
       System.out.println("Exception in getAllTransactions as" + e.getMessage());
      }
      return null;
    }


   


  

    
}
