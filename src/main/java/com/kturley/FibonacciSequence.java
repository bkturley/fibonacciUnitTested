package com.kturley;

import java.util.ArrayList;

public class FibonacciSequence {

    Integer upToHere;
    private ArrayList<Integer> value;

    public FibonacciSequence upTo(Integer upToHere) {
        this.upToHere = upToHere;
        return this;
    }

    public ArrayList<Integer> value(){

        value = new ArrayList();

        if(upToHere != null){
            value.add(new Integer(0));
            value.add(new Integer(1));
            while (value.get(value.size()-1) < upToHere) {
                value.add(value.get(value.size()-1) + value.get(value.size()-2));
            }
            value.remove(value.size()-1);
        }

        return value;
    }

    public Integer largest(){
        return value().get(value.size()-1);
    }
}
