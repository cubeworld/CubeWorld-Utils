package pl.cubeworld.utils;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

import java.util.concurrent.TimeUnit;

import static org.hamcrest.Matchers.*;
import org.junit.Test;


public class RepeatTest {
	
	@Test
	public void shouldFinishBeforeTimeout() {
		//given
		long timeoutMs = 500L;
		Repeatable func = new Repeatable() {
			
			public Boolean call() throws Exception {
				return true;
			}
		};
		
		//when
		RepeatResult result = Repeat.repeat(timeoutMs,TimeUnit.MILLISECONDS).function(func);
		
		//then
		assertThat(result.isSuccess(), is(true));
		assertThat(result.timeTakenMs(), is(lessThan(timeoutMs)));
	}

	@Test
	public void shouldFinishWithFalseResultlAfter500Ms() {
		//given
		long timeoutMs = 500L;
		Repeatable func = new Repeatable() {
			
			public Boolean call() throws Exception {
				return false;
			}
		};
		
		//when
		RepeatResult result = Repeat.repeat(timeoutMs,TimeUnit.MILLISECONDS).function(func);
		
		//then
		assertThat(result.isSuccess(), is(false));
		assertThat(result.timeTakenMs(), is(greaterThan(timeoutMs)));
	}

}
