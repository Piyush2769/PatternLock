package com.example.piyush.patternlock;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Handler handler=new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {

                SharedPreferences sharedPreferences= getSharedPreferences("PREFS",0);
                String password=sharedPreferences.getString("password","0");
                if(password.equals("0"))
                {
                    Intent intent=new Intent(MainActivity.this,CreatePasswordActivity.class);
                    startActivity(intent);
                    finish();
                }
                else
                {
                    Intent intent=new Intent(MainActivity.this,InputPasswordActivity.class);
                    startActivity(intent);
                    finish();
                }

            }
        },2000);
    }
}
