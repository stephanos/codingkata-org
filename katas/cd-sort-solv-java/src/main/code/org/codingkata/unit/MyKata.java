package org.codingkata.unit;

import java.util.Collections;
import java.util.List;
import org.codingkata.unit.api.BaseKataSolution;

public class MyKata extends BaseKataSolution {

    @Override
    public List<String> sort(List<String> cds) {

        Collections.sort(cds);
        return cds;
    }
}
