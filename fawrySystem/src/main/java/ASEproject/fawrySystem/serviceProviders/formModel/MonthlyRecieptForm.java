package ASEproject.fawrySystem.serviceProviders.formModel;

import org.springframework.stereotype.Component;

//@Component
public class MonthlyRecieptForm extends Form{

    private String phoneNumber;




    public String getPhoneNumber() {
        return phoneNumber;
    }


    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }


    @Override
    public boolean handleForm() {
		//char[] num=getPhoneNumber().toCharArray();
		
		if((getPhoneNumber().length()==8)&&(getAmountToPay()>0)) {
            setHandle(true);;
			return isHandle();
		}
		else 
        {  
            setHandle(false);
			return isHandle();
        }
	}
    
}
