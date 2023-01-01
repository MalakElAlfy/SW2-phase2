package ASEproject.fawrySystem.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import ASEproject.fawrySystem.admin.AdminServiceImp;
import ASEproject.fawrySystem.model.RefundRequest;
import ASEproject.fawrySystem.model.Response;
import ASEproject.fawrySystem.model.transactionsModel.AddToWalletTransactions;
import ASEproject.fawrySystem.model.transactionsModel.PaidTransactions;
import ASEproject.fawrySystem.model.transactionsModel.RefundTransactions;
import ASEproject.fawrySystem.user.User;
import ASEproject.fawrySystem.util.Common;

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

   

   
    @GetMapping("/getAllRequests")
    public RefundRequest[] getAllRequests()
    {
        System.out.println("in getAllRequests");
        return service.getAllRequests();
    }

    @GetMapping("/getAllPaidTransactions")
    public PaidTransactions[] getAllPaidTransactions()
    {
        System.out.println("in getAllTransactions");
        return service.getAllPaidTransactions();
    }

    @GetMapping("/getAllRefundTransactions")
    public RefundTransactions[] getAllRefundTransactions()
    {
        System.out.println("in getAllRefundTransactions");
        return service.getAllRefundTransactions();
    }

    @GetMapping("/getAllAddToWalletTransactions")
    public AddToWalletTransactions[] getAllAddToWalletTransactions()
    {
        System.out.println("in getAllAddToWalletTransactions");
        return service.getAllAddToWalletTransactions();
    }


    @PostMapping("/reviewRefundRequest/{id}")
    public Response reviewRefundRequest (@PathVariable ("id")int id, @RequestParam boolean accept)
    {
        System.out.println("in reviewRefundRequest: ");
        Response response = new Response();

        RefundRequest req=service.getRequest(id);

        if (req==null) {
            response.setStatus(false);
            response.setMessage("No such request has been proccessed. Please enter the correct id.");
            return response;
        }
    
        response.setStatus(true);
        response.setMessage("The request has been retrived successfully!");

        PaidTransactions trans=new PaidTransactions();
        trans=service.getPaidTrans(req.getTransID());


    
        if (trans==null) {
            response.setStatus(false);
            response.setMessage("No such transaction has been proccessed. Please enter the correct id.");
            return response;
        }
    
        response.setStatus(true);
        response.setMessage("Transaction of the refund request has been retrived successfully!");

        

        if(accept)
        {
            //boolean check ;
            service.acceptRefund(trans,id);

            response.setStatus(true);
            response.setMessage(" The refund request has been approved and the money has been added.");
            
            /* 
            if(check)
            {
                response.setStatus(true);
                response.setMessage("Refund has been completed successfully!");
        
            }
            else
            {
                response.setStatus(false);
                response.setMessage("Something wrond happened during accepting your refund.");

            }
            */

        }
        else
        {
            service.refuseRefund(id);

            response.setStatus(false);
            response.setMessage(" The refund request has not been approved!");
    

        }


        return response;
        
    }


    

    
}
