package ASEproject.fawrySystem.model.transactionsModel;

import ASEproject.fawrySystem.user.User;

public class RefundTransactions extends Transactions{

    private static int currentID=1;
    private int id=0;
    
    private int paidTransId;

    public int getPaidTransId() {
        return paidTransId;
    }

    public void setPaidTransId(int paidTransId) {
        this.paidTransId = paidTransId;
    }

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
