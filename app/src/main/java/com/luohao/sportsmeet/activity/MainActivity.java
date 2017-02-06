package com.luohao.sportsmeet.activity;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.TextView;

import com.luohao.sportsmeet.R;

public class MainActivity extends Activity implements View.OnClickListener {

    private Intent intent;      //切换任务

    private Button UserMsg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_main);

        UserMsg = (Button) findViewById(R.id.user_msg_main);
        UserMsg.setText("用户未登录");
        UserMsg.setOnClickListener(this);
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
