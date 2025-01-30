
public class CarDriver {

	public static void main(String[] args) {
		
		Car myCar = new Car(); 
		System.out.println(myCar.toString());
		Car ocar = new Car("Pink", 50, 100.0,true);
		
		ocar.setWheels(15, "Alloy");
		int currVol = 0;
		Radio rad = ocar.getRadio();
		currVol = rad.setVolume(4);
		
		System.out.println(ocar.getColor());
		
		myCar.drive(5);
		
		myCar.clean();
		System.out.println(ocar);
		
		
		
		Carwash cwash = new Carwash();
		cwash.cleanCar(ocar);
		System.out.println(ocar);
	}

}
