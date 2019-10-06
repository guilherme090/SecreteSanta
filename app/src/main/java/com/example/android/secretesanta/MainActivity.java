package com.example.android.secretesanta;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.transition.Explode;
import android.transition.Scene;
import android.transition.Transition;
import android.transition.TransitionManager;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    /**
     * Scene declaration for app in chronological order (activity_main is the first one)
     **/
    private Scene activity_main; //initial screen
    private Scene scene_name_email; //screen for adding names and e-mails

    /**
     * GUI elements in the app by scene
     **/
    //activity_main

    //scene_name_email

    /**
     * Data structures
     **/
    final int MIN_PLAYERS = 3; //it does not make sense to sort 2 people or less
    final int MAX_PLAYERS = 50; //do not allow more than this many people
    Person [] listOfParticipants = new Person[MAX_PLAYERS];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Assign app's scenes to what is in the .xml files
        activity_main = Scene.getSceneForLayout((ViewGroup)findViewById(R.id.sceneContainer),
                R.layout.activity_main,this);
        scene_name_email = Scene.getSceneForLayout((ViewGroup)findViewById(R.id.sceneContainer),
                R.layout.scene_name_email,this);
        activity_main.enter();
    }

    public void startApp(View view){
        Transition explode = new Explode();
        TransitionManager.go(scene_name_email, explode);
    }
}
