package ASEproject.fawrySystem.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ASEproject.fawrySystem.model.Person;
import ASEproject.fawrySystem.model.Response;
import ASEproject.fawrySystem.user.User;
import ASEproject.fawrySystem.authentication.UserAuthentication;
import ASEproject.fawrySystem.util.Common;

@RestController
@RequestMapping("/UserAuthenticationController")
public class UserAuthenticationController {
    @Autowired
    private UserAuthentication userAuth=new UserAuthentication();
    @PostMapping("/signup")
    public Response userSignUp(@RequestBody User user){
        boolean res = userAuth.signUpValidation(user);

        Response response = new Response();
        if (!res) {
            response.setStatus(false);
            response.setMessage("This account already exists");
            return response;
        }

        User myUser= Common.users.get(user.getUsername());
        int id=myUser.getId();

        response.setStatus(true);
        response.setMessage("The account has been created successfully, your id is: " + id);
        return response;
    }
    @PostMapping("/login")
    public Response userLoginin(@RequestBody User user){
        boolean res = userAuth.logInValidation(user);
        Response response = new Response();
        if (!res) {
            response.setStatus(false);
            response.setMessage("This account doesn't exist. Please sign up");
            return response;
        }

        User myUser= Common.users.get(user.getUsername());
        int id=myUser.getId();

        response.setStatus(true);
        response.setMessage("You have logged in successfully, your id is: "+ id);
        return response;
    }
}