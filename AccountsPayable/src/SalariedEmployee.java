
public class SalariedEmployee extends Employee {
private double weeklySalary;



public SalariedEmployee(String firstName, String lastName, String socialSecurityNumber, double weeklySalary) {
	super(firstName, lastName, socialSecurityNumber);
	this.weeklySalary = weeklySalary;
}


public double getWeeklySalary() {
	return weeklySalary;
}

public void setWeeklySalary(double weeklySalary) {
	this.weeklySalary = weeklySalary;
}


@Override
public double getPaymentAmount() {
	return super.getPaymentAmount();
}


@Override
public String toString() {
	return "weeklySalary= " + weeklySalary  + "\n" + super.toString();
}


}
