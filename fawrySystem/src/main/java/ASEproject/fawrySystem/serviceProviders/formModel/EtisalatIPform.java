package ASEproject.fawrySystem.serviceProviders.formModel;

import org.springframework.stereotype.Component;

//@Component
public class EtisalatIPform extends Form
{
    private String mobileNumber;

    public String getMobileNumber() {
        return mobileNumber;
    }
    public void setMobileNumber(String mobileNumber) {
        this.mobileNumber = mobileNumber;
    }

    @Override
	public boolean handleForm() {
		char[] num=getMobileNumber().toCharArray();
		
		if((getMobileNumber().length()== 11)&&(num[0]=='0')&&(num[1]=='1')&&(num[2]=='1')&&(getAmountToPay()>0)) {
            setHandle(true);
			return isHandle();
		}
        else 
		{
            setHandle(false);
			return isHandle();
        }
    }
    
}
