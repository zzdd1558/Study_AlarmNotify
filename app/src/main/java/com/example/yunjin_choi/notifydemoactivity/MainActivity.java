package com.example.yunjin_choi.notifydemoactivity;

import android.app.NotificationManager;
import android.content.Context;
import android.support.v4.app.NotificationCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{


    private Button sendNotify;

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
        NotificationCompat.Builder builder = new NotificationCompat.Builder(this)
                .setSmallIcon(android.R.drawable.ic_dialog_info)
                .setContentTitle("Notify Test")
                .setContentText("안녕하세요 Notify 테스트입니다.");

        int notificationId = 101;

        NotificationManager notifyMgr =
                (NotificationManager)getSystemService(NOTIFICATION_SERVICE);

        notifyMgr.notify(notificationId , builder.build());
    }
}
