package com.example.my05_scrollview;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {
    //선언
    ImageView imageView;
    Button btnImg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //찾기
        imageView = findViewById(R.id.imageView);
        btnImg = findViewById(R.id.btnImg);

        //클릭리스너
        btnImg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Drawble myImage = getResources().getDrawable(R.drawable.image01);
                R.drawable.image01 myImage ? imageView.setImageResource(R.drawable.image01);
                imageView.setImageResource(R.drawable.image02);
            }
        });
    }
}