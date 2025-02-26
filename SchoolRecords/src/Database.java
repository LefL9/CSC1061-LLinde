import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class Database {

	public static final String FILENAME = "PersonDatabase.txt";

	public void writePerson(Person person) {
		File personFile = new File(FILENAME);
		if (!personFile.exists()) {
			try {
				personFile.createNewFile();
			} catch (IOException e) {
				System.out.println("Cannot create " + FILENAME);
				System.exit(-1);
			}

		}
		PrintWriter pWriter = null;
		try {
			pWriter = new PrintWriter(personFile.getName());

			pWriter.println("Class: " + person.getClass());
			pWriter.println("Name: " + person.getName());
			pWriter.println("Address: " + person.getAddress());
			pWriter.println("Phone: " + person.getPhoneNumber());
			pWriter.println("Email: " + person.getEmailAddress());
			pWriter.println();

		} catch (FileNotFoundException e) {
			System.exit(-1);
		}
		pWriter.close();

	}

	public ArrayList<String> readDatabase() {
		ArrayList<String> records = new ArrayList<>();
		Scanner input = null;
		try {
			input = new Scanner(new File(FILENAME));

			while (input.hasNextLine()) {
				String line = input.nextLine();
				records.add(line);
			}
		} catch (FileNotFoundException e) {
			System.out.println("Cannot read " + FILENAME);
			System.exit(-1);
		}
		input.close();
		return records;

	}
}
