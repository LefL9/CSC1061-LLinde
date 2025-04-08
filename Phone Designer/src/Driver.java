
public class Driver {

	public static void main(String[] args) {
		FlipModel flip1 = new FlipModel("123456789012345");
		FlipModel flip2 = new FlipModel("987654321098765");
		FoldModel fold1 = new FoldModel("111122223333444");
		BarModel bar1 = new BarModel("999988887777666");

		System.out.println(flip1.toString());
		System.out.println(flip2.toString());
		System.out.println(fold1.toString());
		System.out.println(bar1.toString());

		System.out.println("Comparing flip1 and flip2: " + flip1.compareTo(flip2)); // Should be 0 (same specs)

		FlipModel flipClone = (FlipModel) flip1.clone();

		flipClone.getImei().set(0, '3'); // Change first character
		System.out.println("\nAfter cloning and modifying IMEI:");
		System.out.println("Original IMEI: " + flip1.getImei());
		System.out.println("Cloned IMEI:   " + flipClone.getImei());

		System.out.println("\nRepair Info:");
		System.out.println("Flip1: " + flip1.howToRepair() + " Cost: $" + flip1.costToRepair());
		System.out.println("Bar1:  " + bar1.howToRepair() + " Cost: $" + bar1.costToRepair());

	}

}
