package ASEproject.fawrySystem.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ASEproject.fawrySystem.model.Response;
import ASEproject.fawrySystem.util.Common;
import ASEproject.fawrySystem.admin.Admin;
import ASEproject.fawrySystem.authentication.AdminAuthentication;

@RestController
@RequestMapping("/AdminAuthenticationController")
public class AdminAuthenticationController {
    @Autowired
    private AdminAuthentication adminAuth=new AdminAuthentication();

    @PostMapping("/adminLogin")
    public Response adminLogin(@RequestBody Admin admin){
        boolean res = adminAuth.logInValidation(admin);
        Response response = new Response();
        if (!res) {
            response.setStatus(false);
            response.setMessage("This account doesn't exist. Please make sure you entered your credentials correctly." );
            return response;
        }
        response.setStatus(true);
        response.setMessage("You have logged in as the admin successfully. ");
        return response;
    }
    
}