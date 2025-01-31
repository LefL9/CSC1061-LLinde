
public class Horse extends Animal {
private String coat;

public Horse(String gender, int age, double weight, String color, String coat) {
	super(gender, age, weight, color);
	this.coat = coat;
}
public String makeSound(){
	return "Neigh";
}


}
