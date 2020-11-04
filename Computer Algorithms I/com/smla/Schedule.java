package com.smla;

public class Schedule {
    private String name;
    private int time;
    private int deadline;

    public Schedule(String name, int time, int deadline){
        this.name = name;
        this.time = time;
        this.deadline = deadline;
    }

    public String getName(){
        return name;
    }
    public void setName(String name){
        this.name = name;
    }
    public int getTime(){
        return time;
    }
    public void setTime(int time){
        this.time = time;
    }
    public int getDeadline(){
        return deadline;
    }
    public void setDeadline(int deadline){
        this.deadline = deadline;
    }
}
