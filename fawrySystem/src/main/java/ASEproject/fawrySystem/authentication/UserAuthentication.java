package ASEproject.fawrySystem.authentication;

import org.springframework.stereotype.Service;

import ASEproject.fawrySystem.model.Person;
import ASEproject.fawrySystem.user.User;
import ASEproject.fawrySystem.util.Common;
@Service
public class UserAuthentication extends Authentication{

    @Override
    public boolean logInValidation(Person p) {
        for(int i=0;i<Common.users.size();i++){
            if(Common.users.get(p.getUsername())!=null)
            {
                if(p.getEmail()==Common.users.get(p.getUsername()).getEmail() && p.getPassword()==Common.users.get(p.getUsername()).getPassword())
                {
                    User user=new User();
                    user=Common.users.get(p.getUsername());
                    user.setId();
                    Common.currentUsers.put(user.getId(), user);
                    logIn=true;
                    return logIn;
                }
            }
        }
        return logIn;
    }
    
    @Override
    public boolean signUpValidation(Person p) {
        for(int i=0;i<Common.users.size();i++){
            if(Common.users.get(p.getUsername())!=null)
            {
                signUp=false;
                return signUp;
            }
        }
        User userr=new User();
        userr.setUsername(p.getUsername());
        userr.setPassword(p.getPassword());
        userr.setEmail(p.getEmail());
        userr.setId();

        Common.users.put(userr.getUsername(), userr);
        Common.currentUsers.put(userr.getId(), userr);
        
        signUp=true;
        return signUp;
    }

}
