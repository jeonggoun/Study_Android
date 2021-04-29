package com.example.my12_lifecycle;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "main:MainActivity";
//    logt 누르면 태그 만들어진다. MainActivity 앞에만 main: 붙이면 된다.
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Log.d(TAG, "onCreate: 호출됨");
        //  logd: debug의 약자. 각 메소드에 붙일 것.

        // 새 창 띄우기
        findViewById(R.id.btnNew).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), SubActivity.class);
                startActivity(intent);
            }//onClick()
        });//setOnClickListener()

    }//onCreate()

    @Override
    protected void onStart() {
        super.onStart();
        Log.d(TAG, "onStart: 호출됨");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d(TAG, "onStop: 호출됨");
        savePersonal();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d(TAG, "onDestroy: 호출됨");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d(TAG, "onPause: 호출됨");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d(TAG, "onResume: 호출됨");
        loadPersonal();
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d(TAG, "onRestart: 호출됨");
    }

    // 핸드폰 내부 저장공간에
    private void savePersonal(){
        SharedPreferences pref = getSharedPreferences("personal", Activity.MODE_PRIVATE);//MODE_PRIVATE:개인용도로 쓰겠다?
        SharedPreferences.Editor editor = pref.edit();
        editor.putString("id", "eyedial");
        editor.putInt("pw", 1234);
        editor.commit();
        Log.d(TAG, "savePersonal: eyedial 과 1234과 저장됨");
    }

    // 핸드폰 내부 저장장간에서 데이터 가져오기
    private void loadPersonal(){
        SharedPreferences pref = getSharedPreferences("personal", Activity.MODE_PRIVATE);

        if(pref != null){
            String id = pref.getString("id", "CSS");
            int pw = pref.getInt("pw", 0);

            Log.d(TAG, "loadPersonal: 가져온 값은 : " + id + ", " + pw);
        }
    }
}