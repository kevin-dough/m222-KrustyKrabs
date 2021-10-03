package com.example.sping_portfolio.eshaan;

import java.util.stream.Stream;

public class ExpoStream extends _ExponentialSequence {
    public ExpoStream() {
        super();
    }
    public ExpoStream(int nth) {
        super(nth);
    }

    @Override
    protected void init() {
        super.name = "Stream";

        Stream.iterate(new long[]{1, 3}, f -> new long[]{f[1], ((f[1] - 1) + (f[1] + 2))})
                .limit(super.size)
                .forEach(f -> super.setData(f[0]) );
    }
}