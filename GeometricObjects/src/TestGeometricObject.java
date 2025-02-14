import java.io.FileNotFoundException;

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
	
	Rectangle rect1 = new Rectangle();
	try {
	Database.writeGeometricObject(circ1);
	Database.writeGeometricObject(rect1);
	Database.writeGeometricObject(circ2);
	}
	catch(GeometricObjectDBException e) {
		System.out.println(e.getMessage());
		System.exit(-1);
	}
	try {
		Database.readGeometricObject();
	} catch (FileNotFoundException e) {
		
	}
}
}
