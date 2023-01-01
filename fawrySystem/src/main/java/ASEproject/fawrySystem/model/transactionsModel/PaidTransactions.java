package ASEproject.fawrySystem.model.transactionsModel;

import ASEproject.fawrySystem.user.User;

public class PaidTransactions extends Transactions{
    
    private static int currentID=1;
    private int id=0;
    public String paidWith;
    private User user;
    
    public User getUser() {
        return user;
    }
    
    public void setUser(User user) {
        this.user = user;
    }
    
    


    public int getId() {
        return id;
    }

    public void setId() {
        id=currentID;
        currentID++;
    }

    
}
