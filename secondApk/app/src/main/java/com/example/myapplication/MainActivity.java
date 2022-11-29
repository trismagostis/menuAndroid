package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.ConstraintSet;

import android.graphics.Color;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Switch;
import android.widget.TextView;

import com.example.myapplication.R;

public class MainActivity extends AppCompatActivity {
    public int index=1;

    private int getImg(int index){
        switch (index) {
            case 1: return R.drawable.luzkot;
            case 2: return R.drawable.chorkot;
            case 3: return R.drawable.zabojkot;
            default: return -1;
        }
    }

    public static boolean isNumeric(String strNum) {
        if (strNum == null) {
            return false;
        }
        try {
            int d = Integer.parseInt(strNum);
        } catch (NumberFormatException nfe) {
            return false;
        }
        return true;
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button nextBtn=(Button) findViewById(R.id.nextBtn);
        Button prevBtn=(Button) findViewById(R.id.prevBtn);
        EditText catNumber=(EditText) findViewById(R.id.catEditText);
        ImageView image = (ImageView) findViewById(R.id.imageCat);
        Switch colorSwitch=(Switch) findViewById(R.id.colorSwitch);
        View form = (View) findViewById(R.id.form);
        nextBtn.setOnClickListener(view -> {
            Log.i("Info","button pressed");

            index++;
            if (index>3){
                index=1;
            }
            image.setImageResource(getImg(index));


        });

        prevBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                index--;
                if (index<1){
                    index=3;
                }
                image.setImageResource(getImg(index));

            }
        });

        catNumber.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                String catIndex=(catNumber.getText().toString());
                if (isNumeric(catIndex)) {
                    index = Integer.parseInt(catIndex);
                    if (index<4 && index>0) {
                        image.setImageResource(getImg(index));
                        catNumber.setText("");
                    }
                }

            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });

        colorSwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (b){
                    form.setBackgroundColor(0xff00ff00);
                }
                else {
                    form.setBackgroundColor(0xff0000ff);
                }
            }
        });
    }
}