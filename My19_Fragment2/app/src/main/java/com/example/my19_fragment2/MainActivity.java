package com.example.my19_fragment2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    ListFragment listFragment;
    ViewerFragment viewerFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //getSupportFragmentManager() → 너무 길어서 변수 manager에 넣어서 사용
        FragmentManager manager = getSupportFragmentManager();

        listFragment = (ListFragment) manager.findFragmentById(R.id.listFragment);
        viewerFragment = (ViewerFragment) manager.findFragmentById(R.id.viewerFragment);
    }

    // 프래그먼트에서 접근할 수 있도록 만든 메소드
//    public void onImageSelected(int state){
//        viewerFragment.ImgChange(state);
    //resId 사용하면 ViewerFragment.java에서 if문 사용할 필요 없이 알아서 바꿔줌
    public void onImageSelected(int resId){
        viewerFragment.ImgChange(resId);
    }

}