package ASEproject.fawrySystem.controllers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ASEproject.fawrySystem.model.Response;
import ASEproject.fawrySystem.model.User;
import ASEproject.fawrySystem.service.ServicesServiceImp;
import ASEproject.fawrySystem.service.UserServiceImp;
import ASEproject.fawrySystem.serviceProvidersModel.ServiceProviders;
import ASEproject.fawrySystem.servicesModel.Services;
import ASEproject.fawrySystem.transactionsModel.ActiveTransaction;


@RestController
@RequestMapping("/UserController")
public class UserController 
{

    @Autowired
    private UserServiceImp service;

    @Autowired
    private User model;


    public User getModel() {
        return model;
    }



    public void setModel(User model) {
        this.model = model;
    }

    @Autowired
    private ServicesServiceImp servicesService;


    public ServicesServiceImp getServicesService() {
        return servicesService;
    }



    public void setServicesService(ServicesServiceImp servicesService) {
        this.servicesService = servicesService;
    }



    @PostMapping("/addUser")
    public Response addUser(@RequestBody User user) {
        System.out.println("in add user" + user);
        boolean res = service.addUser(user);
        Response response = new Response();
        if (!res) {
            response.setStatus(false);
            response.setMessage("User already exists");
            return response;
        }

        response.setStatus(true);
        response.setMessage("User created successfully");
        return response;
    }

    

    @DeleteMapping("/delete/{username}")
    public Response deletePerson(@PathVariable("username") String username) {
        System.out.println("in delete with username:" + username);
        boolean res = service.deleteUser(username);
        Response response = new Response();
        if (!res) {
            response.setStatus(false);
            response.setMessage("Person Doesn't Exists");
            return response;
        }

        response.setStatus(true);
        response.setMessage("Person deleted successfully");
        return response;
    }

    @GetMapping("/get/{username}")
    public Response<User> getUser(@PathVariable("username") String username) {
        System.out.println("in get with username:" + username);
        
        var user = service.getUser(username);
        Response<User> response = new Response<User>();
        if (user == null) {
            response.setStatus(false);
            response.setMessage("User not found");
            response.object = null;

            return response;
        }

        response.setStatus(true);
        response.setMessage("User retrieved Successfully");
        response.object = (User) user;

        return response;
    }

    @GetMapping("/get")
    public User[] getAll() {
        //System.out.println("What do u want to do?");
        System.out.println("in getAll");
        return service.getAllUsers();
    }

    @PostMapping("/requestRefund/{id}")
    public void requestRefundForm(@PathVariable("id") int id)
    {
       // System.out.println("Enter the ID of the transaction you want to get a refund on: ");
        service.requestRefund(id);

        
    }

    @GetMapping("/selectServiceProvider/{serviceName}/{name}")
    public Response selectServiceProvider(@PathVariable("serviceName") String serviceName ,@PathVariable("name") String name) 
    {
        System.out.println("in searchForService:");
        Services wantedService = servicesService.searchForService(serviceName);
        ServiceProviders wantedServiceProvider= wantedService.selectServiceProvider(name);
        Response response = new Response();

        if (wantedService == null || wantedServiceProvider==null) {
            response.setStatus(false);
            response.setMessage("No service provider found with such name.");
            response.object = null;

            return response;
        }

        response.setStatus(true);
        response.setMessage("Service provider retrieved successfully");
        response.object = wantedServiceProvider;

        return response;
    }

    @PostMapping("/selectServiceProvider/{serviceName}/{name}/enterForm/paymentMethods/{choice}")
    public Response createForm(@PathVariable("serviceName") String serviceName ,@PathVariable("name") String name,@PathVariable ("choice") int choice, @RequestBody ActiveTransaction Active)
    {
        System.out.println("in /selectServiceProvider/{serviceName}/{name}/enterForm/paymentMethods/{choice}:");
        Services wantedService = servicesService.searchForService(serviceName);
        ServiceProviders wantedServiceProvider= wantedService.selectServiceProvider(name);
        Response response = new Response();
        
        if (wantedService == null || wantedServiceProvider==null) {
            response.setStatus(false);
            response.setMessage("No service provider found with such name.");
            response.object = null;
            
            return response;
        }
        
        //response.setStatus(true);
        //response.setMessage("Service provider retrieved successfully");
        response.object = wantedServiceProvider;
        model.setActive(Active);

        boolean paid=false;
        switch(choice)
       {
        case 1: paid=service.payWithCard();
                break;
        case 2: paid=service.payWithWallet();
                break;
        case 3: paid=service.payWithCOD();
                break;

        }

        if(paid)
        {
            response.setStatus(true);
            response.setMessage("Successful payment!");

        }
        else
        {
            response.setStatus(false);
            response.setMessage("Payment failed");

        }
        

        
        return response;
        
      
    }

    /*
    @PostMapping("/selectServiceProvider/{serviceName}/{name}/enterForm/paymentMethods/{choice}")
    public void paymentOptionsForm(@PathVariable("choice") int choice)
    {
        
       boolean status;
        

    }
     */



    
    
}