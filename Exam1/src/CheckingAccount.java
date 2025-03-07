
public class CheckingAccount extends Account {
	private double overdraftLimit;

	public CheckingAccount(int id, double balance, double annualInterestRate, double overdraftLimit) {
		super(id, balance, annualInterestRate);
		this.overdraftLimit = overdraftLimit;
	}

	public double getOverdraftLimit() {
		return overdraftLimit;
	}

	public void setOverdraftLimit(double overdraftLimit) {
		this.overdraftLimit = overdraftLimit;
	}
	public void withdraw(double withdrawAmount) {
		if ((0 - this.getOverdraftLimit())> (this.getBalance()-withdrawAmount)) {
			System.out.println("Cannot withdraw. Exceeds Overdraft Limit.");
		}
		else {
			this.setBalance(this.getBalance() - withdrawAmount);
			transactions.add(new Transaction(getDateCreated(), "W", -1 * withdrawAmount, getBalance()));
		}
	}

	@Override
	public String toString() {
		return "Overdraft Limit:" + overdraftLimit + "\nId:" + getId() + "\nBalance:"
				+ getBalance() + "\nDateCreated:" + getDateCreated() + "\nMonthly Interest: " + getMonthlyInterest();
	}
	
}
