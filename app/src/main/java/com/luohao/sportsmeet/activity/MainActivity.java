package com.luohao.sportsmeet.activity;

import android.app.Activity;
import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.widget.Button;

import com.luohao.sportsmeet.API.DataBaseSession;
import com.luohao.sportsmeet.API.LinkServer;
import com.luohao.sportsmeet.AppsData;
import com.luohao.sportsmeet.R;

public class MainActivity extends Activity implements View.OnClickListener {

    private Intent intent;      //切换任务
    private Button UserMsg;

    private LinkServer linkServer = new LinkServer();
    private DataBaseSession dataBaseSession;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_main);

        dataBaseSession = new DataBaseSession(this, "sportmeet.db", null, 1);
        SQLiteDatabase db = dataBaseSession.getWritableDatabase();
        Cursor cursor = db.query("session", null, null, null, null, null, null);


        UserMsg = (Button) findViewById(R.id.user_msg_main);





        if (!cursor.moveToFirst()) {
            UserMsg.setText("用户未登录");
            UserMsg.setOnClickListener(this);
        } else {
            cursor.moveToFirst();
            linkServer.setHttpURL(AppsData.SessionURL);
            linkServer.setHTTPData(cursor.getString(cursor.getColumnIndex("session_id")));
            UserMsg.setText("姓名：罗昊");
            try {
                Thread.sleep(100);
                linkServer.start();
                Thread.sleep(100);
                Log.d("session", "session:"+linkServer.getReturnData());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.user_msg_main:
                intent = new Intent(MainActivity.this, LoginActivity.class);
                startActivity(intent);
                break;
            default:
                break;
        }
    }
}
