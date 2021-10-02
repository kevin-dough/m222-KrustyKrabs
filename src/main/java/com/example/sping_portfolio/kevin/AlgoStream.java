package com.example.sping_portfolio.kevin;

import java.util.stream.Stream;

public class AlgoStream extends _AlgorithmExtend {
    public AlgoStream() {
        super();
    }
    public AlgoStream(int nth) {
        super(nth);
    }

    @Override
    protected void init() {
        super.name = "Stream";

        Stream.iterate(new long[]{1, 2}, f -> new long[]{f[1], (long) Math.pow(f[1],2)})
                .limit(super.size)
                .forEach(f -> super.setData(f[0]) );
    }
}