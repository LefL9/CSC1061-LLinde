
public class Driver {

	public static void main(String[] args) {
		CheckingAccount test1 = new CheckingAccount(1111, 2000, 0.5, 200);
		test1.withdraw(2100);
		test1.deposit(3000);

		System.out.println(test1.toString());
		SavingsAccount test2 = new SavingsAccount(1100, 500, 1.0,200);
		test2.withdraw(300);
		System.out.println(test2.toString());
		

	}
	
}
