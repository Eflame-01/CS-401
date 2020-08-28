package com.cs401;

import java.util.HashMap;

public class Person {
    /**A Person is a class that has a gender and 
     * list of preferences. To make this algorithm
     * simple the preferences has to be of a 
     * different geneder.
     */

    //enum to define genders
     public enum Gender{
         MALE, FEMALE;
     }

     //enum to define their relationship status
     public enum Status{
         FREE, ENGAGED, MARRIED;
     }

     //data members
     private String name;
     private Gender gender;
     private Status status;
     private HashMap<Person, Integer> preferences;
     private Person partner;

     //constructor
     public Person(String name, Gender gender){
         this.name = name;
         this.gender = gender;
         this.status = Status.FREE;
         this.preferences = new HashMap<Person, Integer>();
         this.partner = null;
     }

     //getters and setters
     public String getName(){
         return name;
     }
     public void setName(String name){
         this.name = name;
     }
     public Gender getGender(){
        return gender;
     }
     public void setGender(Gender gender){
         this.gender = gender;
     }
     public Status getStatus(){
         return status;
     }
     public void setStatus(Status status){
         this.status = status;
     }
     public HashMap<Person, Integer> getPreferences(){
         return preferences;
     }
     public void setPreferences(HashMap<Person, Integer> preferences){
         this.preferences = preferences;
     }
     public Person getPartner(){
         return partner;
     }
     public void setPartner(Person partner){
         this.partner = partner;
     }

     //functions to add prefernces
     public boolean addPreference(Person person, int rank){
        //checking if genders are different
        if(person.gender.equals(this.gender)){
            //This pair won't work.
            return false;
        }
        //checking if there is already a rank with this number
        if(this.preferences.containsValue(rank)){
            //There is no need to pair.
            return false;
        }
        
        //checking to see if person is already in list of preferences
        if(this.preferences.containsKey(person)){
            //This pair won't work.
            return false;
        }

        //if we get here, then that means this person is the right gender, hasn't already been paired, and has a valid rank number
        //This is a valid pair.
        this.preferences.put(person, rank);
        return true;
     }

     public void performPartnership(Status status, Person partner){
         if(status.equals(Status.FREE)){
             //you cannot perform a free partnership with someone... if you like em then you gotta put a ring on it.
             return;
         }
         this.status = status;
         this.partner = partner;
     }
    
}