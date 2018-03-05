package com.prolificinteractive.materialcalendarview.sample;

/**
 * Created by Sun_Sun on 2017-10-19.
 */

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Toast;

public class page_2 extends android.support.v4.app.Fragment implements View.OnClickListener{

    Button bt1;
    Bundle save;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public void onClick(View v){
        Toast.makeText(getContext(), "Click_page_2", Toast.LENGTH_SHORT).show();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        save = savedInstanceState;
        LinearLayout linearLayout = (LinearLayout)inflater.inflate(R.layout.page, container,false);

        final LinearLayout background = (LinearLayout)linearLayout.findViewById(R.id.background);
        background.setBackgroundResource(R.drawable.slide2);

        background.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getContext(), "HaHa", Toast.LENGTH_SHORT).show();
            }
        });

        linearLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getContext(), "HaHa", Toast.LENGTH_SHORT).show();
            }
        });

        return linearLayout;
    }

}
