package com.example.android.secretesanta;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.transition.Explode;
import android.transition.Scene;
import android.transition.Transition;
import android.transition.TransitionManager;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    /**
     * Scene declaration for app in chronological order (activity_main is the first one)
     **/
    private Scene activity_main; //initial screen
    private Scene scene_number_of_people; //screen for adding names and e-mails

    /**
     * GUI elements in the app by scene
     **/
    //activity_main

    //scene_number_of_people
    TextView numberOfParticipantsLabel; //to be used in the e-mail and name screen
    ParticipantView pptView; //to be filled with the names and e-mails

    /**
     * Data structures and app variables
     **/
    final int MIN_PLAYERS = 3; //it does not make sense to sort 2 people or less
    final int MAX_PLAYERS = 50; //do not allow more than this many people
    private int numberOfParticipants = 3; //updates by user via buttons
    Shuffler list = new Shuffler(MAX_PLAYERS);
    //Person [] listOfParticipants = new Person[MAX_PLAYERS]; //initialize with Person instances

    /**
     * Context variables
     **/

    Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Assign app's scenes to what is in the .xml files
        activity_main = Scene.getSceneForLayout((ViewGroup)findViewById(R.id.sceneContainer),
                R.layout.activity_main,this);
        scene_number_of_people = Scene.getSceneForLayout((ViewGroup)findViewById(R.id.sceneContainer),
                R.layout.scene_number_of_people,this);
        activity_main.enter();
    }

    /**
     * Functions that are accessed via GUI buttons in every scene
     **/

    //activity_main
    /**
     *  public void startApp(View view)
     *  move from title screen to next scene (where participants data are gathered)
     **/
    public void startApp(View view){
        Transition explode = new Explode();
        TransitionManager.go(scene_number_of_people, explode);
        //In the new view, show list of participants
        showParticipants();
    }

    //scene_number_of_people
    /**
     *  void showParticipants()
     *  this is launched the first time the names and e-mails scene is called.
     *  create one nameView and one emailView for each participant (MAX_PLAYERS)
     **/
    void showParticipants(){
        //update text views in the screen for names and e-mails
        pptView = new ParticipantView (context);

        //find scene's main layout and attach new views to it.
        LinearLayout participantsLayout = (LinearLayout)
                findViewById(R.id.number_of_participants_layout);
        //Create all views for the maximum number of players. Hide those below the minimum value.
        for(int i=0;i<MAX_PLAYERS;i++){
            participantsLayout.addView(pptView.nameView(getApplicationContext(),i+1 + ". Name"));
            participantsLayout.addView(pptView.emailView(getApplicationContext(),i+1 + ". E-mail"));
        }
        //hide all views after the minimum number of players
        hideRemainingViews(MIN_PLAYERS,participantsLayout);
    }

    /**
     *  void hideRemainingViews(int firstToHide, LinearLayout participantsLayout)
     *  given the number of participants, make the views visible or invisible according
     *  to the given number (e.g. for 4 participants, make the first 4 views visible and
     *  all the others invisible.
     **/
    void hideRemainingViews(int firstToHide, LinearLayout participantsLayout){
        //For each participant, hide all fields in participantView starting from the one given
        //as parameter
        try{
            //first, make sure the previous views are visible.
            for(int i=0; i<firstToHide*ParticipantView.getNumberOfFields(); i++){
                View child = participantsLayout.getChildAt(i);
                child.setVisibility(View.VISIBLE);
            }
            //then, make the rest invisible
            for(int i=firstToHide*ParticipantView.getNumberOfFields();
                i<MAX_PLAYERS*ParticipantView.getNumberOfFields(); i++){
                View child = participantsLayout.getChildAt(i);
                child.setVisibility(View.INVISIBLE);
            }}catch(ArrayIndexOutOfBoundsException exception){
                //Some method is using invalid index values as participant numbers.
                numberOfParticipants = MAX_PLAYERS;
        }
    }

    /**
     *  void saveParticipants(LinearLayout participantsLayout)
     *  use the data stored in the views to populate the Person objects with names and
     *  e-mails to prepare them for sorting.
     **/
    public void saveParticipants(View view){
        //find scene's main layout and attach new views to it.
        LinearLayout participantsLayout = (LinearLayout)
                findViewById(R.id.number_of_participants_layout);
        saveParticipants(participantsLayout);
    }
    public void saveParticipants(LinearLayout participantsLayout){
        //for each pair of views, save participant name and e-mail.
        for(int i=0; i<numberOfParticipants*2; i++){
            EditText child = (EditText) participantsLayout.getChildAt(i);
            list.listOfParticipants[i/2].setName(child.getText().toString());
            i++;
            child = (EditText) participantsLayout.getChildAt(i);
            list.listOfParticipants[i/2].setEMail(child.getText().toString());
        }
    }

    public void morePeople(View view){
        if (numberOfParticipants < MAX_PLAYERS){
            //update and show number
            numberOfParticipants++;
            updateNumber();
        }
    }

    public void lessPeople(View view){
        if (numberOfParticipants > MIN_PLAYERS){
            //update and show number
            numberOfParticipants--;
            updateNumber();
        }
    }

    /**
     *  void updateNumber()
     *  called when the number of participants is changed by the user. Make the changes visible
     *  in the number of participants label and show/hide views to show only the current number
     *  of participants.
     **/
    public void updateNumber(){
        //find the label for the number of participants
        numberOfParticipantsLabel = (TextView) findViewById(R.id.number_of_participants_label);
        numberOfParticipantsLabel.setText(String.valueOf(numberOfParticipants));
        //find scene's main layout.
        LinearLayout participantsLayout = (LinearLayout)
                findViewById(R.id.number_of_participants_layout);
        //Make views that are greater than the number of people invisible
        hideRemainingViews(numberOfParticipants,participantsLayout);
    }
}
