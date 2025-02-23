
public class TestFan {

	public static void main(String[] args) {
		Fan fan1 = new Fan(Fan.FAST, true, 10.0, "yellow");
		Fan fan2 = new Fan(Fan.MEDIUM, false, 5.0, "blue");
		System.out.println(fan1.toString());
		System.out.println(fan2.toString());
	}

}
