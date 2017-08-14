package kata.java.tennis;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

import org.junit.Before;
import org.junit.Test;

public class TennisGameTest {

	private static final String playerA = "Nadal";
	private static final String playerB = "Tsonga";
	private TennisGame game;
	
	@Before
	public void before() {
		game = new TennisGame("first", "second");
	}
	
	// Tennis match between 2 different players (Nadal and Tsonga)
	@Test(expected=IllegalArgumentException.class)
	public void playersShouldBeDifferent() throws Exception {
		game = new TennisGame((String)null, null);
	}
        
	// The game starts with a score of 0 point for each player
	@Test
	public void 
	startingScoreIsZeroZero() {
		assertThat(game.score(), is("0-0"));
	}
	
	// PlayerA Nadal win the game
	@Test
	public void playerAScoreShouldFollow_15_30_40_sequence() throws Exception {
		game.firstPlayerScore();
		assertThat(game.score(), is("15-0"));
		
		game.firstPlayerScore();
		assertThat(game.score(), is("30-0"));
		
		game.firstPlayerScore();
		assertThat(game.score(), is("40-0"));
	}
	
	// PlayerB Tsonga win the game
	@Test
	public void playerBScoreShouldFollow_15_30_40_sequence() throws Exception {
		game.secondPlayerScore();
		assertThat(game.score(), is("0-15"));
		
		game.secondPlayerScore();
		assertThat(game.score(), is("0-30"));
		
		game.secondPlayerScore();
		assertThat(game.score(), is("0-40"));
	}
