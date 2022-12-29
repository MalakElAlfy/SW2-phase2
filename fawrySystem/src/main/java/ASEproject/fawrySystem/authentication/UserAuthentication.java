package ASEproject.fawrySystem.authentication;

import ASEproject.fawrySystem.model.Person;
import ASEproject.fawrySystem.model.User;
import ASEproject.fawrySystem.util.Common;

public class UserAuthentication extends Authentication{

    @Override
    public boolean logInValidation(Person p) {
        for(int i=0;i<Common.users.size();i++){
            if(p == Common.users.get(i)){
                return logIn=true;
            }
        }
        return logIn==false;
    }

    @Override
    public boolean signUpValidation(Person p) {
        for(int i=0;i<Common.users.size();i++){
            if(p == Common.users.get(i)){
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
