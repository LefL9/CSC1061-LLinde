
public class Address implements Cloneable{
	 private String line1;
	 private String line2;
	 private String city;
	 private String state;
	 private long zip;
	 
	public Address() {
		super();
	}
	public String getLine1() {
		return line1;
	}
	public void setLine1(String line1) {
		this.line1 = line1;
	}
	public String getLine2() {
		return line2;
	}
	public void setLine2(String line2) {
		this.line2 = line2;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public long getZip() {
		return zip;
	}
	public void setZip(long zip) {
		this.zip = zip;
	}
	public Address(String line1, String line2, String city, String state, long zip) {
		super();
		this.line1 = line1;
		this.line2 = line2;
		this.city = city;
		this.state = state;
		this.zip = zip;
	}
	
	
	
	@Override
	public String toString() {
		return "Address [line1=" + line1 + ", line2=" + line2 + ", city=" + city + ", state=" + state + ", zip=" + zip
				+ "]";
	}
	
	@Override
	public Address clone() throws CloneNotSupportedException{
		Address clone = (Address) super.clone();
		return clone;
	}
	 
}
