package ASEproject.fawrySystem.service;

import ASEproject.fawrySystem.model.RefundRequest;
import ASEproject.fawrySystem.transactionsModel.PaidTransactions;

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
    public boolean addDiscountOnAll();
    public RefundRequest[] getAllRequests();
    public PaidTransactions[] getAllTransactions();
   
   
    
}
