package ASEproject.fawrySystem.transactionsModel;

import ASEproject.fawrySystem.model.User;

public class PaidTransactions extends Transactions{

    private static int currentID=1;
    private int id;
    public String paidWith;
    private User user;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public static int getCurrentID() {
        return currentID;
    }

    public static void setCurrentID(int currentID) {
        PaidTransactions.currentID = currentID;
    }


    public int getId() {
        return id;
    }

    public void setId() {
        id=currentID;
        currentID++;
    }

    
}
