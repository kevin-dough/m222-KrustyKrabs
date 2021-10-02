package com.example.sping_portfolio.kevin;

import java.util.ArrayList;

public class AlgoRecursion extends _AlgorithmExtend {
    public AlgoRecursion() {
        super();
    }
    public AlgoRecursion(int nth) {
        super(nth);
    }

    @Override
    protected void init() {
        //setup for recursion
        super.name = "Recursion";
        long limit = super.size;
        long[] f = new long[]{1, 2};
        initRecurse(limit,f);
    }

    private void initRecurse(long limit, long[] f) {
        if (limit == 0) return;
        super.setData(f[0]);
        initRecurse(--limit, new long[]{f[1], (long) Math.pow(f[1],2)});
    }
}