
public class Cat extends Animal {
private int whiskerSize;


public Cat(String gender, int age, double weight, String color, int whiskerSize) {
	super(gender, age, weight, color);
	this.whiskerSize = whiskerSize;
}


@Override
public String toString() {
	return "Cat [whiskerSize=" + whiskerSize + ", toString()=" + super.toString() + "]";
}

public String makeSound(){
	return "Meow";
}





}
