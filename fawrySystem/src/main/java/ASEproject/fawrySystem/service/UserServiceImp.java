package ASEproject.fawrySystem.service;
import java.beans.JavaBean;
import java.lang.annotation.Annotation;
import java.util.ArrayList;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;


import ASEproject.fawrySystem.model.RefundRequest;
import ASEproject.fawrySystem.model.User;
import ASEproject.fawrySystem.transactionsModel.ActiveTransaction;
import ASEproject.fawrySystem.transactionsModel.PaidTransactions;
import ASEproject.fawrySystem.util.Common;
import ASEproject.fawrySystem.view.UserView;






@Service
public class UserServiceImp implements UserService{
   
   @Autowired
   private User model;
   //private ActiveTransaction active;
   //@Autowired
   //private UserView view;
/* 
   public ActiveTransaction getActive() {
      return active;
   }


   public void setActive(ActiveTransaction active) {
      this.active = active;
   }
   */


   public UserServiceImp(User model/*  UserView view*/){
      this.model = model;
      //this.view = view;
   }


   @PostMapping("/setUsername")
   public void setUsername(String userName){
      model.setUsername(userName);		
   }

   public String getUsername(){
      return model.getUsername();		
   }

   public void setPassword(String password){
      model.setPassword(password);		
   }

   public String getPassword(){
      return model.getPassword();		
   }

   public ArrayList<PaidTransactions> getMyCompleteTrans() {
      return model.getMyCompleteTrans();
   }

   public void setMyCompleteTrans(ArrayList<PaidTransactions> myCompleteTrans) {
      model.setMyCompleteTrans(myCompleteTrans);
  }

   public void addFunds(double amount)
   {
      model.addFunds(amount);
   }

   public void requestRefund(int id)
   {
      RefundRequest req=new RefundRequest();
      req.setReqID();
      req.setUser(model);
      req.setTransID(id);
      Common.refundRequests.put(req.getReqID(),req);
      //notify();

   }


   public void updateView(){				
      //view.printUserDetails(model.getUsername(), model.getPassword());
   }

   @Override
   public boolean addUser(User user) 
   {

      try {
         if (Common.users.get(user.getUsername())!= null)  {
             return false;
         }
         Common.users.put(user.getUsername(), user);
     } catch (Exception e) {
         System.out.println("Exception in addUser as" + e.getMessage());
         return false;
     }
     return true;
     
   }

   
   @Override
   public Boolean deleteUser(String username) {
      try {
          if (Common.users.get(username) == null) {
              return false;
          }
          Common.users.remove(username);
      } catch (Exception e) {
          System.out.println("Exception in deleteUser as" + e.getMessage());
          return false;
      }
      return true;
  }



@Override
public User getUser(String username) {
     try
      {
        return Common.users.get(username);
      } 
      catch (Exception e) 
      {
         System.out.println("Exception in getUser as" + e.getMessage());
      }
   return null;
}


@Override
public User[] getAllUsers() {
   try {
       Set<String> usernames = Common.users.keySet();
       User[] u = new User[usernames.size()];
       int i = 0;
       for (String username : usernames) {
           u[i] = Common.users.get(username);
           i++;
       }
       return u;
   } catch (Exception e) {
       System.out.println("Exception in getAllUsers as" + e.getMessage());
   }
   return null;
}


@Override
public boolean payWithWallet()
{
   boolean status=false;
   if(model.getWallet().credit>= model.getActive().getAmountPaid())
   {
      model.getWallet().credit-=model.getActive().getAmountPaid();
      status=true;
      long date= System.currentTimeMillis();
      String paidWith="Wallet";

      PaidTransactions trans=createMyTrans(model.getActive().getAmountPaid(), model.getActive().getServiceName(), date, paidWith);
      model.myCompleteTrans.add(trans);
      Common.completeTrans.put(trans.getId(), trans);

      return status;
      
   }
   else
   {
     // view.paymentFailure();
      return status;
   }
     
}


@Override
public boolean payWithCard()
{
   boolean status=false;
   if(model.getCard().credit>= model.getActive().getAmountPaid())
   {
      model.getCard().credit-=model.getActive().getAmountPaid();
      status=true;
      long date= System.currentTimeMillis();
      String paidWith="Credit card";

      PaidTransactions trans=createMyTrans(model.getActive().getAmountPaid(), model.getActive().getServiceName(), date, paidWith);
      model.myCompleteTrans.add(trans);
      Common.completeTrans.put(trans.getId(), trans);
      return status;
   }
   else
   {
      //view.paymentFailure();
      return status;
   }
}

@Override
public boolean payWithCOD()
{

   model.cash+=model.getActive().getAmountPaid();
   long date= System.currentTimeMillis();
   String paidWith="Cash on delivery";

   PaidTransactions trans=createMyTrans(model.getActive().getAmountPaid(), model.getActive().getServiceName(), date,paidWith);
   model.myCompleteTrans.add(trans);
   Common.completeTrans.put(trans.getId(), trans);
   return true;
}


@Override
public PaidTransactions createMyTrans(double amount, String serviceProName, long date, String paidWith)
{

   PaidTransactions trans=new PaidTransactions();
   trans.setAmountPaid(amount);
   trans.setDate(date);
   trans.setServiceName(serviceProName);
   trans.setId();
   trans.setUser(model);
   trans.paidWith=paidWith;
   return trans;


}










}
