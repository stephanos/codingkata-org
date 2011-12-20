package org.codingkata.unit.impl;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
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

    class Person {

        String name;
        boolean woman, sir;

        Person(String _name, boolean _woman, boolean _sir) {
            name = _name;
            woman = _woman;
            sir = _sir;
        }
    }

    public void start() {

        Person[] persons = {
            new Person("Shakespeare", false, false),
            new Person("Guinness", false, true),
            new Person("Ustinov", false, true),
            new Person("Austen", true, false),
            new Person("Newton", false, true),
            new Person("Orwell", false, false),
            new Person("Andrews", true, false),
            new Person("Orwell", false, false)};
        List<Person> pList = Arrays.asList(persons);
        Collections.shuffle(pList);

        for (Person p : pList) {
            validate(calcExpectation(p.name, p.woman, p.sir),
                    m_solution.welcome(p.name, p.woman, p.sir));
        }
    }

    protected String calcExpectation(String name, boolean isWoman, boolean isSir) {

        String ret = new String("Hello ");
        if (isWoman) {
            ret += "Ms. ";
        } else if (isSir) {
            ret += "Sir ";
        } else {
            ret += "Mr. ";
        }
        ret += name;
        return ret;
    }

    @Override
    protected String customSuccessMsg() {
        return "Your British guests are very amused.";
    }

    @Override
    public void setSolution(IKataCommonSolution pSolution) {
        m_solution = (IKataSolution) pSolution;
    }
}
