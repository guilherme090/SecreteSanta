package com.example.android.secretesanta;

import android.content.Context;
import android.graphics.Color;
import android.view.ViewGroup;
import android.widget.TextView;

class ParticipantView {
    private Context ctx;

    ParticipantView(Context ctx){
        this.ctx = ctx;
    }

    //View for participant name
    TextView nameView(Context context, String text){
        final ViewGroup.LayoutParams lParams = new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,ViewGroup.LayoutParams.WRAP_CONTENT);
        final TextView nView = new TextView(context);
        nView.setLayoutParams(lParams);
        nView.setTextSize(13);
        nView.setTextColor(Color.rgb(255,255,255));
        nView.setText(text);
        nView.setMaxEms(15);
        return nView;
    }

    //View for participant email
    TextView emailView(Context context, String text){
        final ViewGroup.LayoutParams lParams = new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,ViewGroup.LayoutParams.WRAP_CONTENT);
        final TextView eView = new TextView(context);
        eView.setLayoutParams(lParams);
        eView.setTextSize(13);
        eView.setTextColor(Color.rgb(255,255,255));
        eView.setText(text);
        eView.setMaxEms(15);
        return eView;
    }
}
