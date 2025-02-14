
public class BasePlusCommissionEmployee extends CommissionEmployee {
private double basePay;

public BasePlusCommissionEmployee(String firstName, String lastName, String socialSecurityNumber, double grossSales,
		double commissionRate, double basePay) {
	super(firstName, lastName, socialSecurityNumber, grossSales, commissionRate);
	this.basePay = basePay;
}

public double getBasePay() {
	return basePay;
}

public void setBasePay(double basePay) {
	this.basePay = basePay;
}

@Override
public double getPaymentAmount() {
	
	return super.getPaymentAmount()+basePay;
}

@Override
public String toString() {
	return "basePay= " + basePay + "\n" + super.toString();
}

}
