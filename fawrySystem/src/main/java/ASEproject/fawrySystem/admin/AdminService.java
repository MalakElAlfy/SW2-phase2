package ASEproject.fawrySystem.admin;

import ASEproject.fawrySystem.model.RefundRequest;
import ASEproject.fawrySystem.model.transactionsModel.AddToWalletTransactions;
import ASEproject.fawrySystem.model.transactionsModel.PaidTransactions;
import ASEproject.fawrySystem.model.transactionsModel.RefundTransactions;
import ASEproject.fawrySystem.service.DiscountsService;
import ASEproject.fawrySystem.service.ServicesService;
import ASEproject.fawrySystem.service.ServicesServiceImp;

public interface AdminService {

    public ServicesService getServicesController();
    public DiscountsService getDiscountController();
    public void setDiscountController(DiscountsService discountController);
    public void setServicesController(ServicesServiceImp servicesController);
    public void setUsername(String userName);
    public String getUsername();
    public void setPassword(String password);
    public String getPassword();
    public void updateView();
    public boolean addDiscount(int serviceID);
    //public boolean addDiscountOnAll();
    public RefundRequest[] getAllRequests();
    public PaidTransactions[] getAllPaidTransactions();
    public RefundTransactions[] getAllRefundTransactions();
    public AddToWalletTransactions[] getAllAddToWalletTransactions();
   
   
    
}
