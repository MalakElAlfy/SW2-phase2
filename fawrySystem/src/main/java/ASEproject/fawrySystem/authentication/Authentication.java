package ASEproject.fawrySystem.authentication;

import ASEproject.fawrySystem.model.Person;

public abstract class Authentication {

    protected boolean logIn;
    protected boolean signUp;




    public boolean logInValidation(Person p)
    {
        return logIn;
    };

    public boolean signUpValidation(Person p)
    {
        return signUp;
    };
    


    
}
