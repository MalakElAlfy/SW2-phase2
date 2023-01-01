package ASEproject.fawrySystem.util;

//import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import ASEproject.fawrySystem.admin.Admin;
import ASEproject.fawrySystem.model.RefundRequest;
import ASEproject.fawrySystem.model.transactionsModel.AddToWalletTransactions;
import ASEproject.fawrySystem.model.transactionsModel.PaidTransactions;
import ASEproject.fawrySystem.model.transactionsModel.RefundTransactions;
import ASEproject.fawrySystem.user.User;

@Component
public class Common  {

    public static Map<Integer, RefundRequest> refundRequests = new HashMap<Integer, RefundRequest>();
    
    public static Map<String, User> users = new HashMap<String, User>();
    public static Admin myAdmin=new Admin(); 
    public static Admin myAdmin2=new Admin(); 
    public static Map<String, Admin> admins = new HashMap<String, Admin>(); 
    public static Map<Integer, PaidTransactions> completeTrans = new HashMap<Integer, PaidTransactions>();
    public static Map<Integer, RefundTransactions> refundTrans = new HashMap<Integer, RefundTransactions>();
    public static Map<Integer, AddToWalletTransactions> addToWalletTrans = new HashMap<Integer, AddToWalletTransactions>();
    public static Map<Integer,User> currentUsers=new HashMap<Integer,User>();

    public Common()
    {
        myAdmin.setUsername("malak");
        myAdmin.setPassword("123");
        myAdmin2.setUsername("mariam");
        myAdmin2.setPassword("222");
        admins.put("malak",myAdmin);
        admins.put("mariam",myAdmin2);


        RefundRequest req=new RefundRequest();
        req.setReqID();
        req.setTransID(1);

        refundRequests.put(req.getReqID(),req);
        

        PaidTransactions trans=new PaidTransactions();
        PaidTransactions trans1=new PaidTransactions();


        trans.setAmountPaid(20);
        trans.setId();
        trans.setServiceProviderName("Vodafone");

        completeTrans.put(trans.getId(),trans);

        trans1.setAmountPaid(20);
        trans1.setId();
        trans1.setServiceProviderName("Vodafone");

        completeTrans.put(trans1.getId(),trans1);

    }


    
    public void addRequest(RefundRequest req)
    {
        refundRequests.put(req.getReqID(),req);
       // setChanged();
        //notifyObservers(req);

    }

    public static boolean addToCurrentUsers(User currentUser)
    {
        currentUser.setId();
        return currentUsers.put(currentUser.getId(), currentUser) != null;

    }

/* 
    @Override
    public void notifyUpdate(RefundRequest req) {

        refundRequests.put(req.getReqID(),req);
        
        observer.update(req);
        
    }
    */
    
    
    /* 

    public MyObserver getObserver() {
        return observer;
    }

    public void setObserver(MyObserver observer) {
        this.observer = observer;
    }
    */



}
