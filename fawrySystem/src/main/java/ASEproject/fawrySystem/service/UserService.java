package ASEproject.fawrySystem.service;

import ASEproject.fawrySystem.model.User;
import ASEproject.fawrySystem.transactionsModel.ActiveTransaction;
import ASEproject.fawrySystem.transactionsModel.PaidTransactions;

public interface UserService {

    public boolean addUser(User user) ;
    public Boolean deleteUser(String username);
    public User getUser(String username);
    public User[] getAllUsers();
    public boolean payWithWallet();
    public boolean payWithCard();
    public boolean payWithCOD();
    public PaidTransactions createMyTrans(double amount, String serviceProName, long date, String paidWith);
    //public Object searchForService(String name);

    
}
