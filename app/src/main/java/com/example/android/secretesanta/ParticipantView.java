package com.example.android.secretesanta;

import android.content.Context;
import android.graphics.Color;
import android.text.InputType;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.ColorInt;

class ParticipantView {
    private Context ctx;
    static private int numberOfFields = 2;

    ParticipantView(Context ctx){
        this.ctx = ctx;
    }

    //View for participant name
    EditText nameView(Context context, String hint){
        final ViewGroup.LayoutParams lParams = new ViewGroup.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT,ViewGroup.LayoutParams.WRAP_CONTENT);
        final EditText nView = new EditText(context);
        nView.setLayoutParams(lParams);
        nView.setInputType(InputType.TYPE_TEXT_VARIATION_PERSON_NAME);
        nView.setTextSize(15);
        nView.setTextColor(Color.rgb(221,170,0)); //same color as gold button
        nView.setText("");
        nView.setHint(hint);
        nView.setHintTextColor(Color.rgb(220,220,220)); //light grey
        nView.setMaxEms(10);
        return nView;
    }

    //View for participant email
    EditText emailView(Context context, String hint){
        final ViewGroup.LayoutParams lParams = new ViewGroup.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT,ViewGroup.LayoutParams.WRAP_CONTENT);
        final EditText eView = new EditText(context);
        eView.setLayoutParams(lParams);
        eView.setInputType(InputType.TYPE_TEXT_VARIATION_WEB_EMAIL_ADDRESS);
        eView.setTextSize(15);
        eView.setTextColor(Color.rgb(255,255,255));
        eView.setText("");
        eView.setHint(hint);
        eView.setHintTextColor(Color.rgb(200,200,200)); //light grey
        eView.setMaxEms(10);
        return eView;
    }

    static public int getNumberOfFields(){
        return numberOfFields;
    }

}
