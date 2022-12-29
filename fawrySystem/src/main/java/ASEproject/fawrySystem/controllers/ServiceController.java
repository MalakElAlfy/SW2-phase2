package ASEproject.fawrySystem.controllers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ASEproject.fawrySystem.model.Response;
import ASEproject.fawrySystem.service.ServicesService;
import ASEproject.fawrySystem.service.ServicesServiceImp;
import ASEproject.fawrySystem.service.UserServiceImp;
import ASEproject.fawrySystem.serviceProvidersModel.ServiceProviders;
//import ASEproject.fawrySystem.servicesModel.Service;
import ASEproject.fawrySystem.servicesModel.Services;
@RestController
@RequestMapping("/ServiceController")
public class ServiceController {


    @Autowired
    private ServicesServiceImp service;

    @Autowired
    private UserServiceImp userService;

    public UserServiceImp getUserService() {
        return userService;
    }

    public void setUserService(UserServiceImp userService) {
        this.userService = userService;
    }

    public ServicesService getService() {
        return service;
    }

    public void setService(ServicesServiceImp service) {
        this.service = service;
    }

    @GetMapping("/searchForService/{name}")
    public Response searchForService(@PathVariable("name") String name) 
    {
        System.out.println("in searchForService:");
        Services wantedService = service.searchForService(name);
        Response response = new Response();
        if (wantedService == null) {
            response.setStatus(false);
            response.setMessage("No service found with such name.");
            response.object = null;

            return response;
        }

        response.setStatus(true);
        response.setMessage("Service retrieved successfully");
        response.object = wantedService;

        return response;
    }


    
    

    


    
}
