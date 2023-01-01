package ASEproject.fawrySystem.user.payment;

public abstract class Payment {
	
	public double credit;

	//double walletCredit = 0;

	public abstract Boolean pay(double money);

	public void refundMoney(double refundedAmount) {
		
	}

	

}
