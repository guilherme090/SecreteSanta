package com.example.android.secretesanta;

/**
 * public class Shuffler
 * Contains a list of people and methods for shuffling their secret santa
 * Attributes:
 *      Person [] listOfParticipants
 *
 * Methods:
 *      <Constructor> public Shuffler(int players)
 **/
public class Shuffler {
    Person [] listOfParticipants;

    //constructor
    public Shuffler(int players){
        listOfParticipants = new Person[players];
        //initialize participant array with Person instances
        for(int i=0;i<players; i++){
            listOfParticipants[i] = new Person(i+1); //ids vary from 1 to number of participants
        }
    }
}
