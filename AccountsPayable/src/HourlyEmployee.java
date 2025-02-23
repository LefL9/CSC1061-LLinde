
public class HourlyEmployee extends Employee {
	private double hourlyWage;
	private double hours;

	public HourlyEmployee(String firstName, String lastName, String socialSecurityNumber, double hourlyWage,
			double hours) {
		super(firstName, lastName, socialSecurityNumber);
		this.hourlyWage = hourlyWage;
		this.hours = hours;
	}

	public double getHourlyWage() {
		return hourlyWage;
	}

	public void setHourlyWage(double hourlyWage) {
		this.hourlyWage = hourlyWage;
	}

	public double getHours() {
		return hours;
	}

	public void setHours(double hours) {
		this.hours = hours;

	}

	@Override
	public double getPaymentAmount() {
		return hourlyWage * hours;
	}

	@Override
	public String toString() {
		return "hourlyWage= " + hourlyWage + "\nhours=" + hours + "\nPayment amount= " + getPaymentAmount() + "\n"
				+ super.toString();
	}

}
