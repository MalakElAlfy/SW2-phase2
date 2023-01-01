package ASEproject.fawrySystem.user;
import java.util.ArrayList;
import java.util.Set;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;
import ASEproject.fawrySystem.model.RefundRequest;
import ASEproject.fawrySystem.model.Response;
import ASEproject.fawrySystem.model.transactionsModel.ActiveTransaction;
import ASEproject.fawrySystem.model.transactionsModel.PaidTransactions;
import ASEproject.fawrySystem.service.servicesModel.Services;
import ASEproject.fawrySystem.util.Common;

@Service
public class UserServiceImp implements UserService{
   
   @Autowired
   private User model;


   public User getModel() {
      return model;
   }


   public void setModel(User model) {
      this.model = model;
   }


   public UserServiceImp(User model){
      this.model = model;
   }

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

   public boolean addFunds(double amount)
   {
      return model.addFunds(amount);
   }

   public int requestRefund(int id)
   {
      int reqID=0;


      RefundRequest req=new RefundRequest();
      req.setReqID();
      req.setUser(model);
      req.setTransID(id);
      Common.refundRequests.put(req.getReqID(),req);

      reqID=req.getReqID();

      reqID=req.getReqID();
      return reqID;
      

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
public User[] getAllActiveUsers() {
   try {
       Set<Integer> ids = Common.currentUsers.keySet();
       User[] u = new User[ids.size()];
       int i = 0;
       for (Integer id : ids) 
         {
          u[i] = Common.currentUsers.get(id);
          i++;
         }
         return u;
   } catch (Exception e) {
       System.out.println("Exception in getAllActiveUsers as" + e.getMessage());
   }
   return null;
}


@Override
public boolean payWithWallet(ActiveTransaction activeTrans)
{
   boolean status=false;
   if(model.getWallet().credit>=activeTrans.getAmountPaid())
   {
      model.getWallet().credit-=activeTrans.getAmountPaid();

      long date= System.currentTimeMillis();
      String paidWith="Wallet";
      
      PaidTransactions trans=createMyTrans(activeTrans, date, paidWith);

      //model.myCompleteTrans.add(trans);
      //model.myCompleteTrans.add(trans);
      Common.completeTrans.put(trans.getId(), trans);
      

      model.setOverAll(false);
      model.setMyCurrentTransId(trans.getId());

      status=true;
      return status;
      
   }
   else
   {
      return status;
   }
   
}


@Override
public boolean payWithCard(ActiveTransaction activeTrans)
{
   boolean status=false;

  

   if(model.getCard().credit>=activeTrans.getAmountPaid())
   {
      model.getCard().credit-=activeTrans.getAmountPaid();

      long date=System.currentTimeMillis();
      String paidWith="Credit card";

      PaidTransactions trans=createMyTrans(activeTrans,date,paidWith);

      model.setOverAll(false);
      Common.completeTrans.put(trans.getId(), trans);

      model.setMyCurrentTransId(trans.getId());

      status=true;
      return status;
   }
   else
   {
      return status;
   }
}

@Override
public boolean payWithCOD(ActiveTransaction activeTrans)
{
   boolean status=false;
   model.cash+=activeTrans.getAmountPaid();

   long date= System.currentTimeMillis();
   String paidWith="Cash on delivery";
   
   PaidTransactions trans=createMyTrans(activeTrans,date,paidWith);
   //model.getActive().setPaidTranID(trans.getId());
   
   model.setOverAll(false);
   Common.completeTrans.put(trans.getId(), trans);

   model.setMyCurrentTransId(trans.getId());
   status=true;
   return status;
}


@Override
public PaidTransactions createMyTrans(ActiveTransaction activeTrans ,long date, String paidWith)
{
   
   PaidTransactions trans=new PaidTransactions();
   trans.setAmountPaid(activeTrans.getAmountPaid());
   trans.setDate(date);
   trans.setServiceProviderName(activeTrans.getServiceProviderName());
   trans.setId();
   trans.setUser(model);
   trans.paidWith=paidWith;
   return trans;
   
}



public User getActiveUser(int id) 
{
   User user;
   user=Common.currentUsers.get(id);

   //System.out.println("user: " + user);
   return user;
}



public boolean checkIfActive(int id) 
{
  return Common.currentUsers.get(id)!=null;
}

//remove function
public void removeFromCurrentUsers(int id)
{
   Common.currentUsers.remove(id);
}


public boolean hasOverAllDiscount() 
{
   return model.isOverAll();
     
}




public void setActive(ActiveTransaction active) 
{
   model.setActive(active);
}


public void addToCreditCard(double money)
{
   model.addToCreditCard(money);
}


public void applySpecificDiscount(ActiveTransaction activeTrans) 
{
   double newAmount;
   newAmount=activeTrans.getAmountPaid()*0.8;
   activeTrans.setAmountPaid(newAmount);
}

public void applyOverAllDiscount(ActiveTransaction activeTrans) 
{
   double newAmount;
   newAmount=activeTrans.getAmountPaid()*0.9;
   activeTrans.setAmountPaid(newAmount);
}



}
