package org.codingkata.unit.api;

import org.codingkata.IKataCommonSolution;

/**
 * interface for the kata's task
 * @author stephanos
 */
public interface IKataSolution
        extends IKataCommonSolution {

     /**
     * New customers arrive at your ticket booth and tell you
     * what movie they'd like to see (so keep it in mind ;-)
     *
     * @param runtime       movie's runtime in minutes
     * @param day           day of the week (enum)
     * @param isParquet     true if seating category is 'parquet' (and not 'loge')
     * @param is3D          true if the movie's shown in 3D
     */
    public abstract void startPurchase(int runtime, Day day, boolean isParquet, boolean is3D);

    /**
     * Add a ticket to the customers' bill
     *
     * @param age           the age of the ticket buyer in years
     * @param isStudent     true if the ticket buyer is a student
     */
    public abstract void addTicket(int age, boolean isStudent);

    /**
     * Calculate the total admission for the current customer(s)
     *
     * @return  total in dollars
     */
    public abstract float finishPurchase();

    /**
     * Custom enum to represent the 7 days of the week
     */
    public enum Day {

        SUN, MON, TUE, WED, THU, FRI, SAT;
    }
}

