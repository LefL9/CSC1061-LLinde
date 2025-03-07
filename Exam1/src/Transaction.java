import java.time.LocalDate;

public class Transaction {
	private LocalDate transactionDate = java.time.LocalDate.now();
	private String transactionType;
	private double transactionAmount;
	private double newBalance;
	public Transaction(LocalDate transactionDate, String transactionType, double transactionAmount, double newBalance) {
		this.transactionDate = transactionDate;
		this.transactionType = transactionType;
		this.transactionAmount = transactionAmount;
		this.newBalance = newBalance;
	}
}
