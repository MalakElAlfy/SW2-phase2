package ASEproject.fawrySystem.user;

import java.util.ArrayList;

import org.springframework.stereotype.Component;

import ASEproject.fawrySystem.model.Person;
import ASEproject.fawrySystem.model.RefundRequest;
import ASEproject.fawrySystem.model.transactionsModel.ActiveTransaction;
import ASEproject.fawrySystem.model.transactionsModel.PaidTransactions;
import ASEproject.fawrySystem.model.transactionsModel.RefundTransactions;
import ASEproject.fawrySystem.user.payment.CreditCard;
import ASEproject.fawrySystem.user.payment.Payment;
import ASEproject.fawrySystem.user.payment.Wallet;

@Component
public class User extends Person{

    private ActiveTransaction active;
    private int myCurrentTransId;
    

    private Payment wallet=new Wallet();
    private Payment card=new CreditCard();
    public double cash;

    public ArrayList<PaidTransactions> myCompleteTrans=new ArrayList<PaidTransactions>();
    private ArrayList<RefundRequest> myRequests;
    
    
    private static int currentID=1;
    private int id;
    private boolean overAll=true;
    
    public boolean isOverAll() {
        return overAll;
    }

    public void setOverAll(boolean overAll) {
        this.overAll = overAll;
    }

    public int getId() {
        return id;
    }

    public void setId() {
        id=currentID;
        currentID++;
    }

    /* 

    public ActiveTransaction getActive() {
        return active;
    }
    */


    public void setActive(ActiveTransaction active) {
        this.active = active;
    }


    @Override
	public String toString() {
		return username + "::" + password ;
	}

    
    public User()
    {
       // req=new RefundRequest();
    }
    public ArrayList<RefundRequest> getMyRequests() {
        return myRequests;
    }
    public void setMyRequests(ArrayList<RefundRequest> myRequests) {
        this.myRequests = myRequests;
    }
    public double getCash() {
        return cash;
    }
    public void setCash(double cash) {
        this.cash = cash;
    }

    public Payment getWallet() {
        return wallet;
    }
    public void setWallet(Payment wallet) {
        this.wallet = wallet;
    }

    
    public Payment getCard() {
        return card;
    }

    public void setCard(Payment card) {
        this.card = card;
    }

    public ArrayList<PaidTransactions> getMyCompleteTrans() {
        return myCompleteTrans;
    }

    public void setMyCompleteTrans(ArrayList<PaidTransactions> myCompleteTrans) {
        this.myCompleteTrans = myCompleteTrans;
    }

    public boolean addFunds(double amount)
    {
        if(card.credit>=amount)
        {
            card.credit-=amount;
            wallet.credit+=amount;
            return true;
        }
        return false;
    }

    public void payWithWallet(double amount)
    {
        wallet.credit-=amount;
    }

    public void payWithCard(double amount)
    {
        card.credit-=amount;
    }

    public void payWithCOD(double amount)
    {
        cash+=amount;
    }

    public void addToCreditCard(double amount)
    {
        card.credit+=amount;

    }


    //check this function
    public boolean addToWallet(double amountPaid) 
    {
        wallet.credit+=amountPaid;
        return true;

    }

    public void setMyCurrentTransId(int id)
    {
        myCurrentTransId=id;
    }

    public int getMyCurrentTransId() {
        return myCurrentTransId;
    }



}
