package ASEproject.fawrySystem.model;

import org.springframework.stereotype.Component;

import ASEproject.fawrySystem.user.User;

@Component
public class RefundRequest {

    private static int currentReqid=1;
    private int reqID;
    private int transID;
    private User user;
    private boolean isAccepted;
    private String relatedService;
    private double amount;

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public String getRelatedService() {
        return relatedService;
    }

    public void setRelatedService(String relatedService) {
        this.relatedService = relatedService;
    }

    public boolean isAccepted() {
        return isAccepted;
    }

    public void setAccepted(boolean isAccepted) {
        this.isAccepted = isAccepted;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public int getTransID() {
        return transID;
    }

    public void setTransID(int transID) {
        this.transID = transID;
    }

    public static int getCurrentReqid() {
        return currentReqid;
    }

    public static void setCurrentReqid(int currentReqid) {
        RefundRequest.currentReqid = currentReqid;
    }

    public int getReqID() {
        return reqID;
    }

    public void setReqID() {
        reqID = currentReqid;
        currentReqid++;
    }

   

    
    
}
