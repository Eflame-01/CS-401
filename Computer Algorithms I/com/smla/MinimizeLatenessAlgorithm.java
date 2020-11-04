package com.smla;

import java.lang.*;
import java.util.ArrayList;
import java.util.List;

public class MinimizeLatenessAlgorithm {
    public final int START_TIME = 0;
    public final int FIN_TIME = 1;
    public final int DEADLINE = 2;

    private ArrayList<Schedule> sortSchedule(ArrayList<Schedule> list){
        //TODO: sort
        return list;
    }

    private void printResult(List<int[]> list){
        int minimumLatenessTime = 0;
        int lateTime = 0;

        //TODO: print results
        for(int[] i : list){
            lateTime = Math.max(0, i[DEADLINE] - i[FIN_TIME]);
            if(lateTime > minimumLatenessTime){
                minimumLatenessTime = lateTime;
            }

            System.out.println("Interval: (" + i[START_TIME] + "," + i[FIN_TIME] + ")");
        }

    }

    public void performMinimizeLatenessAlgorithm(ArrayList<Schedule> list){
        int time = 0;
        List<int[]> A = new ArrayList<int[]>();

        for(Schedule j : list){
            int interval = {time, time + j.time, j.deadline}
            A.add(interval);
            time = fin;
        }

        printResult(A);
    }
}
