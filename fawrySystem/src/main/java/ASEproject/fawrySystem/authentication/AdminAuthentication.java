package ASEproject.fawrySystem.authentication;

import org.springframework.stereotype.Service;

import ASEproject.fawrySystem.admin.Admin;
import ASEproject.fawrySystem.model.Person;
import ASEproject.fawrySystem.util.Common;
@Service
public class AdminAuthentication extends Authentication{

    
    @Override
    public boolean logInValidation(Person p) {
        if(Common.admins.get(p.getUsername())!=null)
        {
            logIn=true;
            return true;
        }
        logIn=false;
        return logIn;
    }

    
    
}
    
    
