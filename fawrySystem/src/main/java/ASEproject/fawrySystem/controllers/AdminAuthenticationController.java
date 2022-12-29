package ASEproject.fawrySystem.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ASEproject.fawrySystem.model.Response;
import ASEproject.fawrySystem.authentication.AdminAuthentication;
import ASEproject.fawrySystem.model.Admin;

@RestController
@RequestMapping("/AdminAuthenticationController")
public class AdminAuthenticationController {
    @Autowired
    private AdminAuthentication adminAuth=new AdminAuthentication();
    @PostMapping("/adminSignup")
    public Response adminSignUp(@RequestBody Admin admin){
        boolean res = adminAuth.signUpValidation(admin);
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
    @PostMapping("/adminLoginin")
    public Response userLoginin(@RequestBody Admin admin){
        boolean res = adminAuth.logInValidation(admin);
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
