package com.example.wiroon.test1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class login extends AppCompatActivity {
    private EditText edt_username, edt_password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        edt_username = findViewById(R.id.edt_username);
        edt_password = findViewById(R.id.edt_password);

        Button btn = findViewById(R.id.btn_signin);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try{
                    String user = "admin";
                    String pass = "1234";
                    if (user.equals( edt_username.getText().toString() )  && pass.equals(  edt_password.getText().toString() ) ){
//                        Toast.makeText(login.this,"Yeah!!", Toast.LENGTH_SHORT).show();

                        Intent intent = new Intent(login.this, MainActivity.class);
                        startActivity(intent);
                    }else{
                        Toast.makeText(login.this,"Try Agin!!", Toast.LENGTH_SHORT).show();
                    }
                }catch (Exception ex){
                    ex.printStackTrace();
                }
            }
        });
    }
}
