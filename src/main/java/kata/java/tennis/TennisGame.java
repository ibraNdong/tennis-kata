
package kata.java.tennis;

public class TennisGame {

	private static final int DOUBLE_ADVANTAGE = 60;
	private static final int ADVANTAGE = 50;
	private String playerA;
	private String playerB;
	private Score gameScoringPoints;
	private FirstPlayer firstPlayer;
	private SecondPlayer secondPlayer;

	public TennisGame(String playerA, String playerB) {
		if( playerA == playerB) {
			throw new IllegalArgumentException();
		}
		this.playerA = playerA;
		this.playerB = playerB;
		this.gameScoringPoints = new Score(0,0);
	}
	
	public TennisGame(FirstPlayer firstPlayer, SecondPlayer secondPlayer) {
		this(firstPlayer.name(), secondPlayer.name());
	}

	public void firstPlayerScore() {
		gameScoringPoints = increaseFirstPlayerScore(gameScoringPoints.firstPlayer, gameScoringPoints.secondPlayer);
	}
	
	public void secondPlayerScore() {
		gameScoringPoints = increaseSecondPlayerScore(gameScoringPoints.secondPlayer, gameScoringPoints.firstPlayer);
	}
	
	private Score increaseFirstPlayerScore(int actualWinnerScore, int actualLooserScore) {
		int newWinnerScore = newWinnerScore(actualWinnerScore, actualLooserScore);
		int newLooserScore = newLooserScore(actualWinnerScore, actualLooserScore);
		return new Score(newWinnerScore, newLooserScore);
	}
	
	private Score increaseSecondPlayerScore(int actualWinnerScore, int actualLooserScore) {
		int newWinnerScore = newWinnerScore(actualWinnerScore, actualLooserScore);
		int newLooserScore = newLooserScore(actualWinnerScore, actualLooserScore);
		return new Score(newLooserScore, newWinnerScore);
	}
	
	private int newLooserScore(int scoringPlayerScore, int otherPlayerScore) {
		if(scoringPlayerScore == 40) {
			if (otherPlayerScore == ADVANTAGE) { 
				otherPlayerScore = 40;
			}
		} 
		return otherPlayerScore;
	}

	private int newWinnerScore(int scoringPlayerScore, int otherPlayerScore) {
		int newScore = 0;
		if(scoringPlayerScore == 0) {
			newScore = 15;
		} else
		if(scoringPlayerScore == 15) {
			newScore = 30;
		} else
		if(scoringPlayerScore == 30) {
			newScore = 40;
		} else
		if(scoringPlayerScore == 40) {
			if (otherPlayerScore == ADVANTAGE) { 
				newScore = 40;
			} else {
				newScore = ADVANTAGE;
			}	
		} else
		if(scoringPlayerScore == ADVANTAGE) {
			newScore = DOUBLE_ADVANTAGE;
		}
		return newScore;
	}
	
	public String score() {
		return printScore(gameScoringPoints.firstPlayer)+"-"+printScore(gameScoringPoints.secondPlayer);
	}

	private String printScore(int actualScore) {
		if(actualScore == ADVANTAGE) {
			return "AD";
		}
		if(actualScore == DOUBLE_ADVANTAGE) {
			return "ADAD";
		}
		return actualScore+"";
	}
	
  	public String winner() {
		if(gameScoringPoints.firstPlayer > gameScoringPoints.secondPlayer) {
			return playerA;
		}
		return playerB;
	}

}
  
  
