package com.example.my26_listview1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    TextView textView;
    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = findViewById(R.id.textView);
        listView = findViewById(R.id.listView);

        ArrayList<String> list = new ArrayList<>();

        // 안드로이드에서 제공한 어댑터 만들기
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, list);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                // 리스트뷰에서 클릭한 위치에 글자 가져오기
                String selItem = (String) parent.getItemAtPosition(position);
                textView.setText(selItem);

            }
        });

        list.add("초밥");
        list.add("텐동");
        list.add("보쌈");
        list.add("바베큐");
        list.add("파스타");
        list.add("샐러드");
        list.add("아메리카노");
        list.add("카페라떼");
        list.add("바닐라라떼");
        list.add("녹차라떼");

    }
}