package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    public String[] itemList={"Bob","Bil","Sam"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //attempts to lunch an activity within our application

        Button listaBtn=(Button) findViewById(R.id.listaBtn);
        listaBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent startIntent = new Intent(getApplicationContext(), ListaActivity.class);
                startIntent.putExtra("com.example.myapplication.transferredString",itemList);
                startActivity(startIntent);
            }
        });

    }
}