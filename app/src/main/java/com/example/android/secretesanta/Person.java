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
 *
 * Methods:
 *      Getters & Setters
 **/
public class Person {
    //Attributes
    private int id;
    private String name;
    private String eMail;
    private String secret;

    //Methods:
    //Getters:
    public int getId(){
        return id;
    }

    public String getName(){
        return name;
    }

    public String geteMail(){
        return eMail;
    }

    public String getSecret(){
        return secret;
    }

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

    public void setSecret(String secret){
        this.secret=secret;
    }

}
