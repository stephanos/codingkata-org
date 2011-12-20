package org.codingkata.unit.api;

import org.codingkata.IKataCommonSolution;

/**
 * interface for the kata's task
 * @author stephanos
 */
public interface IKataSolution
        extends IKataCommonSolution {

    public enum Movie {

        Lost_in_Space("Lost in Space"),
        Space_Balls("Space Balls"),
        Space_Jam("Space Jam"),
        Muppets("Muppets from Space"),
        Zathura("Zathura: A Space Adventure"),
        Outer_Limits("Outer Limits"),
        Office_Space("Office Space"),
        Plan_9("Plan 9 from Outer Space"),
        Space_Cowboys("Space Cowboys"),
        Killer_Klowns("Killer Klowns from Outer Space"),
        Space_Odyssey("2001: Space Odyssey");
        private String title;

        Movie(String _title) {
            title = _title;
        }

        @Override
        public String toString() {
            return title;
        }
    }

    /**
     * Determine the correct movie for vague and mostly wrong titles
     *
     * @param title     the requested movie title
     * @return          the according correct movie (an enum)
     */
    public abstract Movie request(String title);
}
