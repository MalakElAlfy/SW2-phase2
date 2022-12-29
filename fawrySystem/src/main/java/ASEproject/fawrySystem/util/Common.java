package ASEproject.fawrySystem.util;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import ASEproject.fawrySystem.model.Admin;
import ASEproject.fawrySystem.model.RefundRequest;
import ASEproject.fawrySystem.model.User;
import ASEproject.fawrySystem.transactionsModel.PaidTransactions;
import ASEproject.fawrySystem.transactionsModel.RefundTransactions;
import ASEproject.fawrySystem.observerPattern.MyObservable;
import ASEproject.fawrySystem.observerPattern.MyObserver;
import ASEproject.fawrySystem.servicesModel.Services;

public class Common implements MyObservable {

    public static Map<Integer, RefundRequest> refundRequests = new HashMap<Integer, RefundRequest>();
    
    public static Map<String, User> users = new HashMap<String, User>();
    public static Map<String, Admin> admins = new HashMap<String, Admin>();
    public static Map<Integer, PaidTransactions> completeTrans = new HashMap<Integer, PaidTransactions>();
    public static Map<Integer, RefundTransactions> refundTrans = new HashMap<Integer, RefundTransactions>();

    //public static ArrayList<Services> listOfServices;
    private MyObserver observer;



    public MyObserver getObserver() {
        return observer;
    }

    public void setObserver(MyObserver observer) {
        this.observer = observer;
    }

    public void addRequest(RefundRequest req)
    {
        refundRequests.put(req.getReqID(),req);
       // setChanged();
        //notifyObservers(req);

    }

    






    @Override
    public void notifyUpdate(RefundRequest req) {

        refundRequests.put(req.getReqID(),req);
        
        observer.update(req);
        
    }
    
    


   



}
