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
     private int choiceNumber = 1;

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
     public int getChoiceNumber(){
         return choiceNumber;
     }
     public void setChoiceNumber(int choiceNumber){
         this.choiceNumber = choiceNumber;
     }

     /**addPreference() adds a person and their rank to the current person's
      * list of preferences.
      */
     public void addPreference(Person... people){
        for(Person person : people){
            //checking if genders are different
            if(person.gender.equals(this.gender)){
                //This pair won't work.
                continue;
            }
            //checking if there is already a rank with this number
            else if(this.preferences.containsValue(this.choiceNumber)){
                //There is no need to pair.
                continue;
            }
            //checking to see if person is already in list of preferences
            else if(this.preferences.containsKey(person)){
                //This pair won't work.
                continue;
            }
            //if we get here, then that means this person is the right gender, hasn't already been paired, and has a valid rank number
            //This is a valid pair.
            else{
                this.preferences.put(person, this.choiceNumber);
                this.choiceNumber++;
            }
        }
     }

     /**performPartnership() creates a partnership between the current person and their
      * partner. You can only create engagements and marriages when calling this function.
      */
     public void performPartnership(Status status, Person partner){
         if(status.equals(Status.FREE)){
             //you cannot perform a free partnership with someone... if you like em then you gotta put a ring on it.
             return;
         }
         this.status = status;
         this.partner = partner;
     }
    
}