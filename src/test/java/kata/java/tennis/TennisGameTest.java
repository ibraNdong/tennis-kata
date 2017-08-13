package kata.java.tennis;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

import org.junit.Before;
import org.junit.Test;

public class TennisGameTest {
	private Player italia;
	private Player espania;
	private Game game;
	
	@Before
	public void setUp(){
		italia = new Player();
		espania = new Player();
		game = new Game(italia, espania);
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
	
	
}
