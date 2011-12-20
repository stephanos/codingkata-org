package org.codingkata.unit.api;

import org.codingkata.IKataCommonSolution;

/**
 * interface for the kata's task
 * @author stephanos
 */
public interface IKataSolution
        extends IKataCommonSolution {

    public enum ACTION {
        TURN_LEFT, TURN_RIGHT, FORWARD, STAY
    }

    public enum ORIENTATION {
        UP (270), DOWN(90), LEFT(0), RIGHT(180);
        public int angle;
        ORIENTATION (int _angle) {
            angle = _angle;
        }
        public ORIENTATION moveLeft () {
            switch (this) {
                case UP: return LEFT;
                case DOWN: return RIGHT;
                case LEFT: return DOWN;
                case RIGHT: return UP;
            }
            return this;
        }
        public ORIENTATION moveRight () {
            switch (this) {
                case UP: return RIGHT;
                case DOWN: return LEFT;
                case LEFT: return UP;
                case RIGHT: return DOWN;
            }
            return this;
        }
    }

    public enum ITEM {
        EMPTY, PLANT, ANIMAL, END
    }

    public abstract class Animal {
        /**
         * Number of plants the animal ate
         */
        public int points;
        /**
         * Method to react to changing environmental conditions
         *
         * @param orientation   animal's current orientation
         * @param view          item currently in front of animal
         * @return              action to do
         */
        public abstract ACTION react (ORIENTATION orientation, ITEM view);
    }

    /**
     * Factory method for an animal
     *
     * @param count             count of animals to create
     * @param lastGeneration    array of 'Animal' from last generation
     * @return                  array of 'Animal' instances
     */
    public abstract Animal[] createGeneration (int count, Animal[] lastGeneration);

   /**
     * If true, last generation will be visualized
     */
    public boolean visualizeLastGeneration ();

    /**
     * Defines how many generations of evolution should be tested
     * (minimum is 100, maximum is 10000)
     *
     * @return  count of generations to test
     */
    public int countOfGenerations ();
}

