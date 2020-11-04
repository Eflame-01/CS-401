package com.isa;

import java.util.ArrayList;

public class IntervalAlgorithm{
    protected ArrayList<Interval> A;

    private ArrayList<Interval> sortIntervals(ArrayList<Interval> list){
        //TODO: merge sort
        return list;
    }

    private void printResults(){
        for(Interval i : A){
            System.out.println("Start: " + i.getStartTime() + " Fin: " + i.getFinTime());
        }
    }

    public void performIntervalScheduling(ArrayList<Interval> list){
        //sort intervals by finTime in ascending order
        list = sortIntervals(list);

        //set A to the empty list
        A = new ArrayList<Interval>();

        //go though each interval and see if it's compatible
        for(Interval i : list){
            if(i.isCompatible(A)){
                A.add(i);
            }
        }

        //print results
        printResults();
    }
}