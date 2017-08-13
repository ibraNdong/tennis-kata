package kata.java.tennis;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

import org.junit.Before;
import org.junit.Test;

public class TennisGameTest {
	private Player italia;
	private Player espania;
	private TennisGame game;
	
	@Before
	public void setUp(){
		italia = new Player();
		espania = new Player();
		game = new TennisGame(italia, espania);
	}
	


	@Test
	public void italiaWinsTheGame_40_15() {
		italia.score();
		italia.score();
		italia.score();
		
		espania.score();
		
		
		italia.score();
		
		assertThat(game.winner(), is(italia));
	}
	
	@Test
	public void espaniaWins_15_40() throws Exception {
		italia.score();
		
		espania.score();
		espania.score();
		espania.score();
		
		
		espania.score();
		
		assertThat(game.winner(), is(espania));
	}
	
	@Test
	public void gameDeuce() throws Exception {
		italia.score();
		italia.score();
		italia.score();
		
		espania.score();
		espania.score();
		espania.score();
		
		
		assertThat(game.deuce(), is(true));
	}
	
	@Test
	public void italiaPlayerScoreAdvantageFromDeuce() throws Exception {
		game = new TennisGame(italia, espania);
		italia.scoreToFourty();
		espania.scoreToFourty();
		game.scoreFirstPlayer();
		
		assertThat(game.whoIsAdvantage(), is(italia));
		assertThat(espania.isFourty(), is(true));
		
	}
	
	@Test
	public void backToDeuce() throws Exception {
		game = new TennisGame(italia, espania);
		italia.scoreToFourty();
		espania.scoreToFourty();
		game.scoreFirstPlayer();
		game.scoreSecondPlayer();
		assertThat(game.deuce(), is(true));
		
	}
}
