
public class Car {
	// Data Members (always private)
	private String color;
	private int milage;
	private double amountOfGas;
	private boolean isClean = true;
	
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
	
	// Getters and setters (Accessors and Mutators) put thought into it
	public String getColor() {
		return color;
	}
	
	public void setColor(String color) {
		
		this.color = color;
		
	}
	
}
