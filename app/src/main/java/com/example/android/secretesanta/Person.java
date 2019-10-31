package com.example.android.secretesanta;

/**
 * public class Person
 * It is the unique data for each participant
 * Attributes:
 *      private int id (primary key)
 *      private String name
 *      private String eMail
 *      private Person secret (foreign key - object of secret santa, if any)
 *      private boolean isAssigned (set to true after shuffling)
 *      private boolean wasTaken (true if someone took their name)
 *
 * Methods:
 *      <Constructor> public Person(int id) // creates empty object with id, only.
 *      Getters & Setters
 **/
public class Person {
    //Attributes
    private int id; //not yet being used
    private String name;
    private String eMail;
    private Person secret;
    private Boolean wasTaken;

    //Methods:
    //Constructor
    public Person(int id){
        this.id = id;
        this.wasTaken = false;
    }
    //Getters:
    public int getId(){
        return id;
    }

    public String getName(){
        return name;
    }

    public String getEMail(){
        return eMail;
    }

    public Person getSecret(){
        return secret;
    }

    public Boolean getWasTaken(){return wasTaken;}


    //Setters:
    public void setId(int id){
        this.id=id;
    }

    public void setName(String name){
        this.name=name;
    }

    public void setEMail(String eMail){
        this.eMail=eMail;
    }

    public void setSecret(Person secret){
        this.secret=secret;
    }

    public void setWasTaken(Boolean wasTaken){this.wasTaken = wasTaken;}

}
