
public class FibRecurse {
	private static long counter = 0;
	private static long[] termArray = new long[200];

	public static void main(String[] args) {
		// compute the nth term
		System.out.println("The answer is " + fibIterative(150));

	}

	public static long fibRecurse(int n) {
		if (n <= 1) {
			return n;
		}
		counter++;
		return fibRecurse(n - 1) + fibRecurse(n - 2);

	}

//recursively opens stack, stores results to access
	public static long fibDynamic(int n) {
		if (n < 2) {
			return n;
		}
		if (termArray[n] > 0) {
			return termArray[n];
		}
		counter++;
		long ans = fibDynamic(n - 1) + fibDynamic(n - 2);
		termArray[n] = ans;
		return ans;
	}

	public static long fibIterative(int n) {
		if (n < 2) {
			return n;
		}
		long prevTerm1 = 1;
		long prevTerm2 = 0;
		long currTerm = 0;
		for (int i = 2; i <= n; i++) {
			currTerm = prevTerm1 + prevTerm2;
			prevTerm2 = prevTerm1;
			prevTerm1 = currTerm;
		}
		return currTerm;
	}
}
