package com.luohao.sportsmeet.API;


import com.luohao.sportsmeet.AppsData;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by luogkme on 2017/1/22.
 */

public class LinkServer extends Thread {
    private HttpURLConnection httpURLConnection;
    private URL url;
    private OutputStreamWriter writer;
    private String HttpURL;
    private String HTTPData;

    public String returnData;

    private String sendData(String Data) throws IOException {
        BufferedReader inputStreamReader;
        try {
            url = new URL(getHttpURL());
            httpURLConnection = (HttpURLConnection) url.openConnection();
            //设置HTTP协议
            httpURLConnection.setRequestMethod("POST");
            httpURLConnection.setDoOutput(true);
            httpURLConnection.setDoInput(true);
            httpURLConnection.setConnectTimeout(5000);
            httpURLConnection.setRequestProperty("Content-type", "application/json");

            writer = new OutputStreamWriter(httpURLConnection.getOutputStream());
            writer.write(Data);
            writer.flush();

            inputStreamReader = new BufferedReader(new InputStreamReader(httpURLConnection.getInputStream()));
            return inputStreamReader.readLine();
        } catch (MalformedURLException e) {
            e.printStackTrace();
            AppsData.getReturn("内部出错，请重试", 400);
        } catch (IOException e) {
            e.printStackTrace();
            AppsData.getReturn("内部出错，请重试", 400);
        }
        return AppsData.getReturn("内部出错，请重试", 400);
    }

    private String getHTTPData() {
        return HTTPData;
    }

    public void setHTTPData(String HTTPData) {
        this.HTTPData = HTTPData;
    }

    private String getHttpURL() {
        return HttpURL;
    }

    public void setHttpURL(String httpURL) {
        HttpURL = httpURL;
    }

    public String getReturnData() {
        return returnData;
    }


    @Override
    public void run() {
        try {
            returnData = sendData(getHTTPData());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
