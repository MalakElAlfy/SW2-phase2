package ASEproject.fawrySystem.authentication;

import org.springframework.stereotype.Service;

import ASEproject.fawrySystem.model.Person;
import ASEproject.fawrySystem.model.User;
import ASEproject.fawrySystem.util.Common;
@Service
public class UserAuthentication extends Authentication{

    @Override
    public boolean logInValidation(Person p) {
        for(int i=0;i<Common.users.size();i++){
            if(Common.users.get(p.getUsername())!=null){
                return logIn=true;
            }
        }
        return logIn=false;
    }
    
    @Override
    public boolean signUpValidation(Person p) {
        for(int i=0;i<Common.users.size();i++){
            if(Common.users.get(p.getUsername())!=null){
                return signUp=false;
            }
        }
        User userr=new User();
        userr.setUsername(p.getUsername());
        userr.setPassword(p.getPassword());
        Common.users.put(userr.getUsername(), userr);
        return signUp=true;
    }

}
