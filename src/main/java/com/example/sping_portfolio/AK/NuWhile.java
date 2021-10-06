package com.example.sping_portfolio.AK.;

public class NuWhile extends _NuSequence {
    public void NuWhileWhile() {
        super();
    }

    @Override
    protected void init() {
        super.name = "While";

        long limit = super.size;
        long[] f = new long[]{1,3};
        while (limit-- > 0) {
            super.setData(f[0]);
            f = new long[]{f[1], ((f[1] - 1) + (f[1] - 2))};
        }
    }
}