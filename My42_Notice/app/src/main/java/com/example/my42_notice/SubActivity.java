package com.example.my42_notice;

import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

public class SubActivity extends AppCompatActivity {

    /*Button btnReturn; //전역변수 선언*/

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sub);

        /*btnReturn = findViewById(R.id.btnReturn); //id 찾아온다
        btnReturn.setOnClickListener(new View.OnClickListener() {   //클릭리스너 달아준다
            @Override
            public void onClick(View v) {

            }
        });*/

        findViewById(R.id.btnReturn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish(); //서브창 닫으면 메인창 나오기 때문에 finish만 하면 된다.
            }
        });

    }
}