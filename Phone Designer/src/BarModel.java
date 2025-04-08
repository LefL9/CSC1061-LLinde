
public class BarModel extends Phone implements Repairable{

	public BarModel(String imeiStr) {
        super("DragonSlayer 600", 8, 32, imeiStr);
    }

	@Override
	public String howToRepair() {
		return "Unscrew to take apart";
	}

	@Override
	public double costToRepair() {
		return 40.0;
	}

}
