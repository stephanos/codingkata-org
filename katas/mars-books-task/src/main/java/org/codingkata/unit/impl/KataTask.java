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

    private IKataSolution m_solution;

    class ISBN {
        String code;
        int check;

        public ISBN (String _code, int _check) {
            code = _code;
            check = _check;
        }
    }

    public void start() {

        List<ISBN> codes = new ArrayList<ISBN> ();
        codes.add(new ISBN ("978045152493", 5));
        codes.add(new ISBN ("978034534296", 6));
        codes.add(new ISBN ("978081297462", 1));
        codes.add(new ISBN ("978019479222", 6));
        codes.add(new ISBN ("978044178838", 5));
        codes.add(new ISBN ("978031286355", 5));
        codes.add(new ISBN ("978044178358", 8));
        codes.add(new ISBN ("978038097383", 5));
        codes.add(new ISBN ("978140009690", 9));
        Collections.shuffle(codes);

        for (ISBN i : codes) {
            validate(i.check, m_solution.calcCheckDigit(i.code), i.code);
        }
    }

    @Override
    public void setSolution(IKataCommonSolution pSolution) {
        m_solution = (IKataSolution) pSolution;
    }
}
