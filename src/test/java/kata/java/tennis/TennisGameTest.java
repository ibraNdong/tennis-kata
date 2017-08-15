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
	public void startingScoreIsZeroZero() {
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
	
	// If the 2 players reach the score 40, the DEUCE rule is activated
	// If the score is DEUCE , the player who  win the point take the ADVANTAGE
	@Test
	public void theScorerShouldGoToAdvantageIfBothAt_40_() throws Exception {
		gameStartsFromDeuce();
		
		game.firstPlayerScore();
		assertThat(game.score(), is("AD-40"));
		
		gameStartsFromDeuce();
		game.secondPlayerScore();
		assertThat(game.score(), is("40-AD"));
		
	}
	
	// If the player who has the ADVANTAGE win the  point, he win the game
	@Test
	public void playerWinsWhenDoubleAdvantage() throws Exception {
		gameStartsFromDeuce();
		game.firstPlayerScore();
		game.firstPlayerScore();
		
		assertThat(game.score(), is("ADAD-40"));
		assertThat(game.winner(), is(playerA));
		
		gameStartsFromDeuce();
		game.secondPlayerScore();
		game.secondPlayerScore();
		
		assertThat(game.score(), is("40-ADAD"));
		assertThat(game.winner(), is(playerB));
	}
	
	// If the player who has the ADVANTAGE loose the point, the score is DEUCE
	@Test
	public void shouldGoBackToDeuce() throws Exception {
		gameStartsFromDeuce();
		game.firstPlayerScore();
		assertThat(game.score(), is("AD-40"));
		
		game.secondPlayerScore();
		assertThat(game.score(), is("40-40"));
	}
	
	// the 2 players reach the score 40, the DEUCE rule is activated
	private void gameStartsFromDeuce() {
		game = new TennisGame(playerA, playerB);
		game.firstPlayerScore();
		game.firstPlayerScore();
		game.firstPlayerScore();
		
		game.secondPlayerScore();
		game.secondPlayerScore();
		game.secondPlayerScore();
		
		assertThat(game.score(), is("40-40"));
	}
}
