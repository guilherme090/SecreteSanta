package com.example.android.secretesanta;

import android.content.Context;
import android.graphics.Color;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

class ParticipantView {
    private Context ctx;

    ParticipantView(Context ctx){
        this.ctx = ctx;
    }

    //View for participant name
    EditText nameView(Context context, String text){
        final ViewGroup.LayoutParams lParams = new ViewGroup.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT,ViewGroup.LayoutParams.WRAP_CONTENT);
        final EditText nView = new EditText(context);
        nView.setLayoutParams(lParams);
        nView.setTextSize(15);
        nView.setTextColor(Color.rgb(255,255,255));
        nView.setText(text);
        nView.setMaxEms(10);
        return nView;
    }

    //View for participant email
    TextView emailView(Context context, String text){
        final ViewGroup.LayoutParams lParams = new ViewGroup.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT,ViewGroup.LayoutParams.WRAP_CONTENT);
        final TextView eView = new TextView(context);
        eView.setLayoutParams(lParams);
        eView.setTextSize(13);
        eView.setTextColor(Color.rgb(255,255,255));
        eView.setText(text);
        eView.setMaxEms(15);
        return eView;
    }
}
