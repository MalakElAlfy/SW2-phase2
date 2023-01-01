package ASEproject.fawrySystem.model.transactionsModel;

public abstract class Transactions {

    private String serviceProviderName;
    private double amountPaid;
    private long date;


    public long getDate() {
        return date;
    }

    public void setDate(long date) {
        this.date = date;
    }

    public double getAmountPaid() {
        return amountPaid;
    }

    public void setAmountPaid(double amountPaid) {
        this.amountPaid = amountPaid;
    }

    public String getServiceProviderName() {
        return serviceProviderName;
    }

    public void setServiceProviderName(String serviceProviderName) {
        this.serviceProviderName = serviceProviderName;
    }
    
}
