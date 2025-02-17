
public class CreditUnion extends FIAbstract{
private double interestRate;
	
	public CreditUnion(String fIName, long fiID, long routingNumber, Address address, double interestRate) {
		super(fIName, fiID, routingNumber, address);
		this.interestRate = interestRate;
	}

	@Override
	public double getInterestRate() {
		return interestRate;
	}
}
