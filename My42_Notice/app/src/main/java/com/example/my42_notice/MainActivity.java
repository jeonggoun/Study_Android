package com.example.my42_notice;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    NotificationManager manager; //객체 하나 만든다

    // 오레오 버전 이후는 알림 채널을 생성해서 줘야 한다
    String CHANNEL_ID1 = "channel1";
    String CHANNEL_NAME1 = "channel1";

    String CHANNEL_ID2 = "channel2";
    String CHANNEL_NAME2 = "channel2";

    String CHANNEL_ID3 = "channel3";
    String CHANNEL_NAME3 = "channel3";

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        // 알림 띄우기
        findViewById(R.id.button1).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showNoti1();
            }//onClick()
        });//button1 ClickListener
        
        // 알림 띄우고 클릭하기
        findViewById(R.id.button2).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showNoti2();
            }//onClick()
        });//button2 ClickListener
        
        //많은 글자 알림 띄우기
        findViewById(R.id.button3).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showNoti3();
            }//onClick()
        });//button3 ClickListener
        
    }//onCreate

    private void showNoti1() {  //알림 띄울 때 사용할 메소드
        //manager 만든다
        manager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);

        NotificationCompat.Builder builder = null;
        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.O){ // API26(오레오 버전)
            if(manager.getNotificationChannel(CHANNEL_ID1) == null){
                manager.createNotificationChannel(new NotificationChannel
                        (CHANNEL_ID1, CHANNEL_NAME1, NotificationManager.IMPORTANCE_DEFAULT));
            }//if
            builder = new NotificationCompat.Builder(this, CHANNEL_ID1);
        }else{
            builder = new NotificationCompat.Builder(this);
        }//if~else

        builder.setContentTitle("간단 알림")   //알림 제목
                .setContentText("간단 알림 메시지입니다") //알림 내용
                .setSmallIcon(android.R.drawable.ic_menu_view); //아이콘
        Notification noti = builder.build();

        manager.notify(1, noti);
    }//showNoti1()

    private void showNoti2() {  //알림 띄울 때 사용할 메소드
        //manager 만든다
        manager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);

        NotificationCompat.Builder builder = null;
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) { // API26(오레오 버전)
            if (manager.getNotificationChannel(CHANNEL_ID2) == null) {
                manager.createNotificationChannel(new NotificationChannel
                        (CHANNEL_ID2, CHANNEL_NAME2, NotificationManager.IMPORTANCE_DEFAULT));
            }//if
            builder = new NotificationCompat.Builder(this, CHANNEL_ID2);
        } else {
            builder = new NotificationCompat.Builder(this);
        }//if~else

        // 펜딩인텐트 객체에 띄울 액티비티를 파라미터로 보낸다
        // 펜딩인텐트는 특정 시점에서 어떤 행동을 하도록 할 수 있다.
        Intent intent = new Intent(this, SubActivity.class);
        PendingIntent pendingIntent = PendingIntent.getActivity(this, 1001, intent,
                PendingIntent.FLAG_UPDATE_CURRENT);

        builder.setContentTitle("간단 알림 클릭")
                .setContentText("클릭 알림 메시지입니다.")
                .setSmallIcon(android.R.drawable.ic_menu_view)
                .setAutoCancel(true)    //알림을 클릭하면 자동으로 알림이사라짐
                .setContentIntent(pendingIntent);
        Notification noti = builder.build();
        manager.notify(2, noti);
    }//shoNoti2()

    private void showNoti3() {  //알림 띄울 때 사용할 메소드
        //manager 만든다
        manager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);

        NotificationCompat.Builder builder = null;
        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.O){ // API26(오레오 버전)
            if(manager.getNotificationChannel(CHANNEL_ID3) == null){
                manager.createNotificationChannel(new NotificationChannel
                        (CHANNEL_ID3, CHANNEL_NAME3, NotificationManager.IMPORTANCE_DEFAULT));
            }//if
            builder = new NotificationCompat.Builder(this, CHANNEL_ID3);
        }else{
            builder = new NotificationCompat.Builder(this);
        }//if~else

        NotificationCompat.BigTextStyle style =
                new NotificationCompat.BigTextStyle();
        style.bigText("많은 글자들입니다. 많은 글자들입니다. 많은 글자들입니다. 많은 글자들입니다. 많은 글자들입니다. 많은 글자들입니다. 많은 글자들입니다. 많은 글자들입니다. 많은 글자들입니다. 많은 글자들입니다. 많은 글자들입니다. 많은 글자들입니다. 많은 글자들입니다. 많은 글자들입니다. 많은 글자들입니다. 많은 글자들입니다. 많은 글자들입니다. ");
        style.setBigContentTitle("제목입니다");
        style.setSummaryText("요약글입니다");

        builder = new NotificationCompat.Builder(this, "channel3")
                .setSmallIcon(android.R.drawable.ic_menu_send)
                .setStyle(style);

        Notification noti = builder.build();
        manager.notify(3, noti);

    }//showNoti1()

}//class