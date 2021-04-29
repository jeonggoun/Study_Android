package com.example.my10_intentresult;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Sub1Activity extends AppCompatActivity {

    Button btnSub1;
    TextView tvSub1;
    Intent intent;
    private static final String TAG = "main:Sub1Activity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sub1);

        btnSub1 = findViewById(R.id.btnSub1);
        tvSub1 = findViewById(R.id.tvSub1);

        // 2. 메인에서 보낸 데이터 받기
        intent = getIntent();
        if (intent != null){
            String id = intent.getStringExtra("id");
            int pw = intent.getIntExtra("pw",0);
            PersonDTO personDTO1 = (PersonDTO) intent.getSerializableExtra("personDTO1");

            Log.d(TAG, "onCreate: id => " + id + ", pw => " + pw);

            //tvSub1.setText(String .valueOf(pw));
            tvSub1.setText("id => " + id + "\npw => " + pw);
            tvSub1.append("\nDTO id => " + personDTO1.getId()
                            + "\nDTO pw => " + personDTO1.getPw());

        }

        btnSub1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // 3. 메인에게 인텐트 만들어서 데이터 보내기
                Intent reIntent = new Intent();
                reIntent.putExtra("key",
                        tvSub1.getText().toString() + " : ㅋㅋㅋ"); //getText로 텍스트 가져오고, toString으로 문자열로 가져온다
                setResult(RESULT_OK, reIntent);

                finish();
            }//onClick
        });//setOnClickListner
    }//onCreate
}//class