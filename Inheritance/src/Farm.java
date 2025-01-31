
public class Farm {

	public static void main(String[] args) {
		Cat johnston = new Cat ("boy", 3, 14, "black", 2);
		System.out.println(johnston.makeSound());
		System.out.println(johnston);
		
		Animal[] animals = new Animal[3];
		animals[0] = johnston;
		
		
	}

}
