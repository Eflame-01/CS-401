package com.isa;

import java.util.ArrayList;

public class Interval {
    private String name;
    private int startTime;
    private int finTime;

    public Interval(String name, int startTime, int finTime){
        this.setName(name);
        this.setStartTime(startTime);
        this.setFinTime(finTime);
    }

    public String getName(){
        return name;
    }
    public void setName(String name){
        this.name = name;
    }
    public int getStartTime(){
        return startTime;
    }
    public void setStartTime(int startTime){
        this.startTime = startTime;
    }
    public int getFinTime(){
        return finTime;
    }
    public void setFinTime(int finTime){
        this.finTime = finTime;
    }

    public boolean isCompatible(ArrayList<Interval> A){
        if(A.isEmpty()){
            return true;
        }

        for(Interval i : A){
            if(this.startTime >= i.startTime && this.startTime <= i.finTime){
                return false;
            }
            if(this.finTime >= i.finTime && this.finTime <= i.finTime){
                return false;
            }
        }

        return true;
    }
}
