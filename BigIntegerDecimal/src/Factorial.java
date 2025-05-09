import java.math.BigInteger;

public class Factorial {

	public static void main(String[] args) {
		
		System.out.println("The answer is " + factorial(BigInteger.valueOf(40)));

	}

	public static BigInteger factorial(BigInteger num) {
		if (num.equals(BigInteger.ZERO)) {
			return BigInteger.ONE;
		}
		
		return num.multiply (factorial(num.subtract(BigInteger.ONE)));
	}

}
