package ASEproject.fawrySystem.api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


import ASEproject.fawrySystem.model.Response;
import ASEproject.fawrySystem.model.transactionsModel.ActiveTransaction;
import ASEproject.fawrySystem.model.transactionsModel.AddToWalletTransactions;
import ASEproject.fawrySystem.model.transactionsModel.PaidTransactions;
import ASEproject.fawrySystem.service.ServicesServiceImp;
import ASEproject.fawrySystem.service.servicesModel.Services;
import ASEproject.fawrySystem.serviceProviders.formModel.Form;
import ASEproject.fawrySystem.serviceProviders.formModel.VodafoneIPform;
import ASEproject.fawrySystem.serviceProviders.serviceProvidersModel.ServiceProviders;
import ASEproject.fawrySystem.user.User;
import ASEproject.fawrySystem.user.UserServiceImp;
import ASEproject.fawrySystem.util.Common;

import com.fasterxml.jackson.databind.json.*;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;


@RestController
@RequestMapping("/UserController")
public class UserController 
{

    @Autowired
    private UserServiceImp service;


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

    @PutMapping("/{id}/updateUser/addToCreditCard/{money}")
    public Response addCredit(@PathVariable ("id") int id, @PathVariable ("money")double money)
     {
       System.out.println("in /{id}/updateUser/addToCreditCard");
        User user=service.getActiveUser(id);
        service.setModel(user);

        service.addToCreditCard(money);
        Response<User> response = new Response<User>();
        if (user==null) {
            response.setStatus(false);
            response.setMessage("User does not exist");
            return response;
        }

        response.setStatus(true);
        response.setMessage("User retrived successfully and " + money + "EGP has been added to your credit card.");
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
        
        User user = service.getUser(username);
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
        
        System.out.println("in getAll: ");
        return service.getAllUsers();
    }

    @GetMapping("/getAllActiveUsers")
    public User[] getAllActiveUsers() {
        
        System.out.println("in getAllActiveUsers: ");
        return service.getAllActiveUsers();
    }

    @PostMapping("/{myID}/requestRefund/{id}")
    public Response requestRefundForm(@PathVariable("myID") int myID,@PathVariable("id") int id)
    {
        Response response = new Response();

        PaidTransactions paidTrans=new PaidTransactions();

        paidTrans=Common.completeTrans.get(id);

        if (paidTrans == null) {
            response.setStatus(false);
            response.setMessage("No such transaction has been processed.");
            response.object = null;

            return response;
        }

        response.setStatus(true);
        response.setMessage("Transaction has been retrieved successfully.");
        response.object = null;



       User user=service.getActiveUser(myID);
       service.setModel(user);



        int reqID=service.requestRefund(id);
        if (reqID == 0) {
            response.setStatus(false);
            response.setMessage("The request has not been processed.");
            response.object = null;

            return response;
        }

        response.setStatus(true);
        response.setMessage("The request has been processed. The request ID is: " + reqID);
        response.object = null;
        return response;




        
    }

    @GetMapping("/{id}/selectServiceProvider/{serviceName}/{name}")
    public Response selectServiceProvider(@PathVariable("id") int id,@PathVariable("serviceName") String serviceName ,@PathVariable("name") String name) 
    {
        System.out.println("in searchForService:");

        User user=service.getActiveUser(id);
        service.setModel(user);

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


    @GetMapping("/{id}/searchForService/{serviceName}")
    public Response searchForService(@PathVariable("id") int id,@PathVariable("serviceName") String serviceName ) 
    {
        System.out.println("in searchForService:");

        User user=service.getActiveUser(id);
        service.setModel(user);

        Services wantedService = servicesService.searchForService(serviceName);
        


        Response response = new Response();

        if (wantedService == null ) {
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

@PostMapping("/{id}/selectServiceProvider/{serviceName}/{name}/paymentMethods/{choice}")
public Response createForm(@PathVariable ("id") int id,@PathVariable("serviceName") String serviceName ,@PathVariable("name") String name, @RequestBody ActiveTransaction activeTrans, @PathVariable ("choice")int  choice)
{
    System.out.println("in /{id}/selectServiceProvider/{serviceName}/{name}/enterForm/paymentMethods/{choice}:");
        
    Response response = new Response();

    User user=service.getActiveUser(id);
        
        
    if(user==null)
    {
        response.setStatus(false);
        response.setMessage("Can't retrieve active user.");
        response.object = null;
        return response;
            
    }
    service.setModel(user);

    Services wantedService = servicesService.searchForService(serviceName);
        


       
        if (wantedService == null ) {
            response.setStatus(false);
            response.setMessage("No service found with such name.");
            response.object = null;

            return response;
        }

        ServiceProviders wantedServiceProvider=wantedService.selectServiceProvider(name);

        if (wantedServiceProvider == null ) {
            response.setStatus(false);
            response.setMessage("No service provider found with such name.");
            response.object = null;

            return response;
        }

    Form form=servicesService.createCustomForm(wantedService,wantedServiceProvider,activeTrans);
    
    boolean handle=form.handleForm();
    
    if (handle == false ) 
    {
        response.setStatus(false);
        response.setMessage("Wrong entries in the form!");
        response.object = null;
        
        return response;
    }

    boolean specific=wantedService.isSpecificDisc();
    boolean overAll=service.hasOverAllDiscount();
    
    if(specific)
    {
        service.applySpecificDiscount(activeTrans);

    }
    if(overAll)
    {
        service.applyOverAllDiscount(activeTrans);

    }
    
    



        boolean check=false;
        switch(choice)
        {
            case 1: 
            {
                check=service.payWithCard(activeTrans);
                break;
            }
            case 2: 
            {
                check=service.payWithWallet(activeTrans);
                break;

            }
            case 3: 
            {
                if(wantedService.getAcceptsCOD())
                {
                    check=service.payWithCOD(activeTrans);
                    break;

                }
                else
                {
                    response.setStatus(false);
                    response.setMessage("This service does not have cash on delivery. Please select another payment method.");
                    response.object = null;

                    return response;


                }
            }

        }

        if(check)
        {
            response.setStatus(true);
            response.setMessage("Payment successful. Your transaction id: " + service.getModel().getMyCurrentTransId());
            response.object = service.getModel();

            return response;

        }
        else
        {
            response.setStatus(false);
            response.setMessage("Payment failure.");
            response.object = service.getModel();

            return response;
            
        }


}

    @PostMapping("/{id}/addFundsToWallet")
    public Response addFunds(@PathVariable ("id") int id ,@RequestParam double amount) {
        System.out.println("in add funds" + amount);

        User user = service.getActiveUser(id);
        Response<User> response = new Response<User>();

        boolean res = user.addFunds(amount);
        if (!res) {
            response.setStatus(false);
            response.setMessage("Could not add funds. Check your credit card balance.");
            response.object=user;
            return response;
        }

        long time=System.currentTimeMillis();

        AddToWalletTransactions trans=new AddToWalletTransactions(amount, user,time);
        trans.setId();
        Common.addToWalletTrans.put(trans.getId(),trans);


        response.setStatus(true);
        response.setMessage("Funds successfully added to your wallet!");
        response.object=user;
        return response;
    }

    @PutMapping("/{id}/logOut")
    public Response logOut(@PathVariable ("id") int id//@RequestParam String username
    ) {
        System.out.println("in log out: " );

        
        boolean res = service.checkIfActive(id);

        Response response = new Response();
        if (!res) {
            response.setStatus(false);
            response.setMessage("You are not currently active to log out of the system.");
            return response;
        }

        //boolean check= 
        service.removeFromCurrentUsers(id);

        response.setStatus(true);
        response.setMessage("You have successfully logged out!");
        return response;
    }

    @GetMapping("/{id}/checkDiscounts/{serviceName}")
    public Response checkDiscounts(@PathVariable("id") int id ,@PathVariable("serviceName") String serviceName) 
    {
        System.out.println("in checkDiscounts:");
        boolean res=service.checkIfActive(id);

        Response response = new Response();


       
        if (!res) {
            response.setStatus(false);
            response.setMessage("You are not currently active, we can't proccess your request.");
            return response;
        }
        


        User user=service.getActiveUser(id);
        service.setModel(user);
        boolean specific = servicesService.hasSpecificDiscount(serviceName);
        boolean overAll = service.hasOverAllDiscount();


        if (!specific && !overAll) {
            response.setStatus(false);
            response.setMessage("This service has no discount.");
            return response;
        }
        else if (!specific && overAll) {
            response.setStatus(false);
            response.setMessage("This service has an over all discount.");
            return response;
        } 
        else if (specific && !overAll) {
            response.setStatus(false);
            response.setMessage("This service has a spedific  discount.");
            return response;
        }
        else 
        {
            response.setStatus(true);
            response.setMessage("This service has a specific discount AND an over all discount!");

        }

        return response;
    }

    
}