package ASEproject.fawrySystem.transactionsModel;

public abstract class Transactions {

    private String serviceName;
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

    public String getServiceName() {
        return serviceName;
    }

    public void setServiceName(String serviceName) {
        this.serviceName = serviceName;
    }
    
}
