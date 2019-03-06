package com.example.karim.oge_v1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Account extends AppCompatActivity {

    Button vhod;
    EditText editText, editText2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_account);
        getSupportActionBar().setTitle("Вход");


        vhod = findViewById(R.id.vhod);
        editText = findViewById(R.id.editText);
        editText2 = findViewById(R.id.editText2);

        vhod.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(editText.getText().toString().equals("89776653654") && editText2.getText().toString().equals("1234")){
                    Intent intent = new Intent(Account.this, ReadyAcc.class);
                    startActivity(intent);
                } else {
                    return;
                }
            }
        });

        ;
    }
}
