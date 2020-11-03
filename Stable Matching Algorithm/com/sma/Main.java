package com.sma;

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
        manOne.addPreference(womanOne, womanTwo, womanThree, womanFour);
        manTwo.addPreference(womanTwo, womanThree, womanOne, womanFour);
        manThree.addPreference(womanThree, womanOne, womanTwo, womanFour);
        manFour.addPreference(womanOne, womanTwo, womanThree, womanFour);

        womanOne.addPreference(manTwo, manThree, manFour, manOne);
        womanTwo.addPreference(manThree, manFour, manOne, manTwo);
        womanThree.addPreference(manFour, manOne, manTwo, manThree);
        womanFour.addPreference(manOne, manTwo, manThree, manFour);

        //add the people to the list
        ArrayList<Person> people = StableAlgorithm.addAllPeople(manOne, manTwo, manThree, manFour, womanOne, womanTwo, womanThree, womanFour);

        //Print out the result of the algorithm
        StableAlgorithm.performStableMatching(people, false);
    }

}