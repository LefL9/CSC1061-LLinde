
public class Car {
	// Data Members (always private)
	private final double MILES_PER_GALLON = 20;
	private String color;
	private int milage;
	private double amountOfGas;
	private boolean isClean = true;
	private Radio radio;
	private Wheel[] wheels = new Wheel[4];
	
	
	// Constructor
	public Car() {
		color = "Grey";
		milage = 10;
		amountOfGas = 2.0;
		isClean = true;
	}
	
	public Car(String color, int umilage, double amountOfGas) {
		this.color = color;
		this.milage = umilage;
		isClean = false;
		this.amountOfGas = amountOfGas;
	}
	
	public Car(String color, int umilage, double amountOfGas, boolean wantRadio) {
		this.color = color;
		this.milage = umilage;
		isClean = false;
		this.amountOfGas = amountOfGas;
		if(wantRadio) {
			radio = new Radio(true,false);
		}
	}
	
	// Getters and setters (Accessors and Mutators) put thought into it
	public String getColor() {
		return color;
	}
	
	public void setColor(String color) {
		
		this.color = color;
	}
	
	public Radio getRadio() {
		return radio;
	}
	public Wheel[] getWheels() {
		return wheels;
	}

	public void setWheels(int radius, String material) {
		for (int i = 0; i < wheels.length; i++) {
			wheels[i] = new Wheel (radius, material);
		}
	}
	public void clean() {
		isClean = true;
	}
	
	//Methods

	public void drive(int numMiles) {
		for (int i = 0; i < numMiles; i++) {
			System.out.print("+");
			milage ++;
		}
		System.out.println();
		amountOfGas -= numMiles / MILES_PER_GALLON;
	}
	
	

	
	
	//toString()
	@Override 
	//makes sure method matches one in library
	public String toString() {
		String str = "Car: color: " + color + " milage: " + milage
				+" Gas: " + amountOfGas + " Clean: " + isClean;
		return str;
	}
	
}
