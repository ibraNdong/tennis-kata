
package kata.java.tennis;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

import org.junit.Before;
import org.junit.Test;

public class TennisPlayerTest {

	public TennisPlayer italia;

	@Before
	public void setUp() {
		italia = new TennisPlayer();
	}

	@Test
	public void aPlayerStartsWithZeroScore() {
		assertThat(italia.isZero(), is(true));
	}
  
  
}
