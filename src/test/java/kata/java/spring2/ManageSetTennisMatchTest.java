package kata.java.sprint2;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import java.util.Scanner;
import static org.junit.Assert.*;

public class ManageSetTennisMatchTest {


    @Test
    public static void main(String[] args) {
        
        Scanner reader = new Scanner(System.in);
        System.out.println("Entrer le nom du premier joueur.");
        String playerName1 = reader.next().trim();
        System.out.println("Entrer le nom du second joueur.");
        String playerName2 = reader.next().trim();
        
        ManageSetTennisMatch scorer = new ManageSetTennisMatch(playerName1, playerName2);

        while(! scorer.gameOver){ //run until game is over
            scorer.match();
            scorer.deriveWinner();
        }

    }

}
