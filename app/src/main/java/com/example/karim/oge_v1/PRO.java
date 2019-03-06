package com.example.karim.oge_v1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class PRO extends AppCompatActivity {

    Button back, pro;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pro);
        getSupportActionBar().setTitle("PRO");

        back = findViewById(R.id.back);
        pro = findViewById(R.id.pro);

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(PRO.this, Settings.class);
                startActivity(intent);
            }
        });
        pro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(PRO.this, Free.class);
                startActivity(intent);
            }
        });



    }
}
