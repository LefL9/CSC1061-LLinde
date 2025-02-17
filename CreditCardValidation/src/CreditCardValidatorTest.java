import java.util.Scanner;

public class CreditCardValidatorTest {
	private static Scanner scn = new Scanner(System.in);
	public static void main(String[] args) {
		System.out.println("Enter the credit card number:");
		long num = scn.nextLong();
		
		CreditCardValidator.isValid(num);
	}

}
