package com.sasken.mybmicalculater;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class WelcomeScreen extends AppCompatActivity {

    EditText user_name;
    Button next_btn;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome_screen);

        if (getSupportActionBar() != null) {
            getSupportActionBar().hide();
        }

        user_name = findViewById(R.id.user_name);
        next_btn = findViewById(R.id.next_button);

        next_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent1 = new Intent(getApplicationContext(), SelectGender.class);
                Intent intent2 = new Intent(getApplicationContext(), HomeActivity.class);

                String userName = user_name.getText().toString();

                intent2.putExtra("userName", userName);

                if(user_name.getText().toString().trim().equalsIgnoreCase("")){
                    user_name.setError("This field can not be blank");
                }else{
                    startActivity(intent1);
                    startActivity(intent2);
                    overridePendingTransition(R.anim.left_side_in, R.anim.right_side_out);
                }
            }
        });
    }
}