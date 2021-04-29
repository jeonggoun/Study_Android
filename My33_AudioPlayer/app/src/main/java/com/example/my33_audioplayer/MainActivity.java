package com.example.my33_audioplayer;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import java.io.IOException;

public class MainActivity extends AppCompatActivity {
    // url상의 경로 지정해 준다
    String AUDIO_URL = "http://sites.google.com/site/ubiaccessmobile/sample_audio.amr";
    //Manifest.xml에 usesCleartextTraffic 지정해 http://도 사용할 수 있도록 지정
    
    // 미디어 플레이어
    MediaPlayer mediaPlayer;
    
    // 일시정지하면 지점 저장해야 하기에 포지션
    int position = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // 재생
        findViewById(R.id.button1).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //playAudio(AUDIO_URL);    //url상의 경로를 playAudio 메소드에 보내준다
                playAudio1(R.raw.m01);
                Toast.makeText(MainActivity.this, "음악파일 재생 시작", Toast.LENGTH_SHORT).show();
            }
        });//button1

        // 정지
        findViewById(R.id.button2).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(mediaPlayer != null){
                    mediaPlayer.stop();
                    Toast.makeText(MainActivity.this, "음악파일 재생 정지", Toast.LENGTH_SHORT).show();
                }
            }
        });//button2

        // 일시정지
        findViewById(R.id.button3).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(mediaPlayer != null) {
                    position = mediaPlayer.getCurrentPosition();
                    mediaPlayer.pause();
                    Toast.makeText(MainActivity.this, "음악파일 일시정지", Toast.LENGTH_SHORT).show();
                }
            }
        });//button3

        // 재시작
        findViewById(R.id.button4).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(mediaPlayer != null && !mediaPlayer.isPlaying()) {  //null이 아니면서 지금 플레잉되지 않고 있냐
                    mediaPlayer.start();
                    mediaPlayer.seekTo(position);

                    Toast.makeText(MainActivity.this, "음악파일 재시작", Toast.LENGTH_SHORT).show();
                }
            }
        });//button4


    }

    private void playAudio(String AUDIO_URL) {
        // 다른 게 재생되고 있는 경우 끄기
        killMediaPlayer();
        
        try {
            mediaPlayer = new MediaPlayer();
            mediaPlayer.setDataSource(AUDIO_URL);
            mediaPlayer.prepare();
            mediaPlayer.start();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void playAudio1(int resId) {
        // 다른 게 재생되고 있는 경우 끄기
        killMediaPlayer();

        try {
            mediaPlayer = new MediaPlayer();
            mediaPlayer = MediaPlayer.create(getApplicationContext(), resId);
            mediaPlayer.start();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void killMediaPlayer() {
        if(mediaPlayer != null){    //mediaPlayer가 null이 아니라면 → 재생되고 있다면
            mediaPlayer.release();
        }
    }


}