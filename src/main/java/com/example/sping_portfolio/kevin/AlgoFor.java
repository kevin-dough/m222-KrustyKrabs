package com.example.sping_portfolio.kevin;


public class AlgoFor extends _AlgorithmExtend {
    public AlgoFor() { super(); }
    public AlgoFor(int nth) {
        super(nth);
    }

    @Override
    protected void init() {
        super.name = "For";
        long limit = super.size;

        for (long[] f = new long[]{1, 2}; limit-- > 0; f = new long[]{f[1], (long) Math.pow(f[1],2)})
            super.setData(f[0]);
    }
}