package org.codingkata.unit.impl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.codingkata.IKataCommonSolution;
import org.codingkata.KataCommonTask;
import org.codingkata.unit.api.IKataSolution;
import org.codingkata.unit.api.IKataSolution.Movie;
import org.codingkata.unit.api.IKataTask;

/**
 * the kata task
 * @author stephanos
 */
public class KataTask
        extends KataCommonTask
        implements IKataTask {

    private IKataSolution m_solution;

    class MovieRequestTest {
        public Movie movie;
        public String request;
        MovieRequestTest (Movie _movie, String _request) {
            movie = _movie;
            request = _request;
        }
    }

    public void start() {

        List<MovieRequestTest> tests = new ArrayList<MovieRequestTest>();
        tests.add(new MovieRequestTest(Movie.Lost_in_Space, "Lost 'n Space"));
        tests.add(new MovieRequestTest(Movie.Space_Cowboys, "Cowboys in Space"));
        tests.add(new MovieRequestTest(Movie.Killer_Klowns, "Klowns from Outer Space"));
        tests.add(new MovieRequestTest(Movie.Space_Jam, "Traffic Jam"));
        tests.add(new MovieRequestTest(Movie.Space_Balls, "Space Baseball"));
        tests.add(new MovieRequestTest(Movie.Zathura, "Adventure in Space"));
        tests.add(new MovieRequestTest(Movie.Muppets, "Puppets from Outer Space"));
        tests.add(new MovieRequestTest(Movie.Office_Space, "Space Office"));
        tests.add(new MovieRequestTest(Movie.Space_Odyssey, "Space Odysseus"));
        Collections.shuffle(tests);

        for (MovieRequestTest t : tests) {
            validate(t.movie.toString(), m_solution.request(t.request).toString(),
                     t.request);
        }
    }

    @Override
    public void setSolution(IKataCommonSolution pSolution) {
        m_solution = (IKataSolution) pSolution;
    }
}
