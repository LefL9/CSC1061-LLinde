
public class Circle extends GeometricObject {
	private double radius = 1.0;
	
	public Circle() {
		
	}

	public Circle(String color, boolean isFilled, double radius) {
		super(color, isFilled);
		this.radius = radius;
	}

	
	public double getRadius() {
		return radius;
	}

	public void setRadius(double radius) {
		this.radius = radius;
	}
	public double getArea() {
		return Math.PI * radius * radius;
	}
	//downcast object o as circle to check radius BUT first check if it is circle
	@Override
	public boolean equals(Object o) {
		if(o instanceof Circle) {
		if (this.radius ==((Circle) o).radius) {
			return true;
		}
	}
		return false;
	}
	
	@Override
	public String toString() {
		return "Circle [radius=" + radius + super.toString() + "]";
	}
	
}
