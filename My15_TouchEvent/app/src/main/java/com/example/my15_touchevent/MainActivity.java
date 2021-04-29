package com.example.my15_touchevent;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.GestureDetector;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ScrollView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    View view1, view2;
    ScrollView scrollView;
    TextView textView;
    GestureDetector detector;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        view1 = findViewById(R.id.view1);
        view2 = findViewById(R.id.view2);
        scrollView = findViewById(R.id.scrollView);
        textView = findViewById(R.id.textView);

        // 터치 리스너
        view1.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                int action = event.getAction(); // 터치한 것을 os에 의해 int형으로 알려줌
                float curX = event.getX();  // 현재 x의 위치
                float curY = event.getY();  // 현재 y의 위치

                if(action == MotionEvent.ACTION_DOWN){
                    printString("손가락 눌림" + curX + ", " + curY);
                }else if(action == MotionEvent.ACTION_MOVE){
                    printString("손가락 움직임" + curX + ", " + curY);
                }else if(action == MotionEvent.ACTION_UP){
                    printString("손가락 뗌" + curX + ", " + curY);
                }

                return true;    //false로 설정하면 실행되지 않음
            }//onTouch
        });//TouchListener

        view2.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                detector.onTouchEvent(event);

                return true;
            }
        });

        detector = new GestureDetector(this, new GestureDetector.OnGestureListener() { //new GestureDetector 하고 ctrl+p => 리스너 달아줘야 한다고 함
            // 화면이 눌렸을 때
            @Override
            public boolean onDown(MotionEvent e) {
                printString("onDown() 호출됨");
                return true;
            }

            // 화면이 눌렸다 떼어지는 경우
            @Override
            public void onShowPress(MotionEvent e) {
                printString("onShowPress() 호출됨");
            }

            // 화면이 한 손가락으로 눌렸다 떼어지는 경우
            @Override
            public boolean onSingleTapUp(MotionEvent e) {
                printString("onSingleTapUp() 호출됨");
                return true;
            }

            // 화면이 눌린 채 일정한 속도와 방향으로 움직였다 떼는 경우
            @Override
            public boolean onScroll(MotionEvent e1, MotionEvent e2, float distanceX, float distanceY) {
                printString("onScroll() 호출됨=>" + distanceX + ", " + distanceY);     //x, y 거리
                return true;
            }

            // 화면을 손가락으로 오랫동안 눌렀을 경우
           @Override
            public void onLongPress(MotionEvent e) {
               printString("onLongPress() 호출됨");
            }

            // 화면이 눌린 채 가속도를 붙여 손가락을 움직였다 떼는 경우
            @Override
            public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX, float velocityY) {
                printString("onFling() 호출됨 => " + velocityX + ", " + velocityY);    //x, y 속도
                return true;
            }
        });

    }//onCreate
    public void printString(String str){
        textView.append(str + "\n");    //계속 내려올 거니까
        
        scrollView.fullScroll(View.FOCUS_DOWN); //scroll 가장 아래로 내려오도록 설정
    }//printString

    //onKeyDown
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) { //event, keyCode 넘어옴. 넘어온 것과 내가 정의한 거 비교.
        if(keyCode == KeyEvent.KEYCODE_BACK) {    //BACK : 뒤로가기 버튼 누를 때
            printString("시스템에서 [BACK] 버튼이 눌렸습니다.");
            return true;
        }else if(keyCode == KeyEvent.KEYCODE_VOLUME_UP) {
            printString("시스템에서 [VOLUME_UP] 버튼이 눌렸습니다.");
            return true;
        }else if(keyCode == KeyEvent.KEYCODE_VOLUME_DOWN){
            printString("시스템에서 [VOLUME_DOWN] 버튼이 눌렸습니다.");
            return true;
        }

        return false;
    }//onKeyDown
}