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
        System.out.println("Creating Engagement for " + man.getName() + " and " + woman.getName());
        man.performPartnership(Status.ENGAGED, woman);
        woman.performPartnership(Status.ENGAGED, man);
    }

    /**breakOffEngagement() breaks off the engagement between two
     * people. This method returns the man who got his heart broken
     * by his prefered choice :(
     */
    private static Person breakOffEngagement(Person woman){
        System.out.println("- Breaking Off Engagement for " + woman.getPartner().getName() + " and " + woman.getName());
        Person freeMan = woman.getPartner();
        freeMan.setStatus(Status.FREE);
        freeMan.setPartner(null);

        return freeMan;
    }

    /**getMarried() creates an performs the marriage between two 
     * people. This method is called by the performStableMatching() method.
     */
    private static void getMarried(Person man, Person woman){
        System.out.println(man.getName() + " and " + woman.getName() + " got married!");
        man.performPartnership(Status.MARRIED, woman);
        woman.performPartnership(Status.MARRIED, man);
    }

    private static ArrayList<Person> replaceMan(ArrayList<Person> list, Person person){
        for(Person p : list){
            if(p.getName().equals(person.getName())){
                p = person;
            }
        }

        return list;
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

        //count the amount of men and women in the stable matching problem while appedning them to their respective lists
        for(Person person : people){
            if(person.getGender().equals(Gender.MALE)){
                numMen++;
                person.setChoiceNumber(1);
                men.add(person);
            }
            else{
                numWomen++;
                women.add(person);
            }
            listOfUnpaired.add(person);
        }

        //if numMen =/= numWomen, you cannot create a stable match, so break it off
        if(numMen != numWomen){
            if(!performedRecursion){
                System.out.println("Cannot create stable/perfect match. Uneven amount of men and women...\n");
            }
            return;
        }
        //this means there is an even number of men and women and you can begin the algorithm
        else{
            if(!performedRecursion){
                System.out.println("Beginning Stable Mathching...\n");
            }
            else{
                System.out.println("Beginning Stable Matching Again...\n");
            }
        }

        //have every man who is free propose to a woman in order of preference until the man is engaged
        int i = 0;
        while(i < men.size() && men.get(i).getStatus().equals(Status.FREE)){
            Person man = men.get(i);
            for(Person woman: women){
                if(man.getPreferences().get(woman) == man.getChoiceNumber()){
                    //check the relationship status of the woman to see if she can accept the proposal
                    if(woman.getStatus().equals(Status.FREE)){
                        //this means the woman can accept the man's proposal
                        createEngagement(man, woman);
                        break;
                    }
                    else if(woman.getStatus().equals(Status.ENGAGED)){
                        //this means the woman needs to see if she prefers her current relationship over the proposal
                        if(woman.getPreferences().get(woman.getPartner()) < woman.getPreferences().get(man)){
                            //this means she prefers her current relationship. Have the man move on to his next choice
                            man.setChoiceNumber(man.getChoiceNumber() + 1);
                            System.out.println("- " + woman.getName() + " rejected " + man.getName());
                        }
                        else{
                            //this means she prefers the new proposal over her current relationship. Free the man and engage the new couple
                            Person freeMan = breakOffEngagement(woman);
                            System.out.println("- Adding " + freeMan.getName() + " to the list of unpaired.");
                            listOfUnpaired = replaceMan(listOfUnpaired, freeMan);
                            createEngagement(man, woman);
                            break;
                        }
                    }
                }
            }

            //don't actually move on to the next man until he is engaged.
            if(man.getStatus().equals(Status.ENGAGED)){
                //move on to next man in list
                i++;
            }
        }

        System.out.println();
        int numFree = 0;
        for(Person person : listOfUnpaired){
            System.out.println("Status for " + person.getName() + ": " + person.getStatus());
            if(person.getStatus().equals(Status.FREE)){
                numFree++;
            }
        }

        System.out.println();
        if(numFree > 0){
            performStableMatching(listOfUnpaired, true);
        }

        //print the results in the base function (after all the recursive calls have been made if any)
        if(!performedRecursion){
            //print out the results of the matching
            people.trimToSize();
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