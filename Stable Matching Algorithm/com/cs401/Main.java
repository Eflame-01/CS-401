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
        manOne.addPreference(womanOne, 1);
        manOne.addPreference(womanTwo, 3);
        manOne.addPreference(womanThree, 2);

        manTwo.addPreference(womanOne, 1);
        manTwo.addPreference(womanTwo, 2);
        manTwo.addPreference(womanThree, 3);

        manThree.addPreference(womanOne, 3);
        manThree.addPreference(womanTwo, 2);
        manThree.addPreference(womanThree, 1);

        womanOne.addPreference(manTwo, 1);
        womanOne.addPreference(manOne, 2);
        womanOne.addPreference(manThree, 3);

        womanTwo.addPreference(manTwo, 1);
        womanTwo.addPreference(manOne, 3);
        womanTwo.addPreference(manThree, 2);

        womanThree.addPreference(manOne, 3);
        womanThree.addPreference(manTwo, 2);
        womanThree.addPreference(manThree, 1);

        //add the people to the list
        ArrayList<Person> people = StableAlgorithm.addAllPeople(manOne, manTwo, manThree, womanOne, womanTwo, womanThree);

        //Print out the result of the algorithm
        StableAlgorithm.performStableMatching(people, false);
    }

}