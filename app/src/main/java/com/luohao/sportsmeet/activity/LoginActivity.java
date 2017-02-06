package com.luohao.sportsmeet.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;

import com.luohao.sportsmeet.API.LinkServer;
import com.luohao.sportsmeet.AppsData;
import com.luohao.sportsmeet.R;
import com.luohao.sportsmeet.Service.LoginService;

import org.json.JSONException;
import org.json.JSONObject;

public class LoginActivity extends Activity implements OnClickListener {
    private Intent intent;      //切换任务

    private Button LoginButton;     //登录按钮
    private Button RegButton;       //注册按钮
    private Button ForgetPasswdButton;      //忘记密码按钮

    private EditText username;      //用户名
    private EditText password;      //密码

    private LinkServer linkServer;

    private LoginService loginService = new LoginService();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_login);

//        按钮点击
        LoginButton = (Button) findViewById(R.id.login_button);
        RegButton = (Button) findViewById(R.id.reg_button);
        ForgetPasswdButton = (Button) findViewById(R.id.password_forget);

        username = (EditText) findViewById(R.id.username_edit);
        password = (EditText) findViewById(R.id.password_edit);

        RegButton.setOnClickListener(this);
        LoginButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            //点击注册按钮
            case R.id.reg_button:
                intent = new Intent(LoginActivity.this, RegActivity.class);
                startActivity(intent);
                break;
            //点击登录按钮
            case R.id.login_button:
                linkServer = new LinkServer();      //HTTP请求的内容
                Log.d("json",getLoginData());
                linkServer.setHTTPData(getLoginData());
                linkServer.setHttpURL(AppsData.LoginServerURL);
                linkServer.start();     //创建一条线程，用于访问后台数据
                break;
            default:
                break;
        }
    }

    private String getLoginData() {
        JSONObject LoginInfo = new JSONObject();
        try {
            LoginInfo.put("username", username.getText().toString());
            LoginInfo.put("password", password.getText().toString());
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return LoginInfo.toString();
    }
}
