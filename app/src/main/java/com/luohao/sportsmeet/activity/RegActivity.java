package com.luohao.sportsmeet.activity;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;

import com.luohao.sportsmeet.API.LinkServer;
import com.luohao.sportsmeet.AppsData;
import com.luohao.sportsmeet.R;
import com.luohao.sportsmeet.Service.UserService;

import org.json.JSONException;
import org.json.JSONObject;

public class RegActivity extends Activity implements View.OnClickListener {
    private Button ExitButton;
    private Button RegButton;

    private EditText username;
    private EditText password1;
    private EditText password2;

    private LinkServer linkServer;
    UserService userService = new UserService();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_reg);

        //注册和返回按钮
        ExitButton = (Button) findViewById(R.id.exit_button);
        RegButton = (Button) findViewById(R.id.enter_reg_button);

        //用户注册信息
        username = (EditText) findViewById(R.id.username_edit);
        password1 = (EditText) findViewById(R.id.input_password);
        password2 = (EditText) findViewById(R.id.enter_password);


        RegButton.setOnClickListener(this);
        ExitButton.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            //点击取消按钮，退出这个活动
            case R.id.exit_button:
                finish();
                break;
            //点击注册按钮将
            case R.id.enter_reg_button:
                String pswd1 = password1.getText().toString();
                String pswd2 = password2.getText().toString();
                if (!username.getText().toString().equals("")) {
                    if ((!pswd1.equals("")) || (!pswd2.equals(""))) {
                        if(pswd1.equals(pswd2)) {
                            linkServer = new LinkServer();
                            Log.d("json", getRegData());
                            linkServer.setHTTPData(getRegData());
                            linkServer.setHttpURL(AppsData.RegServerURL);
                            linkServer.start();
                        } else {
                            System.out.println("eeederrr");
                        }
                    }
                } else {

                }
                break;
        }
    }

    private String getRegData() {
        JSONObject RegInfo = new JSONObject();
        try {
            RegInfo.put("username", username.getText().toString());
            RegInfo.put("password", password1.getText().toString());
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return RegInfo.toString();
    }
}
