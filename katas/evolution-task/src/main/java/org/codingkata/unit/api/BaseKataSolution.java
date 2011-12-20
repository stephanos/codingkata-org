package org.codingkata.unit.api;

/**
 * base class for the user's solution
 * @author stephanos
 */
public abstract class BaseKataSolution implements IKataSolution {

    public boolean visualizeLastGeneration () {
        return false;
    }

    public int countOfGenerations () {
        return 100;
    }
}
