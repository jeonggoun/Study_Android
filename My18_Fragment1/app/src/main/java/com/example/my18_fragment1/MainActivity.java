package com.example.my18_fragment1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    MainFragment mainFragment;
    SubFragment subFragment;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // getFragmentManager();            하위버전도 지원
        // getSupportFragmentManager();     상위버전만 지원. 이거 사용

//        mainFragment = (MainFragment) getSupportFragmentManager()
//                        .findFragmentById(R.id.mainFragment);  //Fragment찾으려면 FragmentManager 도움 필요, 캐스팅
        mainFragment = new MainFragment();

        subFragment = new SubFragment();



        // 메인 화면에 프래그먼트 초기화 시키기
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.contain, subFragment).commit();

    }

    //프래그먼트에서 접근할 수 있게 만든 메소드
    public void onFragmentChange(int statd){
        if(statd == 1) {
            //화면을 서브프래그먼트로 교체 : 메인프래그먼트 버튼 툴림
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.contain, subFragment).commit();
        }else if(statd == 2){
            //화면을 메인프래그먼트로 교체 : 서브프래그먼트 버튼 눌림
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.contain, mainFragment).commit();
        }

    }
}