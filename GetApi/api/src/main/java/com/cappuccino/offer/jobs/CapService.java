package com.cappuccino.offer.jobs;


public class CapService
{

    public static Integer work(Double payout)
    {
        int cap = 100;

        if (payout.intValue() <= 1)
        {
            cap = 1000;
        }
        if (payout.intValue() > 1 && payout.intValue() <= 2)
        {
            cap = 500;
        }
        if (payout.intValue() > 2 && payout.intValue() <= 4)
        {
            cap = 200;
        }
        if (payout.intValue() > 4)
        {
            cap = 100;
        }
        return cap;
    }

}
