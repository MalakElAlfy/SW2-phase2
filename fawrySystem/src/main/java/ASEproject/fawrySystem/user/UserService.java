package ASEproject.fawrySystem.user;

import ASEproject.fawrySystem.model.transactionsModel.ActiveTransaction;
import ASEproject.fawrySystem.model.transactionsModel.PaidTransactions;

public interface UserService {

    public boolean addUser(User user) ;
    public Boolean deleteUser(String username);
    public User getUser(String username);
    public User[] getAllUsers();
    public User[] getAllActiveUsers();
    public boolean payWithWallet(ActiveTransaction activeTrans);
    public boolean payWithCard(ActiveTransaction activeTrans);
    public boolean payWithCOD(ActiveTransaction activeTrans);
    public PaidTransactions createMyTrans(ActiveTransaction activeTrans ,long date, String paidWith);
    //public Object searchForService(String name);

    
}
