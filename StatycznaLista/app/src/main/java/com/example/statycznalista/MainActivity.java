package com.example.statycznalista;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    Button listaBtn=(Button) findViewById(R.id.listaBtn);
        listaBtn.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            Intent startIntent = new Intent(getApplicationContext(), ListaActivity.class);
            startIntent.putExtra("com.example.statycznalista.transferredString",itemList);
            startActivity(startIntent);
        }
    });

}