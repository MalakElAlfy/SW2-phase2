package ASEproject.fawrySystem.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import ASEproject.fawrySystem.model.RefundRequest;
import ASEproject.fawrySystem.model.Response;
import ASEproject.fawrySystem.service.AdminServiceImp;
import ASEproject.fawrySystem.transactionsModel.PaidTransactions;

@RestController
@RequestMapping("/AdminController")
public class AdminController {

    @Autowired
    private AdminServiceImp service;

    public AdminServiceImp getService() {
        return service;
    }

    public void setService(AdminServiceImp service) {
        this.service = service;
    }


    @PostMapping("/addSepcificDiscount")
    public Response addDiscount(@RequestParam int serviceID) 
   {
      System.out.println("in add discount" + serviceID);
      System.out.println("hi");
        boolean res = service.addDiscount(serviceID);
        
        Response response = new Response();
        if (!res) {
            response.setStatus(false);
            response.setMessage("Specific discount has not been added on this service.");
            return response;
        }

        response.setStatus(true);
        response.setMessage("Specific discount has been added successfully.");
        return response;
   }

   @PostMapping("/addOverAllDiscount")
   public Response addDiscountOnAll()
   {
    System.out.println("in add over all discount");
    boolean res = service.addDiscountOnAll();
    Response response = new Response();
    if (!res) {
        response.setStatus(false);
        response.setMessage("Over all discount has not been added on this service.");
        return response;
    }

    response.setStatus(true);
    response.setMessage("Over all discount has been added successfully.");
    return response;
   }

   
    @GetMapping("/getAllRequests")
    public RefundRequest[] getAllRequests()
    {
        System.out.println("in getAllRequests");
        return service.getAllRequests();
    }

    @GetMapping("/getAllTransactions")
    public PaidTransactions[] getAllTransactions()
    {
        System.out.println("in getAllTransactions");
        return service.getAllTransactions();
    }

    /* 
    @GetMapping("/reviewRefundRequest")
    public CompleteTransactions (@RequestParam int id)
    {
        //System.out.println("in getAllTransactions");

        return service.getAllTransactions();
    }
    */
    

    
}
