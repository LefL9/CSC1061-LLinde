import java.util.Date;

public class GeometricObject {
	private String color = "white";
	private boolean isFilled = false;
	private Date dateCreated = new Date();
	
	
	public GeometricObject() {
		//this.dateCreated = new Date();
	}


	public GeometricObject(String color, boolean isFilled) {
		super();
		this.color = color;
		this.isFilled = isFilled;
		//this.dateCreated = new Date();
	}


	public String getColor() {
		return color;
	}


	public void setColor(String color) {
		this.color = color;
	}


	public boolean isFilled() {
		return isFilled;
	}


	public void setFilled(boolean isFilled) {
		this.isFilled = isFilled;
	}


	public Date getDateCreated() {
		return dateCreated;
	}


	@Override
	public String toString() {
		return "color=" + color + ", isFilled=" + isFilled + ", dateCreated=" + dateCreated + "]";
	}
	
	
	
	
}
