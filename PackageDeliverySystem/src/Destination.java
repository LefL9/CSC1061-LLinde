
public class Destination {
private String address;
private String city;
private String state;
public Destination(String address, String city, String state) {
	this.address = address;
	this.city = city;
	this.state = state;
}
public String getAddress() {
	return address;
}
public String getCity() {
	return city;
}
public String getState() {
	return state;
}
@Override
public String toString() {
	return "Destination [address=" + address + ", city=" + city + ", state=" + state + "]";
}

}
