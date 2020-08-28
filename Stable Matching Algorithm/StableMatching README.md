This file is my crack at trying the Stable Matching algorithm in an Object Oriented way. As a result, this may not even count as O(n^2), but it was something that I made to help me better understand how Stable Matching works, and how it can be used.

Links to other algorithms that use Stable Matching:
https://www.geeksforgeeks.org/stable-marriage-problem/
https://blog.bitsrc.io/analysis-of-algorithms-stable-matching-explained-5f3c51876cfe

Main:
    In the main method, 4 people are created: 2 men and 2 woman. 
    After which, the 4 people chose thier preference amongst each other.
    After that, you put the people in the list of people that need to be matched, and call the function to perform the matching algorithm that prints out the results.

Person:
    The person class has name, gender, marital status, and preferences.
    To make a person you pass name and gender.
    To make a preference, you call the addPreference(Person p, int rank) method
    To perform engagement or marriage, you call the performPartnership(Status status, Person partner) method

StableAlgorithm:
    The StableAlgorithm class has no data members, just functions that help perform the stable matching algorithm
    addAllPeople(Person... people) method adds all the people and puts them in an ArrayList
    performStableMatching(ArrayList<Person> people, boolean performedRecursion) method actually performs the algorithm
    createEngagement(Person man, Person woman) changes the status of the man and woman to ENGAGED
    getMarried(Person man, Person woman) changes the status of the man and woman to MARRIED

How Algorithm Works:
    Initially all m ∈ M and w ∈ W are free
    While there is a man m who is free and hasn’t proposed to every woman
        Choose such a man m
        Let w be the highest-ranked woman in m’s preference list
        to whom m has not yet proposed
        If w is free then
            (m, w) become engaged
        Else w is currently engaged to m
            If w prefers m to m then
                m remains free
            Else w prefers m to m
                (m, w) become engaged
                m becomes free
            Endif
        Endif
    Endwhile
Return the set S of engaged pairs

This algorithm in this form is a lot simpler than my attempt at replicating it, so if you have a hard time figuring out the code, this might be a better way at explaining it.