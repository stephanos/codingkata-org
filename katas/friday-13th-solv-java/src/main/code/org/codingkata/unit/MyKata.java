package org.codingkata.unit;

import java.util.Calendar;
import java.util.Date;
import org.codingkata.unit.api.BaseKataSolution;

public class MyKata extends BaseKataSolution {

    @Override
    public Date adjacentFriday13th(Date target) {

        Date ret = target;
        do {
            ret = new Date (ret.getTime() - (24 * 60 * 60 * 1000));
        } while (!isValid (ret));
        return ret;
    }

    private boolean isValid (Date d) {

         Calendar c = Calendar.getInstance();
         c.setTime(d);

         if (c.get (Calendar.DAY_OF_MONTH) != 13)
             return false;

         return c.get(Calendar.DAY_OF_WEEK) == Calendar.FRIDAY;
    }
}