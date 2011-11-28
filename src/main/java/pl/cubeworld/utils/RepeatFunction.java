package pl.cubeworld.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class RepeatFunction {
	private static final Logger logger = LoggerFactory.getLogger(RepeatFunction.class);
	
	private final long timeoutMs;

	public RepeatFunction(long timeoutMs) {
		this.timeoutMs = timeoutMs;
	}

	public RepeatResult function(Repeatable func) {
		logger.info("Test");
		
		boolean result = false;
		long currentTimeMs = System.currentTimeMillis();
		long endTimeMs = currentTimeMs + timeoutMs;
		do{
			try {
				result = func.call();
			} catch (Exception e) {
				logger.warn("Repeteable function thrwos exception", e);
			}
		} while(!(result || System.currentTimeMillis() > endTimeMs) );
		long timeTakenMs = System.currentTimeMillis() - currentTimeMs;
		return new RepeatResult(result, timeTakenMs);
	}

}
