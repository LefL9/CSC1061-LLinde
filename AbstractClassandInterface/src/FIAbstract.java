
public abstract class FIAbstract implements Comparable<FIAbstract>, Cloneable {
 private String FIName;
 private long fiID;
 private long routingNumber;
 private Address address;
 
 
public FIAbstract(String fIName, long fiID, long routingNumber, Address address) {
	super();
	FIName = fIName;
	this.fiID = fiID;
	this.routingNumber = routingNumber;
	this.address = address;
}


public String getFIName() {
	return FIName;
}
public void setFIName(String fIName) {
	FIName = fIName;
}
public long getFiID() {
	return fiID;
}
public void setFiID(long fiID) {
	this.fiID = fiID;
}
public long getRoutingNumber() {
	return routingNumber;
}
public void setRoutingNumber(long routingNumber) {
	this.routingNumber = routingNumber;
}
public Address getAddress() {
	return address;
}
public void setAddress(Address address) {
	this.address = address;
}
 
public abstract double getInterestRate();

@Override
public int compareTo(FIAbstract fi) {
	if (fiID < fi.fiID) {
		return -1;
	}
	if (fiID > fi.fiID) {
		return +1;
	}
	return 0;
}

@Override
public FIAbstract clone() throws CloneNotSupportedException {
	FIAbstract clone = (FIAbstract) super.clone();
	clone.address = address.clone();
	return clone;
}

@Override
public String toString() {
	return "FIAbstract [FIName=" + FIName + ", fiID=" + fiID + ", routingNumber=" + routingNumber + ", address="
			+ address + "]";
}

}
