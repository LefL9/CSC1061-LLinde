
public class TestGeometricObject {

	public static void main(String[] args) {
		Circle circ1 = new Circle();
		System.out.println(circ1);
		Circle circ2 = new Circle ("Red", true, 1.0);
		System.out.println(circ2);
		System.out.printf("%.2f\n", circ2.getArea());
		if (circ1.equals(circ2)) {
			System.out.println("yes they are equal");
		}
	}

}
