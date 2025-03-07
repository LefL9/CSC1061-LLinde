
public class SavingsAccount extends Account {
private double minimumBalance;
	public SavingsAccount(int id, double balance, double annualInterestRate, double minimumBalance) {
		super(id, balance, annualInterestRate);
	}

	public void withdraw(double withdrawAmount) {
		if (this.getBalance()-withdrawAmount < this.minimumBalance) {
			System.out.println("Cannot withdraw. Exceeds Limit.");
		} else {
			this.setBalance(this.getBalance() - withdrawAmount);
			transactions.add(new Transaction(getDateCreated(), "W", -1 * withdrawAmount, getBalance()));
		}
	}

	@Override
	public String toString() {
		return "SavingsAccount [minimumBalance=" + minimumBalance + ", getId()=" + getId() + ", getBalance()="
				+ getBalance() + ", getMonthlyInterest()=" + getMonthlyInterest() + "]";
	}
	
}
