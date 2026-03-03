package utilities;

public enum WaitType {

	SMALL(5), MEDIUM(10), LARGE(20), EXTRA_LARGE(40);

	private final int time;

	WaitType(int time) {
		this.time = time;
	}

	public int getTime() {
		return time;
	}
}
