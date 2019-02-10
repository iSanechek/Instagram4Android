package com.isanechek.sample;

import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import java.io.IOException;

import dev.niekirk.com.instagram4android.Instagram4Android;
import dev.niekirk.com.instagram4android.requests.InstagramUserSelfInfoRequest;
import dev.niekirk.com.instagram4android.requests.payload.UserInfoResult;

public class MainActivity extends AppCompatActivity {

    private static final String USER_NAME = UserInfoUtil.USER_NAME;
    private static final String USER_PASSWORD = UserInfoUtil.USER_PASSWORD;

    private TextView info;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        info = findViewById(R.id.status_info);

        new TestTask().execute();
    }

    private class TestTask extends AsyncTask<Void, Void, String> {

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            info.setText("Start Test Task");
        }

        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);
            info.setText(s);
        }

        @Override
        protected String doInBackground(Void... voids) {
            Instagram4Android i4a = Instagram4Android.builder()
                    .username(USER_NAME)
                    .password(USER_PASSWORD)
                    .build();
            try {
                i4a.setup();
                i4a.login();
//                InstagramLoginResult instagramLoginResult = i4a.login();
//                return instagramLoginResult.getStatus();
                UserInfoResult infoResult = i4a.sendRequest(new InstagramUserSelfInfoRequest());
                return infoResult.getUser().getFull_name();
            } catch (IOException e) {
                e.printStackTrace();
                return null;
            }
        }
    }

}
