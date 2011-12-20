package org.codingkata.unit.impl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import org.codingkata.IKataCommonSolution;
import org.codingkata.KataCommonTask;
import org.codingkata.unit.api.IKataSolution;
import org.codingkata.unit.api.IKataSolution.Day;
import org.codingkata.unit.api.IKataTask;

/**
 * the kata task
 * @author stephanos
 */
public class KataTask
        extends KataCommonTask
        implements IKataTask {

    private IKataSolution m_solution;

    class Person {
        int age;
        boolean isStudent;

        Person (int _age, boolean _isStudent) {
            age = _age;
            isStudent = _isStudent;
        }
    }

    class Show {
        String name;
        boolean is3D;
        int runtime;
        boolean isParquet;
        Day day;
        float totalAdmission;
        List<Person> persons = new ArrayList<Person> ();
    }

    public void start() {

        List<Show> shows = new ArrayList<Show> (4);

        // SHOW 1
        Show s1 = new Show ();
        s1.name = "Family of Four";
        s1.day = Day.SAT;
        s1.runtime = 89;
        s1.isParquet = false;
        s1.is3D = false;
        s1.persons.add(new Person (45, false));
        s1.persons.add(new Person (46, false));
        float c1 = 11f + 2f + 1.5f;
        /* 11 (basic) + 2 (loge) + 1.50 (WE) */
        s1.persons.add(new Person (12, false));
        float c2 = 5.5f + 2f + 1.5f;
        /* 5.50 (basic) + 2 (loge) + 1.50 (WE) */
        s1.persons.add(new Person (21, true));
        float c3 = 8f + 2f + 1.5f;
        /* 8 (basic) + 2 (loge) + 1.50 (WE) */
        s1.totalAdmission = 2*c1+c2+c3;
        shows.add(s1);

        // SHOW 2
        Show s2 = new Show ();
        s2.name = "Couple";
        s2.day = Day.THU;
        s2.runtime = 124;
        s2.isParquet = true;
        s2.is3D = false;
        s2.persons.add(new Person (23, false));
        c1 = 11f - 2f + 1.5f;
        /* 11 (basic) - 2 (THU) + 1.5 (over) */
        s2.persons.add(new Person (25, true));
        c2 = 8f - 2f + 1.5f;
        /* 8 (basic) - 2 (THU) + 1.5 (over) */
        s2.totalAdmission = c1+c2;
        shows.add(s2);

        // SHOW 3
        Show s3 = new Show ();
        s3.name = "Senior with Grandson";
        s3.day = Day.FRI;
        s3.runtime = 95;
        s3.isParquet = true;
        s3.is3D = true;
        s3.persons.add(new Person (65, false));
        c1 = 6f + 3f;
        /* 6 (basic) + 3 (3D) */
        s3.persons.add(new Person (6, false));
        c2 = 5.5f + 3f;
        /* 5.5 (basic) + 3 (3D) */
        s3.totalAdmission = c1+c2;
        shows.add(s3);

        // SHOW 4
        Show s4 = new Show ();
        s4.name = "Group of Kids";
        s4.day = Day.SUN;
        s4.runtime = 91;
        s4.isParquet = true;
        s4.is3D = true;
        s4.persons.add(new Person (10, false));
        s4.persons.add(new Person (12, false));
        s4.persons.add(new Person (12, false));
        s4.persons.add(new Person (11, false));
        s4.persons.add(new Person (12, false));
        c1 = 5.5f + 3f + 1.5f;
        /* (for all) = 5.5 (basic) + 3 (3D) + 1.5 (WE) */
        s4.totalAdmission = 5*c1;
        shows.add(s4);

        // SHOW 5
        Show s5 = new Show ();
        s5.name = "Student Course";
        s5.day = Day.THU;
        s5.runtime = 120;
        s5.isParquet = true;
        s5.is3D = false;
        for (int i = 0; i < 22; i++) {
            s5.persons.add(new Person (21+new Random ().nextInt(3), true));
        }
        s5.persons.add(new Person (55, false));
        c1 = 6f; /* 6 (basic) */
        s5.totalAdmission = s5.persons.size() * c1;
        shows.add(s5);

        Collections.shuffle(shows);

        // TESTS
        for (Show s : shows) {

            System.out.println(" ~~ Arriving at your booth: '" + s.name + "' ~~");

            // start ticket purchase
            m_solution.startPurchase(s.runtime, s.day, s.isParquet, s.is3D);

            System.out.println("Today (" + s.day + ")" +
                               " they want to see a " + s.runtime + " min. long" +
                               (s.is3D ? " 3D" : "") +
                               " movie" +
                               (s.isParquet ? " from the parquet." : " from the loge."));

            // add each ticket
            Collections.shuffle(s.persons);
            for (Person p : s.persons) {
                m_solution.addTicket(p.age, p.isStudent);
                System.out.println(" -> " + p.age + " years old " +
                                   (!p.isStudent ? "person" : "student" ) + " buys a ticket");
            }

            // finish purchase
            validate(s.totalAdmission, m_solution.finishPurchase(), s.name);
            System.out.print("\n");
        }
    }

    @Override
    protected String customSuccessMsg() {
        return "And the popcorn girl looks at you adoringly...";
    }

    @Override
    public void setSolution(IKataCommonSolution pSolution) {
        m_solution = (IKataSolution) pSolution;
    }
}
