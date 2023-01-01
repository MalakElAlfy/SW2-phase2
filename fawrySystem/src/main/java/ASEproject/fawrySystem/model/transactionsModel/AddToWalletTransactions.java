package ASEproject.fawrySystem.model.transactionsModel;

import org.springframework.stereotype.Component;

import ASEproject.fawrySystem.user.User;


public class AddToWalletTransactions extends Transactions
{
    private Double amountAdded;
    private User user;
    private long time;
    private static int currentID=1;
    private int id;

    public int getId() {
        return id;
    }

    public void setId() {
        id=currentID;
        currentID++;
    }

    public AddToWalletTransactions(Double amountAdded, User user, long time)
    {
        this.amountAdded=amountAdded;
        this.user=user;
        this.time=time;

    }

    public long getTime() {
        return time;
    }

    public void setTime(long time) {
        this.time = time;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Double getAmountAdded() {
        return amountAdded;
    }

    public void setAmountAdded(Double amountAdded) {
        this.amountAdded = amountAdded;
    }
    
}
