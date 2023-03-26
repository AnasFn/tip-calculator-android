package com.example.tipjava;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.TextView;

public class ResultActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        TextView tv_result= findViewById(R.id.tv_result);
        Bundle bundle=getIntent().getExtras();
        float result = bundle.getFloat("result");
        tv_result.setText(""+result);

        Animation a = AnimationUtils.loadAnimation(this, R.anim.result_anim);
        tv_result.startAnimation(a);

        //========================================
       //hello

    }
}