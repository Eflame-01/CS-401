package com.isa;

import java.util.ArrayList;

public class Interval {
    private int startTime;
    private int finTime;

    public Interval(int startTime, int finTime){
        this.setStartTime(startTime);
        this.setFinTime(finTime);
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
