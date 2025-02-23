import java.util.Arrays;


public class FIAbstractTest {

	public static void main(String[] args) throws CloneNotSupportedException {
		FIAbstract[] fiInsts = new FIAbstract[3];
		
		fiInsts[0] = new Bank("Second Bank", 2, 10200076, null, 2.67);
		fiInsts[1] = new CreditUnion("First CU", 1, 10200076, null, 3.67);
		fiInsts[2] = new Bank("Fifth", 5, 10200076, null, 4.67);

		for (FIAbstract fi: fiInsts) {
			System.out.println(fi);
		}
		Arrays.sort(fiInsts);
		Address addr = new Address();
		addr.setLine1("555 merry way");
		addr.setZip(80525);
		
		Bank bank1 = new Bank("Original bank", 4, 1020006, addr, 2.5);
		
		System.out.println("Bank1 Name: " + bank1.getFIName());
		System.out.println("Bank1 Addr: " + bank1.getAddress().getLine1());
		System.out.println("Bank1 zip: " + bank1.getAddress().getZip());
		
		Bank bank2 = (Bank) bank1.clone();
		
		bank2.setFIName("New Bank");
		Address newAddr = new Address();
		newAddr.setLine1("666 Spooky St");
		newAddr.setZip(666666);
		bank2.setAddress(newAddr);
		
		System.out.println("Bank2 Name: " + bank2.getFIName());
		System.out.println("Bank2 Addr: " + bank2.getAddress().getLine1());
		System.out.println("Bank2 zip: " + bank2.getAddress().getZip());
	}

}
