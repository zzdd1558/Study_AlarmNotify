package com.example.yunjin_choi.notifydemoactivity;

import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.media.RingtoneManager;
import android.net.Uri;
import android.support.v4.app.NotificationCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{


    private Button sendNotify;
    private static String GROUP_KEY_NOTIFY = "Group Key";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        sendNotify = findViewById(R.id.sendNotify);

        sendNotify.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {

        switch (v.getId()){
            case R.id.sendNotify :

                sendNotification();
                break;

        }
    }

    // 반드시 public 으로 와야한다.
    public void sendNotification(){


        //소리 사운드 추가할때 사용
        Uri defaultSoundUri = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION);


        NotificationCompat.Builder builderSummary = new NotificationCompat.Builder(this)
                .setSmallIcon(android.R.drawable.ic_dialog_info)
                .setContentTitle("Notify Test")
                .setContentText("안녕하세요 Notify 테스트입니다.")
                .setGroup(GROUP_KEY_NOTIFY)
                .setGroupSummary(true)
                //사운드 추가시 사용 기본 default 사운드 나옴.
                .setSound(defaultSoundUri);

        NotificationCompat.Builder builder1 = new NotificationCompat.Builder(this)
                .setSmallIcon(android.R.drawable.ic_dialog_info)
                .setContentTitle("new First Notify Test")
                .setContentText("안녕하세요 Notify1 입니다.")
                .setGroup(GROUP_KEY_NOTIFY)
                //사운드 추가시 사용 기본 default 사운드 나옴.
                .setSound(defaultSoundUri);

        NotificationCompat.Builder builder2 = new NotificationCompat.Builder(this)
                .setSmallIcon(android.R.drawable.ic_dialog_info)
                .setContentTitle("new Second Notify Test")
                .setContentText("안녕하세요 Notify2 입니다.")
                .setGroup(GROUP_KEY_NOTIFY)
                //사운드 추가시 사용 기본 default 사운드 나옴.
                .setSound(defaultSoundUri);

        NotificationCompat.Builder builder3 = new NotificationCompat.Builder(this)
                .setSmallIcon(android.R.drawable.ic_dialog_info)
                .setContentTitle("new Third Notify Test")
                .setContentText("안녕하세요 Notify3 입니다.")
                .setGroup(GROUP_KEY_NOTIFY)
                //사운드 추가시 사용 기본 default 사운드 나옴.
                .setSound(defaultSoundUri);





        // PendingIntent 객체는 인텐트를 다른 애플리케이션에 전달할 수 있다.
        // 전달받은 애플리케이션이 향후에 그 인텐트를 수행할 수 있게 해준다.
        // 알림 패널을 터치할 때 ResultActivity를 시작시키기 위해 PendingIntent를 사용하였다.
        Intent resultIntent = new Intent(this , ResultActivity.class);
        PendingIntent pendingIntent = PendingIntent.getActivity(this , 0 , resultIntent , PendingIntent.FLAG_UPDATE_CURRENT);

        // notificationCompat.Builder에 setContentIntent메서드의 매개변수로 PendingIntent를 넣어준다.
        builderSummary.setContentIntent(pendingIntent);


        // 알림에 액션 추가하기
        NotificationCompat.Action action = new NotificationCompat.Action.Builder(android.R.drawable.sym_action_chat , "OPEN" , pendingIntent).build();
        builderSummary.addAction(action);


        //숫자가 같다면 마지막에 등록된 Notify로 대체된다
        // 덮어씌운건지 마지막걸로 Notify를 해주는지 확인 필요.
        int notificationSummary = 101;
        int notificationId1 = 102;
        int notificationId2 = 103;
        int notificationId3 = 104;

        NotificationManager notifyMgr =
                (NotificationManager)getSystemService(NOTIFICATION_SERVICE);

        notifyMgr.notify(notificationSummary , builderSummary.build());
        notifyMgr.notify(notificationId1 , builder1.build());
        notifyMgr.notify(notificationId2 , builder2.build());
        notifyMgr.notify(notificationId3 , builder3.build());

    }
}
