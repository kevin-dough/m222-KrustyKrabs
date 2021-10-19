package com.example.sping_portfolio.navodit.triangle;

public class TrigRecurse extends _Triangle {
    public TrigRecurse() {
        super();
    }
    public TrigRecurse(int nth) {
        super(nth);
    }

    /*
    Abstract Polymorphic "init()" method using Recursion
    */
    @Override
    protected void init() {
        //setup for recursion
        super.name = "Recursion";
        long limit = super.size;
        long[] f = new long[]{1,3};
        initRecurse(limit,f);       // recursion is redirected
    }

    /*
    Recursive methods contains an escape, in this  "base condition" with a limit
    VERY IMPORTANT... recursion requires pre-decrement, post-decrement will not occur until unstacking
     */
    private int initRecurse(long limit, long[] f) {
        super.setData(f[0]);
        if (limit == 1){
            return 1;                                 //exit condition
        }
        else
        initRecurse(--limit, new long[]{f[1], f[0] + f[1]});
        return 0;
    }

    /*
    Class method "main" with purpose of testing TrigRecurse
     */
    public static void main(String[] args) {
        _Triangle triangle = new TrigRecurse();  // "TrigRecurse" is used as initializer for the "_Traingle Trigonacci"  object
        triangle.print();
    }
}
