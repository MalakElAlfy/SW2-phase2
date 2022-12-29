package ASEproject.fawrySystem.authentication;

import ASEproject.fawrySystem.model.Person;

public abstract class Authentication {

    boolean logIn=false;
    boolean signUp=false;


    public boolean logInValidation(Person p)
    {
        return logIn;
    };

    public boolean signUpValidation(Person p)
    {
        return signUp;
    };


    
}
