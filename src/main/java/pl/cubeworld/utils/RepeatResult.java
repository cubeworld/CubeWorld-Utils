package pl.cubeworld.utils;

public class RepeatResult {

	private final boolean success;
	private final long timeTakenMs;

	public RepeatResult(boolean success, long timeTakenMs) {
		this.success = success;
		this.timeTakenMs = timeTakenMs;
	}

	public boolean isSuccess() {
		return success;
	}

	public long timeTakenMs() {
		return timeTakenMs;
	}
}
