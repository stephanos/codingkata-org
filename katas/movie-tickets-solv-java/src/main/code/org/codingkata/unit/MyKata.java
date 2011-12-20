package org.codingkata.unit;

import org.codingkata.unit.api.BaseKataSolution;

public class MyKata extends BaseKataSolution {

    float sum;
    int tickets;
    float addsEachTicket;
    boolean movie3d;
    boolean parquet;
    boolean overlenght;
    boolean movieDay;
    boolean weekend;

    @Override
    public void startPurchase(int runtime, Day day, boolean isParquet, boolean is3D) {
        
        sum = 0.0f;
        tickets = 0;
        addsEachTicket = 0;
        movie3d = is3D;
        parquet = isParquet;
        overlenght = runtime > 120 ? true : false;
        movieDay = day == Day.THU;
        weekend = day == Day.SAT || day == Day.SUN;

        if (movie3d) addsEachTicket += 3.00f;
        if (overlenght) addsEachTicket += 1.50f;
        if (movieDay) addsEachTicket -= 2.00f;
        if (weekend) addsEachTicket += 1.50f;
        if (!parquet) addsEachTicket += 2.00f;
    }

    @Override
    public void addTicket(int age, boolean isStudent) {

        float add = 0.0f;
        if (age < 13) {
            add = 5.5f;
        } else if (age >= 65) {
            add = 6.00f;
        } else {
            add = isStudent ? 8.00f : 11.00f;
        }

        tickets++;
        sum += add + addsEachTicket;
    }

    @Override
    public float finishPurchase() {
        if (tickets > 20)
            return tickets * (6.00f + (movieDay ? addsEachTicket+2.00f : addsEachTicket));
        else
            return sum;
    }
}