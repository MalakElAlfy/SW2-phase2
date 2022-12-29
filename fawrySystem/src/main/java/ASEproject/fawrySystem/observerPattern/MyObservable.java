package ASEproject.fawrySystem.observerPattern;

import ASEproject.fawrySystem.model.RefundRequest;

public interface MyObservable {
    
    public void notifyUpdate(RefundRequest req);
    
}
