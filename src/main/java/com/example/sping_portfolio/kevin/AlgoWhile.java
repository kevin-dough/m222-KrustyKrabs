package com.example.sping_portfolio.kevin;

public class AlgoWhile extends _AlgorithmExtend {
    public AlgoWhile() {
        super();
    }
    public AlgoWhile(int nth) {
        super(nth);
    }

    @Override
    protected void init() {
        super.name = "While";

        long limit = super.size;
        long[] f = new long[]{1, 2};
        while (limit-- > 0) {
            super.setData(f[0]);
            f = new long[]{f[1], (long) Math.pow(f[1],2)};
        }
    }
}