import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;

public class Database {
	
	public void writePerson(Person person) {
		File personFile = new File("PersonDatabase.txt");
		if (!personFile.exists()) {
			try {
				personFile.createNewFile();
			} catch (IOException e) {
				System.out.println(e.getMessage());
				System.out.println("Cannot write to " + personFile.getName());
				System.exit(-1);
			}

		}
		PrintWriter pWriter = null;
		try {
			pWriter = new PrintWriter(personFile.getName());

		} catch (FileNotFoundException e) {
			System.out.println(e.getMessage());
			System.exit(-1);
		}
		
		
		
	}
}
