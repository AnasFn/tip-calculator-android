package com.example.tipjava;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.tipjava.databinding.ActivityMainBinding;
import com.google.android.material.snackbar.Snackbar;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding binding;
    long i;
    float result;
    float total;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=ActivityMainBinding.inflate(getLayoutInflater());
        View view= binding.getRoot();
        setContentView(view);



        binding.button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

               if (!binding.editText.getText().toString().isEmpty() || binding.editText.getText().toString().length() >=1){

                   float bill= Long.parseLong(binding.editText.getText().toString()) ;



                   if (binding.radio20.isChecked()){
                       result= (bill * 20)/ 100;
                       total=bill+result; MediaPlayer mediaPlayer = MediaPlayer.create(MainActivity.this, R.raw.cash);
//                       mediaPlayer.start();
//
                       gotoResult(total);

                   } else if (binding.radio15.isChecked()) {
                       result= (bill * 15)/ 100;
                       total=bill+result;
//                       MediaPlayer mediaPlayer = MediaPlayer.create(MainActivity.this, R.raw.cash);
//                       mediaPlayer.start();
                       gotoResult(total);

                   }else if (binding.rdaio10.isChecked()){

                       result= (bill * 10)/ 100;;
                       total=bill+result;
//                       MediaPlayer mediaPlayer = MediaPlayer.create(MainActivity.this, R.raw.cash);
//                       mediaPlayer.start();
                       gotoResult(total);

                   }
                   else {
                       Toast.makeText(MainActivity.this, "slect percent", Toast.LENGTH_SHORT).show();
                   }
               }else Toast.makeText(MainActivity.this, "amount is empty", Toast.LENGTH_SHORT).show();




            }
        });





    }

    void gotoResult(float result){
        MediaPlayer mediaPlayer = MediaPlayer.create(MainActivity.this, R.raw.cash);
        mediaPlayer.start();
        Intent intent= new Intent(MainActivity.this, ResultActivity.class);
        intent.putExtra("result", result);
        startActivity(intent);

    }




}