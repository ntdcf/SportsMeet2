package com.luohao.sportsmeet;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by luogkme on 2017/1/26.
 */

public class AppsData {
    public static final String LoginServerURL = "http://222.24.63.100:9149/SportMeetService/login";
    public static final String RegServerURL = "http://222.24.63.100:9149/SportMeetService/reg";
    public static final String SessionURL = "http://222.24.63.100:9149/SportMeetService/getsession";

    public static String SessionData = "";

    //返回给客户端统一的形式
    public static String getReturn(String msg, int num) {
        JSONObject jsonObject =new JSONObject();
        try {
            jsonObject.put("msg", msg);
            jsonObject.put("num", num);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return jsonObject.toString();
    }
}
