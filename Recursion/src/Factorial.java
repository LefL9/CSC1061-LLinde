
public class Factorial {

	public static void main(String[] args) {
		System.out.println("The answer is " + factorial(19));

	}

	public static long factorial(int num) {
		if (num == 0) {
			return 1;
		}
		return num * factorial(num - 1);
	}

}
