package ASEproject.fawrySystem.transactionsService;
import java.lang.annotation.Annotation;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RestController;

import ASEproject.fawrySystem.transactionsModel.PaidTransactions;
import ASEproject.fawrySystem.transactionsView.CompleteTransactionsView;
import ASEproject.fawrySystem.util.Common;

@Service
public class CompleteTransactionsService implements Service{

    private PaidTransactions model;
    private CompleteTransactionsView view;

    
    public CompleteTransactionsView getView() {
        return view;
    }

    public void setView(CompleteTransactionsView view) {
        this.view = view;
    }

    public PaidTransactions getModel() {
        return model;
    }

    public void setModel(PaidTransactions model) {
        this.model = model;
    }

    public void addTransaction(PaidTransactions trans)
    {
        Common.completeTrans.put(trans.getId(), trans);

    }

    @Override
    public Class<? extends Annotation> annotationType() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public String value() {
        // TODO Auto-generated method stub
        return null;
    }
    
}
