package com.example.sping_portfolio.eshaan;

public class ExpoRecursion extends _ExponentialSequence {
    public ExpoRecursion() {
        super();
    }
    public ExpoRecursion(int nth) {
        super(nth);
    }

    @Override
    protected void init() {
        //setup for recursion
        super.name = "Recursion";
        long limit = super.size;
        long[] f = new long[]{1, 3};
        initRecurse(limit,f);
    }

    private void initRecurse(long limit, long[] f) {
        if (limit == 0) return;
        super.setData(f[0]);
        initRecurse(--limit, new long[]{f[1], ((f[1] - 1) + (f[1] + 2))});
    }
}