package org.codingkata.unit.impl;

import java.util.ArrayList;
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

    private List<String> m_ret;

    public void start() {

        String[] cds = {
            "Sgt. Pepper", "Pet Sounds", "Revolver", "Highway 61 Revisited",
            "Rubber Soul", "What's Going On", "Exile on Main Street",
            "London Calling", "Blonde on Blonde", "The White Album",
            "The Sun Sessions", "Kind of Blue", "Velvet Underground and Nico",
            "Abbey Road", "Are You Experienced?", "Blood on the Tracks",
            "Nevermind", "Born to Run", "Astral Weeks", "Thriller"
        };
        List<String> lrand = Arrays.asList(cds);
        Collections.shuffle(lrand);

        m_ret = m_solution.sort(lrand);

        List<String> lsort = new ArrayList<String> ();
        for (String s : lrand) {
            lsort.add(s);
        }
        Collections.sort(lsort);

        for (String s : lsort) {
            validate(lsort.indexOf(s), m_ret.indexOf(s), s);
        }
    }

    @Override
    public String customIntroMsg () {
        String res = "Your Result: {";
        for (String s : m_ret) {
            res += "'" + s + "'" + " ";
        }
        res = res.trim() + "}";
        return res;
    }

    @Override
    public void setSolution(IKataCommonSolution pSolution) {
        m_solution = (IKataSolution) pSolution;
    }
}
