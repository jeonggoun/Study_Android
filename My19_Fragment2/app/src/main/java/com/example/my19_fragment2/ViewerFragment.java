package com.example.my19_fragment2;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class ViewerFragment extends Fragment {

    MainActivity activity;
    ImageView imageView;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        ViewGroup rootView = (ViewGroup) inflater.inflate(R.layout.viewer_fragment, container, false);
            activity = (MainActivity) getActivity();
            imageView = rootView.findViewById(R.id.imageView);

        return rootView;
    }

//    public void ImgChange(int state){
//        if(state == 1) {
//            imageView.setImageResource(R.drawable.dream01);
//        }else if(state ==2){
//            imageView.setImageResource(R.drawable.dream02);
//        }
    //resId 사용하면 ViewerFragment.java에서 if문 사용할 필요 없이 알아서 바꿔줌
    public void ImgChange(int resId){
        imageView.setImageResource(resId);
    }
}
