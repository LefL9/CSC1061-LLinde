import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;
import java.lang.Boolean;

public class Database {
static final String fileName = "Database.csv";
static File outFile = new File(fileName);
static PrintWriter printer;
static Scanner input; 

public static void writeGeometricObject(GeometricObject obj)throws GeometricObjectDBException {
	if(printer == null) {
	try {
		printer = new PrintWriter(outFile.getName());
	} catch (FileNotFoundException e) {
		throw new GeometricObjectDBException(
				"Database creation error");
			}
		}
	printer.print(obj.getClass().getName() + "," + obj.getColor() + "," +
		obj.isFilled() + "," + obj.getDateCreated());
	if(obj instanceof Circle) {
		
		printer.print("," + ((Circle)obj).getRadius());
	}
	if(obj instanceof Rectangle) {
		
		printer.print("," + ((Rectangle)obj).getWidth());
		printer.print("," + ((Rectangle)obj).getHeight());
	}
	printer.print("\n");
	printer.flush();
	}

	public static GeometricObject readGeometricObject() throws FileNotFoundException {
		if (input == null) {
				input = new Scanner(outFile);
		}
		if(input.hasNextLine()) {
			String line = input.nextLine();
			String[] tokens = line.split(",");
			if (tokens[0].equals("Circle")) {
				Circle circ = new Circle(tokens[1], Boolean.parseBoolean(tokens[2])
						, Double.parseDouble(tokens[4]));
				return circ;
			}
		}
		
		return null;
	}
}
