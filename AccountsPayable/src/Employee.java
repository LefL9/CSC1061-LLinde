
public class Employee {
private String firstName;
private String lastName;
private String socialSecurityNumber;


public double getPaymentAmount() {
	return 0.0;
}
//return amount employee is paid
//needs to be overridden


public Employee() {
	
}

public Employee(String firstName, String lastName, String socialSecurityNumber) {
	super();
	this.firstName = firstName;
	this.lastName = lastName;
	this.socialSecurityNumber = socialSecurityNumber;
}

public String getFirstName() {
	return firstName;
}

public void setFirstName(String firstName) {
	this.firstName = firstName;
}

public String getLastName() {
	return lastName;
}

public void setLastName(String lastName) {
	this.lastName = lastName;
}

public String getSocialSecurityNumber() {
	return socialSecurityNumber;
}

public void setSocialSecurityNumber(String socialSecurityNumber) {
	this.socialSecurityNumber = socialSecurityNumber;
}

@Override
public String toString() {
	return "firstName= " + firstName + "\nlastName= " + lastName + "\nsocialSecurityNumber="
			+ socialSecurityNumber;
}


}
