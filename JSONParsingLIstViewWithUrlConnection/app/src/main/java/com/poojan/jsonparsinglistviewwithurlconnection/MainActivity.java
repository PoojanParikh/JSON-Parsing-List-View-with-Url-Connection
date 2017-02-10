package com.poojan.jsonparsinglistviewwithurlconnection;

import android.os.StrictMode;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ListView;

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

import static android.provider.ContactsContract.CommonDataKinds.Website.URL;

public class MainActivity extends AppCompatActivity {

    int userId,id;
    String title,body;

    ListView listView;

    CustomAdapter customAdapter;



    ArrayList<Post> postArrayList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (android.os.Build.VERSION.SDK_INT > 9) {
            StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
            StrictMode.setThreadPolicy(policy);
        }

        listView = (ListView) findViewById(R.id.list_view_main);

        parsingJson();

    }

    public void parsingJson(){

        try {
            URL url = new URL("https://jsonplaceholder.typicode.com/posts");

            try {
                HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
                urlConnection.connect();

                InputStream stream = urlConnection.getInputStream();

                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(stream));
                StringBuffer stringBuffer = new StringBuffer();

                String line="";
                while((line = bufferedReader.readLine())!=null){

                    stringBuffer.append(line);

                }

                String jsonString = stringBuffer.toString();

                postArrayList = new ArrayList<>();

                try {
                    JSONArray rootArray = new JSONArray(jsonString);

                    for (int i = 0; i <rootArray.length() ; i++) {
                        Post post = new Post();
                        JSONObject postObject = rootArray.getJSONObject(i);
                        userId = postObject.getInt("userId");
                        Log.d("tag", "parsingJson: "+userId);
                        id = postObject.getInt("id");
                        Log.d("tag", "parsingJson: "+id);
                        title = postObject.getString("title");
                        Log.d("tag", "parsingJson: "+title);
                        body  = postObject.getString("body");
                        Log.d("tag", "parsingJson: "+body);

                        post.setUserId(userId);
                        post.setId(id);
                        post.setTitle(title);
                        post.setBody(body);
                        postArrayList.add(post);
                    }

                    customAdapter = new CustomAdapter(this,postArrayList);



                    listView.setAdapter(customAdapter);

                } catch (JSONException e) {
                    e.printStackTrace();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }




    }
}
