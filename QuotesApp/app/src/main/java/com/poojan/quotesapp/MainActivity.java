package com.poojan.quotesapp;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.AsyncTask;
import android.os.StrictMode;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.GridView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    GridView gridView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.grid_view);


        if (android.os.Build.VERSION.SDK_INT > 9) {
            StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
            StrictMode.setThreadPolicy(policy);
        }

        new MyGridClass().execute("http://rapidans.esy.es/test/getallcat.php");
        gridView=(GridView) findViewById(R.id.grid_view);

    }

    class MyGridClass extends AsyncTask<String, Void, String> {

        ProgressDialog dialog;
        ArrayList<QuotesCatagoryModel> quotesCatagoryModelArrayList = new ArrayList<>();
        CustomAdapterGrid customAdapterGrid;



        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            dialog = new ProgressDialog(MainActivity.this);
            dialog.setMessage("Loading...");
            dialog.setCancelable(false);
            dialog.show();
        }

        @Override
        protected String doInBackground(String... params) {
            HttpURLConnection connection;
            try {
                URL url = new URL(params[0]);
                try {
                    connection = (HttpURLConnection) url.openConnection();
                    connection.connect();

                    InputStream stream = connection.getInputStream();
                    BufferedReader reader = new BufferedReader(new InputStreamReader(stream));

                    StringBuffer buffer = new StringBuffer();
                    String line = "";

                    while ((line = reader.readLine()) != null) {
                        buffer.append(line);
                    }

                    String bufferString = buffer.toString();
                    return bufferString;


                } catch (IOException e) {
                    e.printStackTrace();
                }
            } catch (MalformedURLException e) {
                e.printStackTrace();
            }
            return null;
        }

        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);
            if (dialog.isShowing()) {
                dialog.dismiss();
            }
            quotesCatagoryModelArrayList = new ArrayList<>();

            try {

                JSONObject rootObject = new JSONObject(s);


                JSONArray dataArray = rootObject.getJSONArray("data");
                for (int i = 0; i < dataArray.length(); i++) {
                    JSONObject jsonObject = dataArray.getJSONObject(i);


                    QuotesCatagoryModel p = new QuotesCatagoryModel();


                    p.setCatagory(jsonObject.getString("name"));

                    quotesCatagoryModelArrayList.add(p);
                }

                customAdapterGrid = new CustomAdapterGrid(MainActivity.this,quotesCatagoryModelArrayList);

                gridView.setAdapter(customAdapterGrid);

            } catch (JSONException e) {
                e.printStackTrace();
            }


        }

    }

}