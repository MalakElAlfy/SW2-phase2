package ASEproject.fawrySystem.model;

import org.springframework.stereotype.Component;

@Component
public class RefundRequest {

    private static int currentReqid=1;
    private int reqID;
    private int transID;
    private User user;

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
