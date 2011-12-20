package org.codingkata.unit.impl;

import java.util.ArrayList;
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

    /* ==== FIELDS ==== */
    private IKataSolution m_solution;
    private String[][] dict = {{"chick", "woman"}, {"dude", "man"},
        {"bite the dust", "die"}, {"puke", "vomit"}, {"stinking rich", "extremely wealthy"},
        {"the heat", "the police"}, {"bum", "homeless person"}, {"crib", "home"},
        {"kewl", "really great"}, {"peep", "people"}, {"head doctor", "psychiatrist"},
        {"phat", "great"}, {"piece", "weapon"}, {"dough", "money"}, {"mate", "friend"},
        {"mint", "wonderful"}, {"mits", "hands"}, {"baked", "intoxicated"}, {"whipped", "stolen"},
        {"scared shitless", "very frightened"}, {"screwed up", "messed up"}, {"dibble", "policeman"},
        {"bad egg", "corrupt person"}, {"ball and chain", "wife"}, {"bluecoats", "officers"},
        {"battered", "very intoxicated"}, {"belly-up", "dead"}, {"bonkers", "insane"},
        {"fuzz", "police"}, {"was batiste", "made matters worse"}, {"cop", "policeman"}, {"bash", "party"},
        {"bling bling", "jewellery"}, {"jock", "athlete"}, {"cut a deal", "make an agreement"},
        {"brolly", "umbrella"}, {"bunning", "smoking marijuana"}, {"missus", "wife"},
        {"voddy", "vodka"}, {"Kraut", "German"}, {"went postal", "filled with rage and fury"}};

    class Sentence {

        String orig;
        String expect;

        public Sentence(String _orig, String _expect) {
            orig = _orig;
            expect = _expect;
        }
    }

    /* ==== PUBLIC ==== */
    public void start() {

        List<Sentence> l = new ArrayList<Sentence>();
        l.add(new Sentence(
                "Last night a $dude$ named D. Gibbons, the Olympic $jock$, was stopped in his car by $the heat$.",
                "Last night a man named D. Gibbons, the Olympic athlete, was stopped in his car by the police."));
        l.add(new Sentence(
                "He was coming from a $bash$ and appeared $battered$ to the $fuzz$.",
                "He was coming from a party and appeared very intoxicated to the police."));
        l.add(new Sentence(
                "On the backseat his $ball and chain$, famous for wearing very expensive $bling bling$, was $bunning$.",
                "On the backseat his wife, famous for wearing very expensive jewellery, was smoking marijuana."));
        l.add(new Sentence(
                "It $was batiste$ when he took the $cop$ for a $bad egg$ and tried to $cut a deal$ for $100.",
                "It made matters worse when he took the policeman for a corrupt person and tried to make an agreement for $100."));
        l.add(new Sentence(
                "He didn't have his driver's licence with him, claiming that his wallet was $whipped$ from him.",
                "He didn't have his driver's licence with him, claiming that his wallet was stolen from him."));
        l.add(new Sentence(
                "As $the heat$ saw a $piece$ on the floor of the car, Gibbons $mits$ were cuffed.",
                "As the police saw a weapon on the floor of the car, Gibbons hands were cuffed."));
        l.add(new Sentence(
                "The $dibble$ was later reported to have said that \"Gibbons was really screwed up - thank god he didn't go postal\".",
                "The policeman was later reported to have said that \"Gibbons was really screwed up - thank god he didn't go postal\"."));
        l.add(new Sentence(
                "Eventually the $bluecoats$ drove him and his $missus$ to their $crib$ - both await $phat$ legal charges.",
                "Eventually the officers drove him and his wife to their home - both await great legal charges."));

        for (Sentence s : l) {
            validate(s.expect, m_solution.translate(s.orig, dict));
        }
    }

    @Override
    public void setSolution(IKataCommonSolution pSolution) {
        m_solution = (IKataSolution) pSolution;
    }
}
