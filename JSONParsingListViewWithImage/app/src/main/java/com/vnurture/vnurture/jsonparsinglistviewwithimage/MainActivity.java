package com.vnurture.vnurture.jsonparsinglistviewwithimage;

import android.os.AsyncTask;
import android.os.StrictMode;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.GridView;
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

public class MainActivity extends AppCompatActivity {

    ArrayList<QuotesCatagory> quotesCatagoryArrayList;

    GridView gridView;

    String name;
    int id;

    CustomAdapterGrid customAdapterGrid;

    CustomAdapterList customAdapterList;

    int idQuotes;
    String quote;

    int cat_id;

    ArrayList<Quotes> quotesArrayList;

    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (android.os.Build.VERSION.SDK_INT > 9) {
            StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
            StrictMode.setThreadPolicy(policy);
        }

        gridView=(GridView) findViewById(R.id.grid_view);

        new MyAsyncTaskGrid().execute("https://jsonplaceholder.typicode.com/posts");

    }


    class MyAsyncTaskGrid extends AsyncTask<String,Void,String> {

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
        }

        @Override
        protected String doInBackground(String... strings) {

            try {
                URL url = new URL(strings[0]);

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
                    return jsonString;

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

            quotesCatagoryArrayList = new ArrayList<>();

            try {
                JSONObject rootObject=new JSONObject();
                int success = rootObject.getInt("success");
                String message = rootObject.getString("message");

                JSONArray quotesCatagoryArray = rootObject.getJSONArray(s);

                for (int i = 0; i <quotesCatagoryArray.length() ; i++) {
                    QuotesCatagory quotesCatagory = new QuotesCatagory();
                    JSONObject postObject = quotesCatagoryArray.getJSONObject(i);


                    id = postObject.getInt("id");
                    name = postObject.getString("name");



                    quotesCatagory.setId(id);

                    quotesCatagoryArrayList.add(quotesCatagory);
                }

                customAdapterGrid = new CustomAdapterGrid(MainActivity.this, quotesCatagoryArrayList);



                gridView.setAdapter(customAdapterGrid);

            } catch (JSONException e) {
                e.printStackTrace();
            }

        }
    }

    /*class MyAsyncTaskList extends AsyncTask<String,Void,String> {

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
        }

        @Override
        protected String doInBackground(String... strings) {

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
                    return jsonString;

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

            quotesArrayList = new ArrayList<>();

            try {
                JSONObject rootObject=new JSONObject();
                int success = rootObject.getInt("success");
                String message = rootObject.getString("message");

                JSONArray quotesArray = rootObject.getJSONArray(s);

                for (int i = 0; i <quotesArray.length() ; i++) {
                    Quotes quotes = new Quotes();
                    JSONObject quotesObject = quotesArray.getJSONObject(i);

                    idQuotes = quotesObject.getInt("id");
                    cat_id=quotesObject.getInt("cat_id");
                    quote=quotesObject.getString("quotes");



                    quotes.setId(id);


                    quotesArrayList.add(quotes);
                }

                customAdapterList = new CustomAdapterList(MainActivity.this, quotesArrayList);



                listView.setAdapter(customAdapterList);

            } catch (JSONException e) {
                e.printStackTrace();
            }

        }
    }
*/
}
