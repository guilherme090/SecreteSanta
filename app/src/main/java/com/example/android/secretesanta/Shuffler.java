package com.example.android.secretesanta;

/**
 * public class Shuffler
 * Contains a list of people and methods for shuffling their secret santa
 * Attributes:
 *      Person [] listOfParticipants
 *
 * Methods:
 *      <Constructor> public Shuffler(int players)
 *      public void shuffle(int numOfPeople) assign secret santa to every person in the list
 *      private void emptyFriends() to be used by shuffle() function
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

    /**
     *  public boolean shuffle(int numOfPeople)
     *  randomly assigns Person values to each Person object in the list.
     *  Takes as argument the number of people to shuffle (list will be analyzed from 0 to
     *     this number.
     *  Returns true if no one took their own name
     *  Returns false otherwise
     **/
    public boolean shuffle(int numOfPeople){
        emptyFriends();
        for(int i=0;i<numOfPeople;i++){
            //get secret friend number, which represents a position in the array
            int randomSanta = (int) Math.floor(Math.random()*(numOfPeople-i)); //gets number from 0
            // to numOfPeople-1-i

            //sweep the array to find the randomSanta-th empty friend position
            int emptySlotCursor = 0;
            while(true){
                //look for blank friend spot which is not equal to the object itself
                while(listOfParticipants[emptySlotCursor].getWasTaken() == true){
                    emptySlotCursor++;
                }
                //found empty spot.
                randomSanta--;
                if(randomSanta < 0){
                    listOfParticipants[i].setSecret(listOfParticipants[emptySlotCursor]);
                    listOfParticipants[emptySlotCursor].setWasTaken(true);
                    break;
                }
                emptySlotCursor++;
            }
        }
        //if someone took their own name, return false
        for(int i=0;i<numOfPeople;i++){
            if(listOfParticipants[i].getSecret().getId() == listOfParticipants[i].getId())
                return false;
        }
        return true;
    }

    /**
     *  private void emptyFriends()
     *  to be used internally by the shuffle function
     *  Completely erases the data related to previous shuffling.
     **/
    private void emptyFriends(){
        for(int i=0;i<listOfParticipants.length;i++){
            listOfParticipants[i].setSecret(null);
            listOfParticipants[i].setWasTaken(false);
        }
    }
}
