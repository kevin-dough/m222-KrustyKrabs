package com.example.sping_portfolio.eshaan;

import com.example.sping_portfolio.ConsoleMethods;
import java.time.Duration;
import java.time.Instant;
import java.util.ArrayList;
import java.util.HashMap;

import lombok.Getter;

@Getter  // this will enable standard Getters on attributes in Class in form "getName" where "name" is attribute
public abstract class _ExponentialSequence {
    int size;
    String name;
    int hashID;
    Duration timeElapsed;
    ArrayList<Long> list;
    HashMap<Integer, Object> hash;

    public _ExponentialSequence() {
        this( 20);
    }

    public _ExponentialSequence(int nth) {
        this.size = nth;
        this.list = new ArrayList<>();
        this.hashID = 0;
        this.hash = new HashMap<>();
        //initialize fibonacci and time algorithm
        Instant start = Instant.now();  // time capture -- start
        this.init();
        Instant end = Instant.now();    // time capture -- end
        this.timeElapsed = Duration.between(start, end);
    }

    protected abstract void init();


    public void setData(long num) {
        list.add(num);
        hash.put(this.hashID++, list.clone());
    }


    public int getTimeElapsed() {
        return timeElapsed.getNano();
    }


    public long getNth() {
        return list.get(size - 1);
    }


    public Object getNthSeq(int i) {
        return hash.get(i);
    }

    public void print() {
        ConsoleMethods.println("Init method = " + this.name);
        ConsoleMethods.println("Init time = " + this.getTimeElapsed());
        ConsoleMethods.println("Fibonacci Number " + this.size + " = " + this.getNth());
        ConsoleMethods.println("Fibonacci List = " + this.getList());
        ConsoleMethods.println("Fibonacci Hashmap = " + this.getHash());
        for (int i=0 ; i<this.size; i++ ) {
            ConsoleMethods.println("Fibonacci Sequence " + (i+1) + " = " + this.getNthSeq(i));
        }
    }


    public static void main(String[] args) {
        ExpoFor.main(null);
        ExpoRecursion.main(null);
        ExpoStream.main(null);
        ExpoWhile.main(null);
    }
}