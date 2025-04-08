
public class FlipModel extends Phone implements Repairable {

	public FlipModel(String imeiStr) {
		super("HorseRacer 300", 3, 16, imeiStr);
	}

	@Override
	public String howToRepair() {
		return "Fix the hinge";
	}

	@Override
	public double costToRepair() {
		return 60.0;
	}
}
