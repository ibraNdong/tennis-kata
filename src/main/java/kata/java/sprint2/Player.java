package kata.java.sprint2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Player class
 * @author ibrahima Ndong
 *
 */
public class Player {

        private int[] set;
        private List score;
        protected Boolean isOnAdvantage;
        private String name;
        private int index;
        private int setIndex;


       public Player(String name){
            this.name = name;
            index = 0;
            score = new ArrayList(Arrays.asList(0,15,30,40));
            setIndex = 0;
            set = new int[3];
            isOnAdvantage = Boolean.FALSE;
        }

        /**
         * Method to get the current set level score
         * @return set score
         */
        public String getSetScoreString() {
            StringBuffer setScore = new StringBuffer();
            for(int i = 0; i < 3; i++){
                setScore.append(" " + String.valueOf(set[i]) + " ");
            }
            return setScore.toString();
        }

        /**
         * Method to get the current score
         * @return current score
         */
        public int getCurrentScore(){
            return (int) score.get(index);
        }

        /**
         * Update the current score
         */
        public void updateScore(){
            index++;
        }

        /**
         * Is on 40
         * @return boolean
         */
        public Boolean isOnMatchPoint(){
            return (index + 1 == score.size());
        }

        public void resetScore(){
            index = 0;
        }

        public String getName(){
            return name;
        }

        public void updateSetScore(){
            set[setIndex] += 1;
        }

        /**
         * Get current set point
         * @return set point of the current set
         */
        public int getSetPoint(){
            return set[setIndex];
        }

        /**
         * Is on set point
         * @return boolean
         */
        public Boolean isOnSetPoint(){
            return (set[setIndex] >= 6);
        }

        public void startNextSet(){
            setIndex++;
        }

        public void setAdvantage(Boolean adv){
            this.isOnAdvantage = adv;
        }

        public Boolean isOnAdvantage(){
            return this.isOnAdvantage;
        }


}
