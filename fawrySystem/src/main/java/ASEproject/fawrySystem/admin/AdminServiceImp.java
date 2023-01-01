package ASEproject.fawrySystem.admin;

import java.util.Collection;
import java.util.Iterator;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ASEproject.fawrySystem.model.RefundRequest;
import ASEproject.fawrySystem.model.transactionsModel.AddToWalletTransactions;
import ASEproject.fawrySystem.model.transactionsModel.PaidTransactions;
import ASEproject.fawrySystem.model.transactionsModel.RefundTransactions;
import ASEproject.fawrySystem.service.DiscountsService;
import ASEproject.fawrySystem.service.ServicesServiceImp;
import ASEproject.fawrySystem.user.User;
import ASEproject.fawrySystem.util.Common;


@Service
public class AdminServiceImp implements AdminService{

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

/* 
@Override
public void update(RefundRequest req) {
   System.out.println("A new refund request has been added: "  );
   //view.displayRequest(req);
}	
*/

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
/* 
@Override
public boolean addDiscountOnAll()
{
   return discountController.addDiscountOnAll();
}
*/

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
public PaidTransactions[] getAllPaidTransactions(){
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

   } catch (Exception e) 
   {
      System.out.println("Exception in getAllTransactions as" + e.getMessage());
   }

   return null;
}

    
    
@Override
public RefundTransactions[] getAllRefundTransactions()
{
   try {
      //Set<String> usernames = Common.users.keySet();
      RefundTransactions[] all = new RefundTransactions[Common.refundTrans.size()];
      
      Collection getValues = Common.refundTrans.values();
      Set keys = Common.refundTrans.keySet();
      Iterator i = keys.iterator();
      i = getValues.iterator();

      int j = 0;
      while (i.hasNext()) {
          all[j]=(RefundTransactions) i.next();
          j++;
       }
      return all;
     } catch (Exception e) {
      System.out.println("Exception in getAllRefundTransactions as" + e.getMessage());
     }
	return null;
}

@Override
public AddToWalletTransactions[] getAllAddToWalletTransactions()
{
   try {
      //Set<String> usernames = Common.users.keySet();
      AddToWalletTransactions[] all = new AddToWalletTransactions[Common.addToWalletTrans.size()];
      
      Collection getValues = Common.addToWalletTrans.values();
      Set keys = Common.addToWalletTrans.keySet();
      Iterator i = keys.iterator();
      i = getValues.iterator();
      
      int j = 0;
      while (i.hasNext()) {
         all[j]=(AddToWalletTransactions) i.next();
         j++;
      }
      return all;
   } catch (Exception e) {
      System.out.println("Exception in getAllAddToWalletTransactions as" + e.getMessage());
   }
	return null;
}


public RefundRequest getRequest(int id) 
{
   RefundRequest req=null;
   req=Common.refundRequests.get(id);
   
   

   return req;
}

public boolean acceptRefund(PaidTransactions trans, int id) 
{
   boolean status=false;

   User user=trans.getUser();
   double amountPaid=trans.getAmountPaid();

   RefundRequest req=null;
   req=Common.refundRequests.get(id);
   req.setAccepted(true);


   if(user.addToWallet(amountPaid))
   {
      createAndAddRefundTrans(trans);
   }

   return status;
}

private void createAndAddRefundTrans(PaidTransactions trans)
{
   RefundTransactions refundTrans=new RefundTransactions();
   refundTrans.setAmountPaid(trans.getAmountPaid());
   refundTrans.setDate(System.currentTimeMillis());
   refundTrans.setId();
   refundTrans.setUser(trans.getUser());
   refundTrans.setPaidTransId(trans.getId());

   Common.refundTrans.put(refundTrans.getId(),refundTrans);

}

public void refuseRefund(int id) 
{
   //RefundRequest req=null;
   Common.refundRequests.get(id).setAccepted(false);
  // req.setAccepted(false);

}

public PaidTransactions getPaidTrans(int transID) {

   PaidTransactions trans=null;
   trans=Common.completeTrans.get(transID);
   return trans;
}

    
}
