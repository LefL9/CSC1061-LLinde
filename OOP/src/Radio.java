
public class Radio {

	//Data Members
	private final int MAX_VOLUME = 10;
	private boolean hasAppleCarPlay;
	private boolean hasAndroidAuto;
	private int volume = 0;
	
	// Constructors
	public Radio(boolean hasCarPlay, boolean hasAndroidAuto) {
		hasAppleCarPlay = hasCarPlay;
		this.hasAndroidAuto = hasAndroidAuto;
		
		
	}


	public boolean isHasAppleCarPlay() {
		return hasAppleCarPlay;
	}

	public void setHasAppleCarPlay(boolean hasAppleCarPlay) {
		this.hasAppleCarPlay = hasAppleCarPlay;
	}

	public boolean isHasAndroidAuto() {
		return hasAndroidAuto;
	}

	public void setHasAndroidAuto(boolean hasAndroidAuto) {
		this.hasAndroidAuto = hasAndroidAuto;
	}

	public int getVolume() {
		return volume;
	}

	public int setVolume(int volume) {
		if(volume > MAX_VOLUME) {
			this.volume = MAX_VOLUME;
		}
		else {
			this.volume = volume;
		}
		return this.volume;
	}
	
	@Override
	public String toString() {
		return "Radio [hasAppleCarPlay=" + hasAppleCarPlay + ", hasAndroidAuto=" + hasAndroidAuto + ", volume=" + volume
				+ "]";
	}
}
