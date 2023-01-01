package ASEproject.fawrySystem.model.transactionsModel;

import org.springframework.stereotype.Component;

@Component
public class ActiveTransaction extends Transactions{

    private String mobile;
    

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }
    
}
