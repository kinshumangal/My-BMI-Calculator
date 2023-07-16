package com.sasken.mybmicalculater;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.room.Room;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.media.Image;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupMenu;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import com.sasken.mybmicalculater.database.UserDao;
import com.sasken.mybmicalculater.database.UserDatabase;
import com.sasken.mybmicalculater.database.UserEntity;

import java.util.Objects;

public class HomeActivity extends AppCompatActivity {

    EditText height, weight, age;
    ImageView weightMinus, weightPlus, ageMinus, agePlus;
    Button calculateBMI;
    TextView userNameTxt;
    SeekBar seekBar;
    LinearLayout linearLayout1, linearLayout2;

    int intWeight = 55;
    int int_age = 18;
    int currentProgress;
    String int_progress = "170";
    String type_of_user = "0";
    String weight2 = "50";
    String age2 = "22";

    ImageView menuI;
    public  String userName;

//    UserDatabase userDatabase;

    static final String DB_NAME = "user-database";

//    UserEntity userEntity;
    @SuppressLint({"MissingInflatedId", "WrongViewCast", "SetTextI18n"})
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        Objects.requireNonNull(getSupportActionBar()).hide();

        userNameTxt = findViewById(R.id.userName);

        linearLayout1 = findViewById(R.id.linearLayout1);
        linearLayout2 = findViewById(R.id.linearlayout2);

        height = findViewById(R.id.hight);
        weight = findViewById(R.id.weight);
        age = findViewById(R.id.age);

        seekBar = findViewById(R.id.seekBar);

        weightMinus = findViewById(R.id.weightMinus);
        weightPlus = findViewById(R.id.weigtPlus);

        ageMinus = findViewById(R.id.ageMinus);
        agePlus = findViewById(R.id.agePlus);

        calculateBMI = findViewById(R.id.calculateBMI);

        menuI = findViewById(R.id.menu);

//        userDatabase = Room.databaseBuilder(getApplicationContext(), UserDatabase.class, DB_NAME).build();

        menuI.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Toast.makeText(HomeActivity.this, "Menu", Toast.LENGTH_SHORT).show();
                PopupMenu popupMenu = new PopupMenu(getApplicationContext(), v);
                MenuInflater inflater = popupMenu.getMenuInflater();
                inflater.inflate(R.menu.my_menu, popupMenu.getMenu());
                popupMenu.show();

            }
        });
        linearLayout1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                linearLayout1.setBackground(ContextCompat.getDrawable(getApplicationContext(), R.drawable.male_female_foucs));
                linearLayout2.setBackground(ContextCompat.getDrawable(getApplicationContext(), R.drawable.male_female_nofoucs));
                type_of_user = "Man";
            }
        });

        linearLayout2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                linearLayout1.setBackground(ContextCompat.getDrawable(getApplicationContext(), R.drawable.male_female_nofoucs));
                linearLayout2.setBackground(ContextCompat.getDrawable(getApplicationContext(), R.drawable.male_female_foucs));
                type_of_user = "Woman";
            }
        });

        seekBar.setMax(300);
        seekBar.setProgress(170);

        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                currentProgress = progress;
                int_progress = String.valueOf(currentProgress);
                height.setText(int_progress);

            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        agePlus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int_age++;
                age2 = String.valueOf(int_age);
                age.setText(age2);
            }
        });

        weightPlus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intWeight++;
                weight2 = String.valueOf(intWeight);
                weight.setText(weight2);
            }
        });

        ageMinus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(int_age>0) int_age--;
                age2 = String.valueOf(int_age);
                age.setText(age2);
            }
        });

        weightMinus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(intWeight>0) intWeight--;
                weight2 = String.valueOf(intWeight);
                weight.setText(weight2);
            }
        });

        Intent intent = getIntent();
        userName = intent.getStringExtra("userName");
        userNameTxt.setText("Hey ! " + userName);


        calculateBMI.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Checking

//                UserDao userDao = userDatabase.userDao();

//                new Thread(new Runnable() {
//                    @Override
//                    public void run() {
//                        userEntity = new UserEntity();
//                        userEntity.setName(userName);
//                        userEntity.setAge(int_age);
//                        userEntity.setGender(type_of_user);
//                        userEntity.setWeight(intWeight);
//                        userEntity.setHeight(Integer.parseInt(int_progress));
//                        Log.d("TAG", "Data update");
//
//                    }
//                }).start();


                if(type_of_user.equalsIgnoreCase("0")){
                    Toast.makeText(HomeActivity.this, "Select Your Gender First", Toast.LENGTH_SHORT).show();
                } else if (int_progress.equalsIgnoreCase("0")) {
                    Toast.makeText(HomeActivity.this, "Select Your Height First", Toast.LENGTH_SHORT).show();
                } else if (int_age <= 0) {
                    Toast.makeText(HomeActivity.this, "Age is incorrect", Toast.LENGTH_SHORT).show();
                } else if (intWeight <= 0) {
                    Toast.makeText(HomeActivity.this, "Weight is incorrect", Toast.LENGTH_SHORT).show();
                }else {
                    Intent intent1 = new Intent(getApplicationContext(), ResultBMI.class);
                    intent1.putExtra("gender", type_of_user);
                    intent1.putExtra("height", int_progress);
                    intent1.putExtra("age", age2);
                    intent1.putExtra("weight", weight2);
                    intent1.putExtra("userName", userName);
                    startActivity(intent1);

                    overridePendingTransition(R.anim.left_side_in, R.anim.right_side_out);
                }
            }
        });
    }


}