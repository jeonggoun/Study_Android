package com.example.my01_helloworld;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    EditText etPhoneNum;
    Button btnCall;
    Button btnNew;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // xml에 디자인한 위젯을 찾는다.
        etPhoneNum = findViewById(R.id.editText);
        btnCall = findViewById(R.id.btnCall);

        // 찾은 위젯에 클릭리스너를 달아준다.
        btnCall.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String phoneNum = "tel: " + etPhoneNum.getText().toString();  //가져온 텍스트 phoneNum에 담는다

                Intent intent = new Intent(Intent.ACTION_DIAL, Uri.parse(phoneNum));
                startActivity(intent);
            }
        });

        btnNew = findViewById(R.id.btnNew);
        btnNew.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), SubActivity.class);
                startActivity(intent);
            }
        });
    }

    public void onBtn1Clicked(View view) { /*메소드 이름 회색 되면 메소드 없다는 것. 이름 틀렸거나.*/
        Toast.makeText(this, "버튼1이 클릭됨", Toast.LENGTH_SHORT).show();
    }

    public void onBtnNaverClicked(View view) {
//        Toast.makeText(this, "네이버 이동", Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://m.naver.com"));
        startActivity(intent);
    }
}