package ASEproject.fawrySystem.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ASEproject.fawrySystem.model.Person;
import ASEproject.fawrySystem.model.Response;
import ASEproject.fawrySystem.authentication.UserAuthentication;
import ASEproject.fawrySystem.model.User;

@RestController
@RequestMapping("/UserAuthenticationController")
public class UserAuthenticationController {
    @Autowired
    private UserAuthentication userAuth=new UserAuthentication();
    @PostMapping("/userSignup")
    public Response userSignUp(@RequestBody User user){
        boolean res = userAuth.signUpValidation(user);
        Response response = new Response();
        if (!res) {
            response.setStatus(false);
            response.setMessage("This account already exists");
            return response;
        }
        response.setStatus(true);
        response.setMessage("The account has been created successfully");
        return response;
    }
    @PostMapping("/userLoginin")
    public Response userLoginin(@RequestBody User user){
        boolean res = userAuth.logInValidation(user);
        Response response = new Response();
        if (!res) {
            response.setStatus(false);
            response.setMessage("This account doesn't exist. Please sign up");
            return response;
        }
        response.setStatus(true);
        response.setMessage("You have logged in successfully");
        return response;
    }
}
