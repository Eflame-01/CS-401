package com.cs401;

import java.util.ArrayList;

import com.cs401.Person.Gender;
import com.cs401.Person.Status;

public class StableAlgorithm {
    /**StableAlgorithm has the functions 
     * that perform the stable matching.
     */


     public static ArrayList<Person> addAllPeople(Person... people){
         ArrayList<Person> p = new ArrayList<Person>();
         for(Person person : people){
             p.add(person);
         }

        return p;
     }

     public static void performStableMatching(ArrayList<Person> people, boolean performedRecursion){
        int numMen = 0;
        int numWomen = 0;
         ArrayList<Person> men = new ArrayList<Person>();
         ArrayList<Person> women = new ArrayList<Person>();
         ArrayList<Person> listOfUnpaired = new ArrayList<Person>();

        for(Person person : people){
             if(person.getGender().equals(Gender.MALE)){
                 numMen++;
                 men.add(person);
             }
             else{
                 numWomen++;
                 women.add(person);
             }
        }

        //if numMen =/= numWomen, you cannot create a stable match, so break it off
        if(numMen != numWomen){
             System.out.println("Cannot create stable/perfect match. Uneven amount of men and women.");
             return;
        }
        else{
            if(!performedRecursion){
                System.out.println("Beginning Stable Mathching...");
            }
        }

        //This means there is an even number of men and women and you can begin the algorithm
        for(Person man : men){
            //have each man propose to their number one choice
            int choiceNumber = 1;
            while(man.getStatus().equals(Status.FREE)){
                for(Person woman : women){
                    if(man.getPreferences().get(woman) == choiceNumber){
                        //check the relationship status of the woman to see if she can accept the proposal
                        if(woman.getStatus().equals(Status.FREE)){
                            //this means the woman can accept the man's proposal
                            createEngagement(man, woman);
                        }
                        //if woman is already engaged, check to see if she would be happy with her choice
                        else if(woman.getStatus().equals(Status.ENGAGED)){
                            if(woman.getPreferences().get(woman.getPartner()) < woman.getPreferences().get(man)){
                                //This means she is happy with her choice and will reject the proposal
                                choiceNumber++;
                            }
                            else{
                                //This means she prefers the man who proposed over her fiance and accepts the man's proposal

                                //break off old engagement
                                Person freedMan = woman.getPartner();
                                freedMan.setStatus(Status.FREE);
                                listOfUnpaired.add(freedMan);
                                
                                //create new engagement
                                createEngagement(man, woman);
                                break;
                            }
                        }
                    }
                    else{
                        choiceNumber++;
                    }
                }
            }
            
        }//End of the matching process...

        //check to see if there are any women who didn't get proposed to
        for(Person woman : women){
            if(woman.getStatus().equals(Status.FREE)){
                listOfUnpaired.add(woman);
            }
        }

        //if ther are still people who are free, perform the function again to pair people
        listOfUnpaired.trimToSize();
        if(listOfUnpaired.size() > 0){
            performStableMatching(listOfUnpaired, true);
            
        }

        //print the results in the base function
        if(!performedRecursion){
            //print out the results of the matching
            System.out.println("Pairs Are:");
            for(Person man : people){
                if(man.getGender().equals(Gender.MALE)){
                    System.out.println("(" + man.getName() + ", " + man.getPartner().getName() + ")");
                    getMarried(man, man.getPartner());
                }
            }
        }

     }


     public static void createEngagement(Person man, Person woman){
        man.performPartnership(Status.ENGAGED, woman);
        woman.performPartnership(Status.ENGAGED, man);
     }

     public static void getMarried(Person man, Person woman){
         man.performPartnership(Status.MARRIED, woman);
         woman.performPartnership(Status.MARRIED, man);
     }
}