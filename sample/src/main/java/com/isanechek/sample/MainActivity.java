package com.isanechek.sample;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import java.io.IOException;

import dev.niekirk.com.instagram4android.Instagram4Android;
import dev.niekirk.com.instagram4android.requests.payload.InstagramLoginResult;

public class MainActivity extends AppCompatActivity {

    private static final String USER_NAME = "setteropen";
    private static final String USER_PASSWORD = "01i11fucking00tyrina11";

    private TextView info;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        info = findViewById(R.id.status_info);

        new LoginTask().execute();
    }

    private class LoginTask extends AsyncTask<Void, Void, String> {

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            info.setText("Start Login Task");
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
                InstagramLoginResult instagramLoginResult = i4a.login();
                return instagramLoginResult.getStatus();
            } catch (IOException e) {
                e.printStackTrace();
                return null;
            }
        }
    }
}
