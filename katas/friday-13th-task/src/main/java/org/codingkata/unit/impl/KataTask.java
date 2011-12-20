package org.codingkata.unit.impl;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.GregorianCalendar;
import org.codingkata.IKataCommonSolution;
import org.codingkata.KataCommonTask;
import org.codingkata.unit.api.IKataSolution;
import org.codingkata.unit.api.IKataTask;

/**
 * the kata task
 * @author stephanos
 */
public class KataTask
        extends KataCommonTask
        implements IKataTask {

    private IKataSolution m_solution;

    public void start() {

        Date d;

        d = newDate(1989, GregorianCalendar.NOVEMBER, 9);
        validate(f(newDate(1989, GregorianCalendar.OCTOBER, 13)), f(m_solution.adjacentFriday13th(d)), f(d));

        d = newDate(1789, GregorianCalendar.JULY, 14);
        validate(f(newDate(1789, GregorianCalendar.MARCH, 13)), f(m_solution.adjacentFriday13th(d)), f(d));

        d = newDate(1969, GregorianCalendar.JULY, 20);
        validate(f(newDate(1969, GregorianCalendar.JUNE, 13)), f(m_solution.adjacentFriday13th(d)), f(d));

        d = newDate(1776, GregorianCalendar.JULY, 4);
        validate(f(newDate(1775, GregorianCalendar.OCTOBER, 13)), f(m_solution.adjacentFriday13th(d)), f(d));

        d = newDate(1804, GregorianCalendar.DECEMBER, 2);
        validate(f(newDate(1804, GregorianCalendar.JULY, 13)), f(m_solution.adjacentFriday13th(d)), f(d));

        d = newDate(1889, GregorianCalendar.OCTOBER, 31);
        validate(f(newDate(1889, GregorianCalendar.SEPTEMBER, 13)), f(m_solution.adjacentFriday13th(d)), f(d));

        d = newDate(1492, GregorianCalendar.OCTOBER, 12);
        validate(f(newDate(1492, GregorianCalendar.JULY, 13)), f(m_solution.adjacentFriday13th(d)), f(d));
    }

    private Date newDate (int year, int month, int day) {
        return new Date(year-1900, month, day);
    }

    private String f (Date d) {
        SimpleDateFormat formatter = new SimpleDateFormat("EEE, dd-MMM-yyyy");
        return formatter.format(d);
    }

    @Override
    public void setSolution(IKataCommonSolution pSolution) {
        m_solution = (IKataSolution) pSolution;
    }
}
