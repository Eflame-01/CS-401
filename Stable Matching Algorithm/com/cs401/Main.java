package com.cs401;

import java.util.ArrayList;

public class Main {
    /**Main is responsible for actually
     * performing the algorithm.
     */

    public static void main(String[] args) {
        //Create the people
        Person manOne = new Person("man 1", Person.Gender.MALE);
        Person manTwo = new Person("man 2", Person.Gender.MALE);
        Person manThree = new Person("man 3", Person.Gender.MALE);
        Person womanOne = new Person("woman 1", Person.Gender.FEMALE);
        Person womanTwo = new Person("woman 2", Person.Gender.FEMALE);
        Person womanThree = new Person("woman 3", Person.Gender.FEMALE);

        //Create the preferences
        manOne.addPreference(womanOne);
        manOne.addPreference(womanThree);
        manOne.addPreference(womanTwo);

        manTwo.addPreference(womanOne);
        manTwo.addPreference(womanTwo);
        manTwo.addPreference(womanThree);

        manThree.addPreference(womanThree);
        manThree.addPreference(womanTwo);
        manThree.addPreference(womanOne);

        womanOne.addPreference(manTwo);
        womanOne.addPreference(manOne);
        womanOne.addPreference(manThree);

        womanTwo.addPreference(manTwo);
        womanTwo.addPreference(manThree);
        womanTwo.addPreference(manOne);

        womanThree.addPreference(manThree);
        womanThree.addPreference(manTwo);
        womanThree.addPreference(manOne);

        //add the people to the list
        ArrayList<Person> people = StableAlgorithm.addAllPeople(manOne, manTwo, manThree, womanOne, womanTwo, womanThree);

        //Print out the result of the algorithm
        StableAlgorithm.performStableMatching(people, false);
    }

}