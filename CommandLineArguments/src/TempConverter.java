
public class TempConverter {

	public static void main(String[] args) {
		
		double answer = 0;
		double input = 30;
		if(args.length < 2) {
			System.out.println("Usage:");
			System.out.println("\t -f temp Convert celsius to fahrenheit");
			System.out.println("\t -c temp Convert fahrenheit to celsius");
		}
		answer = ConvertFahToCel(input);
		//answer = ConvertCelToFah(input);
		//System.out.println("The fahrenheit value is " + answer);
		if(args[0].equals("-c")) {
			answer = ConvertFahToCel(Double.parseDouble(args[1]));
			System.out.println("The celsius value is " + answer);
		}
		if(args[0].equals("-f")) {
			answer = ConvertCelToFah(Double.parseDouble(args[1]));
			System.out.println("The fahrenheit value is " + answer);
		}
	}
	
	public static void printUsage() {
		
	}
	public static double ConvertFahToCel (double input) {
		return ((input-32) * (5.0/9.0));
	}
	
	public static double ConvertCelToFah(double input) {
		return ((input * (9.0/5.0))+32);
	}
}
