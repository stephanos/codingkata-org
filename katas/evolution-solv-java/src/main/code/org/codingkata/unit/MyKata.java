package org.codingkata.unit;

import java.util.Random;
import org.codingkata.unit.api.BaseKataSolution;

public class MyKata extends BaseKataSolution {

    /**
     * Sample solution
     *
     * This solution is one of the simplest possible. The animals
     * are merely controlled via random numbers. Can you do better? :-)
     */
    
    @Override
    public Animal[] createGeneration(int size, Animal[] lastGeneration) {

        // create the new animal generation
        Animal[] generation = new MyAnimal[size];
        for (int i = 0; i < size; i++) {
            generation[i] = new MyAnimal();
        }

        return generation;
    }

    class MyAnimal extends Animal {

        @Override
        public ACTION react(ORIENTATION orientation, ITEM view) {
            // using Random() to find next action
            return (ACTION.values())[new Random().nextInt(ACTION.values().length)];
        }
    }

    @Override
    public boolean visualizeLastGeneration() {
        return false;
    }

}
