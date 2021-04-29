package com.example.my27_listview2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    Button btnAdd;
    ListView listView;

    SingerAdapter adapter;
    ArrayList<SingerDTO> dtos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        dtos = new ArrayList<>();
        btnAdd = findViewById(R.id.btnAdd);
        listView = findViewById(R.id.listView);

        // 어댑터 객체를 생성한다
        adapter = new SingerAdapter(MainActivity.this, dtos);

        // 어댑터에 있는 ArrayList에 DTO를 5개 추가한다
        adapter.addDto(new SingerDTO("블랙핑크", "010-1111-1111", 25, R.drawable.singer1));
        adapter.addDto(new SingerDTO("걸스데이", "010-2222-2222", 27, R.drawable.singer2));
        adapter.addDto(new SingerDTO("이달의소녀", "010-3333-3333", 29, R.drawable.singer3));
        adapter.addDto(new SingerDTO("소녀시대", "010-4444-4444", 31, R.drawable.singer4));
        adapter.addDto(new SingerDTO("마마무", "010-5555-5555", 23, R.drawable.singer5));

        // 만든 어댑터를 리스트뷰에 붙인다
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                SingerDTO dto = (SingerDTO) adapter.getItem(position);

                Toast.makeText(MainActivity.this, "선택 : " + position
                        + "\n이름 : " + dto.getName() + "\n전화번호 : " + dto.getMobile()
                        + "\n나이 : " + dto.getAge() + "\n이미지 : " + dto.getResId()
                        ,Toast.LENGTH_SHORT).show();

            }
        });


        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // 어댑터에 있는 ArrayList에 DTO를 1개 추가
                adapter.addDto(new SingerDTO("김윤아", "010-6666-6666", 35, R.drawable.singer1));
                // 화면 갱신
                adapter.notifyDataSetChanged();
            }
        });
    }
}