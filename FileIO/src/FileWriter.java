import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;

public class FileWriter {

	public static void main(String[] args) {
		File myFile = new File("fileWriteTest.txt");
		if (!myFile.exists()) {
			try {
				myFile.createNewFile();
			}
			catch (IOException e) {
				System.out.println(e.getMessage());
				System.out.println("Cannot write to " + myFile.getName());
				System.exit(-1);
			}
			
		}
	PrintWriter pWriter = null;
	try {
		pWriter = new PrintWriter(myFile.getName());
		//pWriter = new PrintWriter(new FileOutputStream(myFile,true));
	}
	catch (FileNotFoundException e) {
		System.out.println(e.getMessage());
		System.exit(-1);
	}
	pWriter.println("The moon is full today");
	//pWriter.flush();
	pWriter.close();
}
	
}