package com.example.tipjava;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;

import com.example.tipjava.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding binding;
    long i;
    float result;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=ActivityMainBinding.inflate(getLayoutInflater());
        View view= binding.getRoot();
        setContentView(view);



        binding.button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                MediaPlayer mediaPlayer = MediaPlayer.create(MainActivity.this, R.raw.cash);
                mediaPlayer.start(); // no need to call prepare(); create() does that for you

               float bill= Long.parseLong(binding.editText.getText().toString()) ;

               if (binding.radio20.isChecked()){
                   result= (bill * 20)/ 100;
                   gotoResult(result);

               } else if (binding.radio16.isChecked()) {
                   result= (bill * 16)/ 100;
                   gotoResult(result);

               }else if (binding.rdaio10.isChecked()){

                   result= (bill * 10)/ 100;;
                   gotoResult(result);
               }


            }
        });





    }

    void gotoResult(float result){
        Intent intent= new Intent(MainActivity.this, ResultActivity.class);
        intent.putExtra("result", result);
        startActivity(intent);

    }




}