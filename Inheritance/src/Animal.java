//abstract class: can't ever create new animal
public abstract class Animal {
private String gender;
private int age;
private double weight;
private String color;

public Animal(String gender, int age, double weight, String color) {
	super();
	this.gender = gender;
	this.age = age;
	this.weight = weight;
	this.color = color;
}

@Override
public String toString() {
	return "Animal [gender=" + gender + ", age=" + age + ", weight=" + weight + ", color=" + color + "]";
}
//abstract method doesn't even have a body, forces other animals to all have their own 
//make sound methods

public abstract String makeSound();

}
