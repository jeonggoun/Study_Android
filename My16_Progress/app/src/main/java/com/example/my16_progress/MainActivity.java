package com.example.my16_progress;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "main:MainActivity";   //logt로 자동완성

    //프로그레스 바, 텍스트뷰 선언
    ProgressBar progressBar;
    TextView editText;
    ProgressDialog dialog;  //button2에서 쓸 것
    SeekBar seekBar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //프로그레스 바, 텍스트뷰 찾기
        progressBar = findViewById(R.id.progressBar);
        editText = findViewById(R.id.editText);

        //프로그레스 바 초기화. 정해진 값을 사용하는지 => 아니기 때문에 false 부여
        progressBar.setIndeterminate(false);
        progressBar.setMax(100);   //100까지만 하겠다
        progressBar.setProgress(20);  //얼마나 진척할 것인지

        //찾고 클릭리스너
        findViewById(R.id.button1).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //editText에 있는 값 가져오기
                if(editText.getText().toString().length() > 0) {
                    int value = Integer.parseInt(editText.getText().toString());    //변수명.getText() => 변수에 있는 text 가져온다. => int형으로 캐스팅
                    progressBar.setProgress(value);
                }else{
                    Toast.makeText(MainActivity.this, "숫자를 입력하세요", Toast.LENGTH_SHORT).show();  //Toa만 치고 자동완성. text만 작성
                }//onClick 내 if~else
            }//onClick
        });//setOnClickListener

        findViewById(R.id.button2).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog = new ProgressDialog(MainActivity.this);
                dialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);
                dialog.setMessage("데이터를 확인하는 중입니다 ...");
                dialog.setCanceledOnTouchOutside(false); //바깥을 클릭하더라도 취소되지 않도록 => back 해야 사라짐
                dialog.show();
            }
        });

        //DB 연동되면 다이얼로그 닫기
        findViewById(R.id.button3).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(dialog != null) {
                    dialog.dismiss();
                }
            }
        });

        //seekBar
        seekBar = findViewById(R.id.seekBar);
        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            //값이 변했을 때
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {    //int progress => 내가 변경한 값, 유저가 변경했는

                //editText.setText(progress); => int형인 progress를 String으로 바꿔줘야 한다.
                //editText.setText("" + progress + ""); //따옴표로 String 바꾸는 방법
                editText.setText(String.valueOf(progress));
                Log.d(TAG, "onProgressChanged: " + fromUser);

            }

            //터치했을 때
            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            //손 떼었을 때
            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

    }//onCreate
}//Main