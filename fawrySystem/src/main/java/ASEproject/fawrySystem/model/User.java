package ASEproject.fawrySystem.model;

import java.util.ArrayList;

import org.springframework.stereotype.Component;
import ASEproject.fawrySystem.payment.CreditCard;
import ASEproject.fawrySystem.payment.Payment;
import ASEproject.fawrySystem.payment.Wallet;
import ASEproject.fawrySystem.transactionsModel.ActiveTransaction;
import ASEproject.fawrySystem.transactionsModel.PaidTransactions;

@Component
public class User extends Person{

    private ActiveTransaction active;
    public ActiveTransaction getActive() {
        return active;
    }


    public void setActive(ActiveTransaction active) {
        this.active = active;
    }

    private Payment wallet=new Wallet();
    private Payment card=new CreditCard();
    public double cash;
    public ArrayList<PaidTransactions> myCompleteTrans=new ArrayList<PaidTransactions>();
    private ArrayList<RefundRequest> myRequests;

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


}
