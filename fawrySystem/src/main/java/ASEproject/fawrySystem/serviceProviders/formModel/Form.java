package ASEproject.fawrySystem.serviceProviders.formModel;


public abstract class Form {

    private double amountToPay;
    //private String mobileNumber;
    private String serviceProviderName;
    private boolean handle=true;
    
    public boolean isHandle() {
        return handle;
    }
    public void setHandle(boolean handle) {
        this.handle = handle;
    }
    public String getServiceProviderName() {
        return serviceProviderName;
    }
    public void setServiceProviderName(String serviceProviderName) {
        this.serviceProviderName = serviceProviderName;
    }
    
    public double getAmountToPay() {
        return amountToPay;
    }
    public void setAmountToPay(double amountToPay) {
        this.amountToPay = amountToPay;
    }
    
    public boolean handleForm()
    {
        return isHandle();
    }
    public void setMobileNumber(String mobileNumber)
    {

    }
    
}
