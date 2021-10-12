package com.example.sping_portfolio.triangle;

public class TrigFor extends _Triangle {
    // zero and one argument constructors, both defer to super
    public TrigFor() { super(); }
    public TrigFor(int nth) {
        super(nth);
    }

    /*
    Abstract Polymorphic "init()" method using For
     */
    @Override
    protected void init() {
        super.name = "For";
        long limit = super.size;
        // for loops are likely the most common iteration structure, all the looping facts are in one line
        //for (long[] f = new long[]{0, 1}; 
        //     limit-- > 0; 
        //     f = new long[]{f[1], f[0] + f[1]})
        long[] f = new long[size];
        int counter = 2;
        f[0] = 1;
        super.setData(f[0]);
        for (int i = 0 ; i < size-1 ; i++ ){
            f[i+1] = f[i] + counter;
            super.setData(f[i+1]);
            counter++;

        }

    }

    /*
    Class method "main" with purpose of testing TrigFor
     */
    public static void main(String[] args) {
        _Triangle triangle = new TrigFor(20); // "TrigFor" is used as initializer for the "_Triangle triangle"  object
        triangle.print();
    }
}
