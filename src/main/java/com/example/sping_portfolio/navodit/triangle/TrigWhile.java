package com.example.sping_portfolio.navodit.triangle;

public class TrigWhile extends _Triangle {
    public TrigWhile() {
        super();
    }
    public TrigWhile(int nth) {
        super(nth);
    }

    /*
    Abstract Polymorphic "init()" method using While
    */
    @Override
    protected void init() {
        super.name = "While";
        // longer and more error prone "while" syntax is often best performer in this small scale test
        long limit = super.size;
        //long[] f = new long[]{0, 1};
        long[] f = new long[size];
        int i = 0;
        f[0] = 1;
        int counter = 2;
        while (i < size-1) {
            f[i+1] = f[i] + counter;
            i++;
            counter++;
            super.setData(f[i+1]);
        }
    }

    /*
    Class method "main" with purpose of testing FibWhile
     */
    public static void main(String[] args) {
        _Triangle triangle = new TrigWhile();
        triangle.print();
    }
}