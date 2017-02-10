package com.poojan.jsonparsinglistviewwithurlconnection;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import static android.provider.ContactsContract.CommonDataKinds.Website.URL;

public class MainActivity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        try {
            URL url = new URL("https://jsonplaceholder.typicode.com/posts");

            try {
                HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();

                InputStream stream = urlConnection.getInputStream();

                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(stream));
                StringBuffer stringBuffer = new StringBuffer();

                while(bufferedReader.readLine()!=null){

                    stringBuffer.append(bufferedReader.readLine());

                }

                String jsonString = bufferedReader.toString();
            } catch (IOException e) {
                e.printStackTrace();
            }
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
    }
}
