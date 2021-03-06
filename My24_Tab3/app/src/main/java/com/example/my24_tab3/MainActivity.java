package com.example.my24_tab3;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.util.Log;

import com.google.android.material.tabs.TabLayout;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "main: MainActivity";

    Toolbar toolbar;
    TabLayout tabs;
    Fragment fragment1;
    Fragment fragment2;
    Fragment fragment3;

    Fragment selFragment = null;

    Bundle mBundle = null; /*main에 있는 Bundle*/

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // 액션바가 보이지 않게 하기 위해서 먼저 project에 theme로 가서 NoActionBar로 수정한다.

        // 내가 만든 툴바를 액션바로 지정한다.
        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        // 기존 타이틀이 보이지 않게 한다
        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayShowTitleEnabled(false);

        fragment1 = new Fragment1();
        fragment2 = new Fragment2();
        fragment3 = new Fragment3();

        // 먼저 프래그먼트1을 프레임레이아웃에 초기화 시킨다.
        getSupportFragmentManager().beginTransaction().replace(R.id.contain,fragment1).commit();

        // 탭을 생성시킨다
        tabs = findViewById(R.id.tabs);
        tabs.addTab(tabs.newTab().setText("통화기록"));
        tabs.addTab(tabs.newTab().setText("스팸기록"));
        tabs.addTab(tabs.newTab().setText("연락처"));

        // 탭 레이아웃에 리스너(=이벤트, 클릭이벤트)를 달아준다
       tabs.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
           
            //탭이 선택됐을 때
            @Override
            public void onTabSelected(TabLayout.Tab tab) {  //선택한 탭에 대한 것이 넘어왔음
                // 선택된 탭의 인덱스 가져오기
                int position = tab.getPosition(); //0,1,2라는 값을 가져온다

                // 선택된 탭의 인덱스를 log에 띄운다
                Log.d(TAG, "onTabSelected: Position 선택된 탭 → " + position);

                // 어떤 탭이 선택됐냐에 따라 보여줄 화면
                if (position == 0){
                    selFragment = fragment1;
                }else if (position == 1){
                    selFragment = fragment2;
                }else if (position == 2) {
                    selFragment = fragment3;
                }//if~else
                getSupportFragmentManager().beginTransaction().replace(R.id.contain, selFragment).commit();
            }
            
            //탭이 선택되지 않았을 때
            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }
           
            // 탭이 재 선택됐을 때
            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
    }

    public void fragBtnClick(Bundle bundle){
        this.mBundle = bundle;  //fragment1이 보낸 걸 main이 받아 mBundle에 넣는다
    }

}