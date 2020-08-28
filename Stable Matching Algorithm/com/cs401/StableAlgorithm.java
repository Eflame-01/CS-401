package com.cs401;

import java.util.ArrayList;

import com.cs401.Person.Gender;
import com.cs401.Person.Status;

public class StableAlgorithm {
    /**StableAlgorithm has the functions 
     * that perform the stable matching.
     */

     /**addAllPeople() adds all the people who want to be matched
      * into an ArrayList to be sorted out later
      */
     public static ArrayList<Person> addAllPeople(Person... people){
        ArrayList<Person> p = new ArrayList<Person>();
        for(Person person : people){
            p.add(person);
        }

        return p;
     }

     /**createEngagement() creates an engagement between two 
      * people. This method is called by the performStableMatching() method.
      */
     private static void createEngagement(Person man, Person woman){
        man.performPartnership(Status.ENGAGED, woman);
        woman.performPartnership(Status.ENGAGED, man);
     }

     /**getMarried() creates an performs the marriage between two 
      * people. This method is called by the performStableMatching() method.
      */
     private static void getMarried(Person man, Person woman){
         man.performPartnership(Status.MARRIED, woman);
         woman.performPartnership(Status.MARRIED, man);
     }

     /**performStableMatching() uses the methodology from the Stable Matching
      * problem to find perfect matching for couples and print the results out.
      */
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
            if(!performedRecursion){
                System.out.println("Cannot create stable/perfect match. Uneven amount of men and women.");
            }
            return;
        }
        else{
            if(!performedRecursion){
                System.out.println("Beginning Stable Mathching...");
            }
        }

        //This means there is an even number of men and women and you can begin the algorithm
        for(Person man : men){
            //have each man propose to every woman in order of preference until the man is engaged
            int choiceNumber = 1;
            while(man.getStatus().equals(Status.FREE)){
                //find the woman the man wants to propose to
                for(Person woman : women){
                    if(man.getPreferences().get(woman) == choiceNumber){
                        //check the relationship status of the woman to see if she can accept the proposal
                        if(woman.getStatus().equals(Status.FREE)){
                            //this means the woman can accept the man's proposal
                            createEngagement(man, woman);
                        }
                        //if woman is already engaged, check to see if she is happy with her current engagement already
                        else if(woman.getStatus().equals(Status.ENGAGED)){
                            if(woman.getPreferences().get(woman.getPartner()) < woman.getPreferences().get(man)){
                                //This means she is happy with her current engagement and will reject the proposal. Must loop around again.
                                choiceNumber++;
                                break;
                            }
                            else{ 
                                //This means she is not happy with her current engagement and accepts the man's proposal

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
                }
                //This means the man didn't find the woman while looping through this time. Must loop around again.
                choiceNumber++;
            }
        }

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
}