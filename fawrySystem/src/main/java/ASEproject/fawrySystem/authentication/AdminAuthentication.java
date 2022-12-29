package ASEproject.fawrySystem.authentication;

import org.springframework.stereotype.Service;

import ASEproject.fawrySystem.model.Admin;
import ASEproject.fawrySystem.model.Person;
import ASEproject.fawrySystem.util.Common;
@Service
public class AdminAuthentication extends Authentication{
    @Override
    public boolean logInValidation(Person p) {
        for(int i=0;i<Common.admins.size();i++){
            if(Common.admins.get(p.getUsername())!=null){
                return logIn=true;
            }
        }
        return logIn=false;
    }

    @Override
    public boolean signUpValidation(Person p) {
      
        for(int i=0;i<Common.admins.size();i++){
            if(Common.admins.get(p.getUsername())!=null){
                return signUp=false;
            }
        }
        Admin ad=new Admin();
        ad.setUsername(p.getUsername());
        ad.setPassword(p.getPassword());
        Common.admins.put(ad.getUsername(), ad);
        return signUp=true;


    }
  
    
}
    
    
