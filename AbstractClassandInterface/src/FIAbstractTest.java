import java.util.Arrays;


public class FIAbstractTest {

	public static void main(String[] args) {
		FIAbstract[] fiInsts = new FIAbstract[3];
		
		fiInsts[0] = new Bank("Second Bank", 2, 10200076, null, 2.67);
		fiInsts[1] = new CreditUnion("First CU", 1, 10200076, null, 3.67);
		fiInsts[2] = new Bank("Fifth", 5, 10200076, null, 4.67);

		for (FIAbstract fi: fiInsts) {
			System.out.println(fi);
		}
		Arrays.sort(fiInsts);
	}

}
