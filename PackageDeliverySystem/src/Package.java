import java.util.UUID;

public class Package {
	private Destination destination;
	private double weight;
	private double costPerKg;
	private String status;
	private int trackingNumber;
	public UUID track = UUID.randomUUID();
	
	public Package(Destination destination, double weight, double costPerKg, String status) 
	{
		this.destination = destination;
		this.weight = weight;
		this.costPerKg = costPerKg;
		this.status = status;
	}
	public getStatus() {
		
	}
	
	public generateTrackingNum()
}
