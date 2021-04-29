package com.example.my24_tab3;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.google.android.material.tabs.TabLayout;

public class Fragment3 extends Fragment {
    MainActivity activity;
    String sendDate, receiveData;
    Person person3;

    TextView textView3;
    Button button3;

    // 화면이 붙을 때 초기화시키기
    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);

        // 프래그먼트가 속한 액티비티 가져옴
        activity = (MainActivity) getActivity();

        // 프래그먼트3에서 보낼 문자열과 객체
        sendDate = "프래그먼트3에서 보낸 데이터입니다.";
        person3 = new Person("JEON", 63);

        // 프래그먼트2에서 받을 문자열 변수 초기화
        receiveData = "";
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        ViewGroup viewGroup = (ViewGroup) inflater.inflate(R.layout.fragment3, container, false);

        textView3 = viewGroup.findViewById(R.id.textView3);
        button3 = viewGroup.findViewById(R.id.button3);

        // 프래그먼트2에서 데이터 받기
        if (activity.mBundle != null) {
            Bundle bundle = activity.mBundle;
            receiveData = bundle.getString("sendData");
            Person person2 = (Person) bundle.getSerializable("person2");
            String name = person2.getName();
            int age = person2.getAge();

            textView3.setText(receiveData + "\n");
            textView3.append("name : " + name + "\nage : " + age);

            activity.mBundle = null; //null로 만들어줘야 세번째 탭 눌러주어도 TextView 나오게 할 수 있다

        }

        // 프래그먼트 1으로 데이터 보내기
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bundle bundle = new Bundle();
                bundle.putString("sendData", sendDate);
                bundle.putSerializable("person3", person3);    //person3으로 보낼 것
                bundle.putInt("index", 2);    //몇 번째 버튼을 눌렀나

                // 메인 액티비티에 번들 만들어서 보내기
                activity.fragBtnClick(bundle);

                // 메인 액티비티에 프래그먼트1으로 화면전환 요청
                TabLayout.Tab tab = activity.tabs.getTabAt(0);
                tab.select();
            }
        });

        return viewGroup;
    }
}
