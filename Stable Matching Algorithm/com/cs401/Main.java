package com.cs401;

import java.util.ArrayList;

public class Main {
    /**Main is responsible for actually
     * performing the algorithm.
     */

    public static void main(String[] args) {
        //Create the people
        Person manOne = new Person("male 1", Person.Gender.MALE);
        Person manTwo = new Person("male 2", Person.Gender.MALE);
        Person womanOne = new Person("woman 1", Person.Gender.FEMALE);
        Person womanTwo = new Person("woman 2", Person.Gender.FEMALE);

        //Create the preferences
        manOne.addPreference(womanOne, 1);
        manOne.addPreference(womanTwo, 2);

        manTwo.addPreference(womanOne, 1);
        manTwo.addPreference(womanTwo, 2);

        womanOne.addPreference(manTwo, 1);
        womanOne.addPreference(manOne, 2);

        womanTwo.addPreference(manTwo, 1);
        womanTwo.addPreference(manOne, 2);

        //add the people to the list
        ArrayList<Person> people = StableAlgorithm.addAllPeople(manOne, manTwo, womanOne, womanTwo);

        //Print out the result of the algorithm
        StableAlgorithm.performStableMatching(people, false);
    }

}