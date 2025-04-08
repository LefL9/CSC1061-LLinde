import java.util.ArrayList;

public abstract class Phone implements Cloneable, Comparable<Phone> {
	private String processor;
	private int cache; // in MB
	private int storage; // in GB
	private ArrayList<Character> imei;

	public Phone(String processor, int cache, int storage, String imeiStr) {
		this.processor = processor;
		this.cache = cache;
		this.storage = storage;
		this.imei = new ArrayList<>();

		// converting string to char arraylist

		for (char c : imeiStr.toCharArray()) {
			this.imei.add(c);
		}
	}

	@Override
	public Object clone() {
		try {
			Phone copy = (Phone) super.clone();
			copy.imei = new ArrayList<>(this.imei);
			return copy;
		} catch (CloneNotSupportedException e) {
			System.out.println("Cloning failed.");
			return null;
		}
	}

	@Override
	public int compareTo(Phone other) {
		if (!this.getClass().equals(other.getClass())) {
			throw new IllegalArgumentException("Can only compare same model phones.");
		}

		if (this.cache != other.cache) {
			return this.cache - other.cache;
		} else {
			return this.storage - other.storage;
		}
	}

	public String getProcessor() {
		return processor;
	}

	public void setProcessor(String processor) {
		this.processor = processor;
	}

	public int getCache() {
		return cache;
	}

	public void setCache(int cache) {
		this.cache = cache;
	}

	public int getStorage() {
		return storage;
	}

	public void setStorage(int storage) {
		this.storage = storage;
	}

	public ArrayList<Character> getImei() {
		return imei;
	}

	public void setImei(ArrayList<Character> imei) {
		this.imei = imei;
	}

	@Override
	public String toString() {
		return "Phone processor: " + processor + "\ncache: " + cache + " MB\nstorage: " + storage + " GB\nIMEI: "
				+ imei;
	}
}
