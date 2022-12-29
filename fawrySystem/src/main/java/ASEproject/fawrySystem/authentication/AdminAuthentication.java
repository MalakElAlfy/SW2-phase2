package ASEproject.fawrySystem.authentication;

import ASEproject.fawrySystem.model.Admin;
import ASEproject.fawrySystem.model.Person;
import ASEproject.fawrySystem.util.Common;

public class AdminAuthentication extends Authentication{

    @Override
    public boolean logInValidation(Person p) {
        for(int i=0;i<Common.admins.size();i++){
            if(p == Common.admins.get(i)){
                return logIn=true;
            }
        }
        return logIn==false;
    }

    @Override
    public boolean signUpValidation(Person p) {
        for(int i=0;i<Common.admins.size();i++){
            if(p == Common.admins.get(i)){
                return signUp=false;
            }
        }
        Admin ad=new Admin();
        ad.setUsername(p.getUsername());
        ad.setPassword(p.getPassword());
        //Common.admins.put(ad.getUsername(), ad);
        return signUp=true;


    }
  
    
}
    
    
