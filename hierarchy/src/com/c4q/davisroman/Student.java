package com.c4q.davisroman;

import java.util.HashMap;

/**
 * Created by davis on 4/4/15.
 */

public class Student {
    HashMap<Lunchbox, Integer> lunchboxInteger;
    private String name;
    private int numOfPencilsInPocket;
    private Lunchbox box;

    public Student(String name){
        lunchboxInteger = new HashMap<Lunchbox, Integer>();
        this.name = name;
    }

    public String getName(){
        return name;
    }

    public int getNumOfPencilsInPocket(){
        return numOfPencilsInPocket;
    }

    public void setNumOfPencilsInPocket(int numOfPencilsInPocket){
        this.numOfPencilsInPocket = numOfPencilsInPocket;
    }

    public void setLunchBox(Lunchbox item){
        box = item;
        lunchboxInteger.put(box, numOfPencilsInPocket);
    }
}
