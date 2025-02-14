
public class CommissionEmployee extends Employee {
private double grossSales;
private double commissionRate;


public CommissionEmployee(String firstName, String lastName, String socialSecurityNumber, double grossSales, double commissionRate) {
	super(firstName, lastName, socialSecurityNumber);
	this.grossSales = grossSales;
	this.commissionRate = commissionRate;
}


public double getGrossSales() {
	return grossSales;
}


public void setGrossSales(double grossSales) {
	this.grossSales = grossSales;
}


public double getCommissionRate() {
	return commissionRate;
}


public void setCommissionRate(double commissionRate) {
	this.commissionRate = commissionRate;
}


@Override
public double getPaymentAmount() {
	return grossSales*commissionRate;
}


@Override
public String toString() {
	return "grossSales= " + grossSales + "\ncommissionRate= " + commissionRate + "\n" + 
"Payment amount= " + getPaymentAmount() +"\n"+ super.toString();
}


}
