package kata.java.sprint2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;


/**
 * Tennis Score Manager
 * @author Ibrahima Ndong
 *
 */
public class ManageSetTennisMatch {

        protected Player player1,player2;
        protected Boolean gameOver;
        private String playerName;
        private int set;
        private int lastSetWinner;

        ManageSetTennisMatch(String playerName1, String playerName2){
            player1 = new Player(playerName1);
            player2 = new Player(playerName2);
            gameOver = Boolean.FALSE;
            set = 0;
        }

        /**
         * Method to play the bout
         */
        public void match(){
            while(true){

                //Get the winner of the bout
                playerName = getWinner();

                //If player 1 wins the bout
                if(player1.getName().equalsIgnoreCase(playerName)){
                    if(player1.isOnMatchPoint()){
                        System.out.println(player1.getName() + " a gangé le match");
                        player1.updateSetScore();
                        displayScore();
                        break;
                    }
                    else{
                        player1.updateScore();
                        displayScore();
                        if(player1.isOnMatchPoint() && player2.isOnMatchPoint()){
                            tieBreaker(); //Starting tie breaker
                            break;
                        }
                    }
                }
                else if(player2.getName().equalsIgnoreCase(playerName)){ //If player 2 wins the bout
                    if(player2.isOnMatchPoint()){
                        System.out.println(player1.getName() + " a gagné le match");
                        player2.updateSetScore();
                        displayScore();
                        break;
                    }
                    else{
                        player2.updateScore();
                        displayScore();
                        if(player1.isOnMatchPoint() && player2.isOnMatchPoint()){
                            tieBreaker(); //Starting tie breaker
                            break;
                        }
                    }
                }
                else{
                    System.out.println("Nom incorrect. saisissez encore s'il vous plait.......");
                }
            }

            //Reset the score card for next bout
            player1.resetScore();
            player2.resetScore();
        }

        public void deriveWinner(){

            if(player1.isOnSetPoint() || player2.isOnSetPoint()){ //winner is calculated if any of the player is on set point i.e., 6
                if(player1.getSetPoint() - player2.getSetPoint() >= 2){ // we get a winner when a diff of 2 or more is there between set points of the players
                    System.out.println(player1.getName() + " est le vainqueur du set " + (set + 1));
                    if((set == 1 && lastSetWinner == 1) || set == 2){
                        System.out.println(player1.getName() + " est l'ultimate vainqueur ");
                        gameOver = Boolean.TRUE;
                        return;
                    }
                    lastSetWinner = 1;
                    //Starting the next set
                    set++;
                    player1.startNextSet();
                    player2.startNextSet();
                }
                else if(player2.getSetPoint() - player1.getSetPoint() >= 2){ // we get a winner when a diff of 2 or more is there between set points of the players
                    System.out.println(player2.getName() + " est le vainqueur du set " + (set + 1));
                    if((set == 1 && lastSetWinner == 2) || set == 2){
                        System.out.println(player2.getName() + " est l'ultimate vainqueur ");
                        gameOver = Boolean.TRUE;
                        return;
                    }
                    lastSetWinner = 2;
                    //Starting the next set
                    set++;
                    player1.startNextSet();
                    player2.startNextSet();
                }
            }
        }

    /**
     * Method to display the current score board
     */
    private void displayScore(){
        System.out.println("Score : ");
        System.out.println(player1.getName() + " : " + player1.getCurrentScore());
        System.out.println(player2.getName() + " : " + player2.getCurrentScore());

        System.out.println("Set : ");
        System.out.println(player1.getName() + " : " + player1.getSetScoreString());
        System.out.println(player2.getName() + " : " + player2.getSetScoreString());
    }

    /**
     * Method to input the current bout winner
     * @return name of the winner per bout
     */
    private String getWinner(){
        Scanner reader = new Scanner(System.in);
        System.out.println("Entrer le nom du joueur qui a gagné le point.");
        return reader.next().trim();
    }

    /**
     * Method to play the tie breaker
     */
    private void tieBreaker(){
        System.out.println("Deuce...");

        while(true){
            //Get the winner of the bout
            playerName = getWinner();

            //If player 1 wins the bout
            if(player1.getName().equalsIgnoreCase(playerName)){
                if(player1.isOnAdvantage){
                    player1.setAdvantage(Boolean.FALSE);
                    if(! player2.isOnAdvantage){
                        System.out.println(player1.getName() + " a gagné le match ");
                        player1.updateSetScore();
                        displayScore();
                        break;
                    }
                }
                else{
                    if( ! player2.isOnAdvantage){ //player 1 has the advantage
                        player1.setAdvantage(Boolean.TRUE);
                        System.out.println("Advantage ..." + player1.getName());
                    }
                    else{ //Both players are returned to deuce
                        player1.setAdvantage(Boolean.FALSE);
                        player2.setAdvantage(Boolean.FALSE);
                        System.out.println("Deuce...");
                    }
                }
            }
            else if(player2.getName().equalsIgnoreCase(playerName)){ //If player 2 wins the bout
                if(player2.isOnAdvantage){
                    player2.setAdvantage(Boolean.FALSE);
                    if(! player1.isOnAdvantage){
                        System.out.println(player2.getName() + " a gagné le match");
                        player2.updateSetScore();
                        displayScore();
                        break;
                    }
                    else{
                        player1.setAdvantage(Boolean.FALSE);
                        System.out.println("Deuce...");
                    }
                }
                else{
                    if( ! player1.isOnAdvantage){ //player 2 has the advantage
                        player2.setAdvantage(Boolean.TRUE);
                        System.out.println("Advantage ..." + player2.getName());
                    }
                    else{ //Both players are returned to deuce
                        player2.setAdvantage(Boolean.FALSE);
                        player1.setAdvantage(Boolean.FALSE);
                        System.out.println("Deuce...");
                    }
                }
            }
            else{
                System.out.println("Nom incorrect. saisissez encore s'il vous plait.......");
            }
        }
    }

}


