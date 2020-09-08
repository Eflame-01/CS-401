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
        Person manFour = new Person("man 4", Person.Gender.MALE);
        Person womanOne = new Person("woman 1", Person.Gender.FEMALE);
        Person womanTwo = new Person("woman 2", Person.Gender.FEMALE);
        Person womanThree = new Person("woman 3", Person.Gender.FEMALE);
        Person womanFour = new Person("woman 4", Person.Gender.FEMALE);

        //Create the preferences
        manOne.addPreference(womanOne);
        manOne.addPreference(womanTwo);
        manOne.addPreference(womanThree);
        manOne.addPreference(womanFour);

        manTwo.addPreference(womanTwo);
        manTwo.addPreference(womanThree);
        manTwo.addPreference(womanOne);
        manTwo.addPreference(womanFour);

        manThree.addPreference(womanThree);
        manThree.addPreference(womanOne);
        manThree.addPreference(womanTwo);
        manThree.addPreference(womanFour);

        manFour.addPreference(womanOne);
        manFour.addPreference(womanTwo);
        manFour.addPreference(womanThree);
        manFour.addPreference(womanFour);

        womanOne.addPreference(manTwo);
        womanOne.addPreference(manThree);
        womanOne.addPreference(manFour);
        womanOne.addPreference(manOne);

        womanTwo.addPreference(manThree);
        womanTwo.addPreference(manFour);
        womanTwo.addPreference(manOne);
        womanTwo.addPreference(manTwo);

        womanThree.addPreference(manFour);
        womanThree.addPreference(manOne);
        womanThree.addPreference(manTwo);
        womanThree.addPreference(manThree);

        womanFour.addPreference(manOne);
        womanFour.addPreference(manTwo);
        womanFour.addPreference(manThree);
        womanFour.addPreference(manFour);

        //add the people to the list
        ArrayList<Person> people = StableAlgorithm.addAllPeople(manOne, manTwo, manThree, manFour, womanOne, womanTwo, womanThree, womanFour);

        //Print out the result of the algorithm
        StableAlgorithm.performStableMatching(people, false);
    }

}