package com.example.sping_portfolio.eshaan;

public class ExpoFor extends _ExponentialSequence {
    public ExpoFor() { super(); }
    public ExpoFor(int nth) {
        super(nth);
    }

    @Override
    protected void init() {
        super.name = "For";
        long limit = super.size;

        for (long[] f = new long[]{1, 3}; limit-- > 0; f = new long[]{f[1], (((f[1] - 1) + (f[1] + 2)))})
            super.setData(f[0]);
    }
}