package com.example.my07_alllayout;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    Button btnChange;
    Button btnScroll;
    ImageView imageView1, imageView2, imageView3, scrollImg1, scrollImg2;
    int selImg = 2;
    int scrollImg = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imageView1 = findViewById(R.id.imageView1);
        imageView2 = findViewById(R.id.imageView2);
        imageView3 = findViewById(R.id.imageView3);

        imageView1.setVisibility(View.VISIBLE);
        imageView2.setVisibility(View.GONE);
        imageView3.setVisibility(View.GONE);

        btnChange = findViewById(R.id.btnChange);
        btnScroll = findViewById(R.id.btnScroll);

        btnChange.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(selImg == 1){
                    imageView1.setVisibility(View.VISIBLE);
                    imageView2.setVisibility(View.GONE);
                    imageView3.setVisibility(View.GONE);
                    selImg = 2;
                }else if(selImg == 2){
                    imageView1.setVisibility(View.GONE);
                    imageView2.setVisibility(View.VISIBLE);
                    imageView3.setVisibility(View.GONE);
                    selImg = 3;
                }else if (selImg == 3) {
                    imageView1.setVisibility(View.GONE);
                    imageView2.setVisibility(View.GONE);
                    imageView3.setVisibility(View.VISIBLE);
                    selImg = 1;
                }
            }
        });

        scrollImg1 = findViewById(R.id.scrollImg1);
        scrollImg2 = findViewById(R.id.scrollImg2);


        btnScroll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(scrollImg == 1){
                    scrollImg1.setVisibility(View.VISIBLE);
                    scrollImg2.setVisibility(View.GONE);
                    scrollImg = 2;
                }else if(scrollImg == 2){
                    scrollImg1.setVisibility(View.GONE);
                    scrollImg2.setVisibility(View.VISIBLE);
                    scrollImg = 1;
                }
            }
        });

    }
}