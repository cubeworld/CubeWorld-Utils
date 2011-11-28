package pl.cubeworld.utils;

import java.util.concurrent.TimeUnit;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Repeat {
	private static final Logger logger = LoggerFactory.getLogger(Repeat.class);

	public static RepeatFunction repeat(long timeout, TimeUnit timeUnit) {
		return new RepeatFunction(timeUnit.toMillis(timeout));
	}

}
