
public class Rectangle extends GeometricObject {
private double width;
private double height;

public Rectangle() {
	super("Black", false);
	width = 1.0;
	height = 1.0;
	// or super.setColor("Black");
}

public Rectangle(String color, boolean isFilled, double width, double height) {
	super(color, isFilled);
	this.width = width;
	this.height = height;
}

public double getWidth() {
	return width;
}

public void setWidth(double width) {
	this.width = width;
}

public double getHeight() {
	return height;
}

public void setHeight(double height) {
	this.height = height;
}
//methods
public double getArea() {
	return height*width;
}
public double getScaledArea(int scaleFactor) {
	return scaleFactor*height*width;
}
public double getPerimeter() {
	return (height*2) + (width*2);
}


@Override
public String toString() {
	return "Rectangle [width=" + width + ", height=" + height  + super.toString() + "]";
}


}
