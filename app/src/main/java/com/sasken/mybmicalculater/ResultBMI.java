package com.sasken.mybmicalculater;

import static android.graphics.Color.YELLOW;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.Objects;

public class ResultBMI extends AppCompatActivity {

    Animation tTb_anim, bTt_anim;
    ImageView ansImg;
    Button recalculateBMI;
    TextView bmiResult, bmiCategory, bmiGender;
    Intent intent;
    String m_bmi;
    float int_bmi;
    String height;
    String weight;
    float int_height, int_weight;
    LinearLayout bmiBackground;

    String userName;
    @SuppressLint({"MissingInflatedId", "ResourceAsColor", "ResourceType", "UseCompatLoadingForDrawables", "SetTextI18n"})
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result_bmi);
        Objects.requireNonNull(getSupportActionBar()).hide();

//        ActionBar actionBar = getSupportActionBar();

        // showing the back button in action bar
//        actionBar.setDisplayHomeAsUpEnabled(true);
//
        intent = getIntent();
        ansImg = findViewById(R.id.ansImg);
        bmiBackground = findViewById(R.id.bmiBackground);

        tTb_anim = AnimationUtils.loadAnimation(this, R.anim.top_to_bottom_animation);
        bTt_anim = AnimationUtils.loadAnimation(this, R.anim.bottom_to_top_animation);

        recalculateBMI = findViewById(R.id.RecalculateBMI);

        ansImg.setAnimation(tTb_anim);

        bmiGender = findViewById(R.id.bmiGender);
        bmiCategory = findViewById(R.id.bmiCategory);
        bmiResult = findViewById(R.id.bmiResult);

        userName = intent.getStringExtra("userName");

        height = intent.getStringExtra("height");
        weight = intent.getStringExtra("weight");

        height = intent.getStringExtra("height");
        weight = intent.getStringExtra("weight");

        int_height = Float.parseFloat(height);
        int_weight = Float.parseFloat(weight);

        int_height = int_height / 100;
        int_bmi = int_weight / (int_height * int_height);

        m_bmi = Float.toString(int_bmi);

        if(int_bmi<18.5){
            bmiCategory.setText("YOU ARE UNDERWEIGHT");
            bmiBackground.setBackground(ContextCompat.getDrawable(this, R.drawable.gradient_warning));
            recalculateBMI.setBackgroundColor(YELLOW);
            ansImg.setImageResource(R.drawable.diet);
        } else if (int_bmi >= 18.5 && int_bmi < 24.9) {
            bmiCategory.setText("YOU ARE IDEAL CONDITION");
            bmiBackground.setBackground(ContextCompat.getDrawable(this, R.drawable.gradient_splash_screen));
            recalculateBMI.setBackgroundColor(getResources().getColor(R.color.light_blue));
            ansImg.setImageResource(R.drawable.muscleman);
        }else if (int_bmi >= 24.9 && int_bmi < 30) {
            bmiCategory.setText("YOU ARE OVERWEIGHT");
            bmiBackground.setBackgroundDrawable(ContextCompat.getDrawable(this, R.drawable.gradient_error));
            recalculateBMI.setBackgroundColor(getResources().getColor(R.color.error1));
            ansImg.setImageResource(R.drawable.overweight);
        } else {
            bmiCategory.setText("YOU ARE SUFFERING FROM OBESITY");
            bmiBackground.setBackgroundDrawable(ContextCompat.getDrawable(this, R.drawable.gradient_error));
            recalculateBMI.setBackgroundColor(getResources().getColor(R.color.error3));
            ansImg.setImageResource(R.drawable.obesity);
        }

        bmiGender.setText(intent.getStringExtra("gender"));
        bmiResult.setText(m_bmi);

        recalculateBMI.setOnClickListener(v ->
        {
            Intent intent = new Intent(getApplicationContext(), HomeActivity.class);
            startActivity(intent);
        });
    }
}