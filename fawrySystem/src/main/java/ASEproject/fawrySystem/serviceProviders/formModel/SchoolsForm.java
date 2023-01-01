package ASEproject.fawrySystem.serviceProviders.formModel;
import org.springframework.stereotype.Component;

//@Component
public class SchoolsForm extends Form{

    @Override
    public boolean handleForm() {
		if(getAmountToPay()>0) {
			setHandle(true);
            return isHandle() ;
		}
		else 
        {
            setHandle(false);
            return isHandle() ;
        }
	}    
    
}
