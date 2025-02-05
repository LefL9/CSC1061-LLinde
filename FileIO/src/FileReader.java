import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
//if you close scanner, it closes files as well. closes system.in and can't be opened again

public class FileReader {

	public static void main(String[] args) throws FileNotFoundException{
		File readFile = new File("fileWriteTest.txt");
		Scanner input = null;
		try {
		input = new Scanner(readFile);
		}
		catch(FileNotFoundException e){
			System.out.println(e.getMessage());
			System.exit(-1);
		}
		while(input.hasNextLine()) {
			String line = input.nextLine();
			System.out.println(line);
		}
		input.close();
	}

}
