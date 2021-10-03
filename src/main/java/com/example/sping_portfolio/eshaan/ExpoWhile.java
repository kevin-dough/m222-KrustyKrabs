package com.example.sping_portfolio.eshaan;

public class ExpoWhile extends _ExponentialSequence {
    public ExpoWhile() {
        super();
    }
    public ExpoWhile(int nth) {
        super(nth);
    }

    @Override
    protected void init() {
        super.name = "While";

        long limit = super.size;
        long[] f = new long[]{1,3};
        while (limit-- > 0) {
            super.setData(f[0]);
            f = new long[]{f[1], ((f[1] - 1) + (f[1] + 2))};
        }
    }
}