package com.example.ignite19;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.bitmap.CircleCrop;

public class splash extends AppCompatActivity {
private static int splashtimeout=4000;

String s1,s2,s3,s4;
    private ImageView loader1,img1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        getSupportActionBar().hide();
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS,
                WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS);
        loader1=findViewById(R.id.gif2);
        loader1.setVisibility(View.INVISIBLE);
        Intent intent1=getIntent();
        s1=intent1.getStringExtra("UUID");
        s2=intent1.getStringExtra("username");
        s3=intent1.getStringExtra("title");
        s4=intent1.getStringExtra("content");
        img1 = findViewById(R.id.backgif);
        Glide.with(getApplicationContext()).load(R.drawable.universe).into(img1);

        loader1 = findViewById(R.id.gif2);
        Glide.with(getApplicationContext()).load(R.drawable.flameloader).transform(new CircleCrop()).into(loader1);

        loader1.setVisibility(View.INVISIBLE);
        loader1.setVisibility(View.VISIBLE);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent=new Intent(splash.this,MainActivity.class);
                intent.putExtra("UUID",s1);
                intent.putExtra("username",s2);
                intent.putExtra("title",s3);
                intent.putExtra("content",s4);
                startActivity(intent);
                finish();

            }
        },splashtimeout);
    }
}
