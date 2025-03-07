import java.time.LocalDate;
import java.util.ArrayList;

public class Account {
	private int id = 0;
	private double balance = 0.0;
	private double annualInterestRate = 0.0;
	private LocalDate dateCreated = java.time.LocalDate.now();
	private String name;
	ArrayList<Transaction> transactions = new ArrayList<>();


	// no arg constructor
	public Account() {

	}

//constructor with id and balance
	public Account(int id, double balance) {
		this.id = id;
		this.balance = balance;
	}
	public Account(int id, double balance, double annualInterestRate) {
		this.id = id;
		this.balance = balance;
		this.annualInterestRate = annualInterestRate;
	}
	

	public Account(int id, double balance, double annualInterestRate, LocalDate dateCreated, String name) {
		this.id = id;
		this.balance = balance;
		this.annualInterestRate = annualInterestRate;
		this.dateCreated = dateCreated;
		this.name = name;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	public double getAnnualInterestRate() {
		return annualInterestRate;
	}

	public void setAnnualInterestRate(double annualInterestRate) {
		this.annualInterestRate = annualInterestRate;
	}

	public LocalDate getDateCreated() {
		return dateCreated;
	}

	public double getMonthlyInterestRate() {
		return getAnnualInterestRate() / 12;
	}

	public double getMonthlyInterest() {
		return getBalance() * (getMonthlyInterestRate() / 100);
	}

	public void withdraw(double withdrawAmount) {
		this.setBalance(this.getBalance() - withdrawAmount);
		transactions.add(new Transaction(dateCreated, "W", -1 * withdrawAmount, getBalance()));
		
	}

	public void deposit(double depositAmount) {
		this.setBalance(this.getBalance() + depositAmount);
		transactions.add(new Transaction(dateCreated, "D", depositAmount, getBalance()));
	}

	@Override
	public String toString() {
		return "Account [id=" + id + ", balance=" + balance + ", annualInterestRate=" + annualInterestRate
				+ ", dateCreated=" + dateCreated + "]";
	}
	
}
