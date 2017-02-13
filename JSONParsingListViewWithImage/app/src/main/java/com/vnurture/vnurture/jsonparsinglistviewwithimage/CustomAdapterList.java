package com.vnurture.vnurture.jsonparsinglistviewwithimage;

import android.content.Context;
import android.os.AsyncTask;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

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

/**
 * Created by VNurtureTechnologies on 13/02/17.
 */

public class CustomAdapterList extends BaseAdapter {

    int idQuotes,cat_id;
    String quote;
    ArrayList<Quotes> quotesArrayList;
    LayoutInflater layoutInflater;

    Context context;

    CustomAdapterList(Context context, ArrayList<Quotes> quotesArrayList){

        this.context=context;
        this.quotesArrayList=quotesArrayList;

    }

    @Override
    public int getCount() {
        return quotesArrayList.size();
    }

    @Override
    public Object getItem(int i) {
        return quotesArrayList.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View convertView, ViewGroup viewGroup) {

        CustomAdapterGrid.ViewHolder holder;

        if (convertView == null) {
            holder = new CustomAdapterGrid.ViewHolder();
            layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = layoutInflater.inflate(R.layout.single_row_list_view, viewGroup, false);


            holder.idTextView = (TextView) convertView.findViewById(R.id.id_text_view);
            holder.nameTextView=(TextView) convertView.findViewById(R.id.name_text_view);

            convertView.setTag(holder);
        }

        else{
            holder = (CustomAdapterGrid.ViewHolder) convertView.getTag();
        }






        holder.idTextView.setText("Id: "+String.valueOf(quotesArrayList.get(i).getId()));
        holder.nameTextView.setText("Name: "+ quotesArrayList.get(i).getId());


        return convertView;


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



                    quotes.setId(idQuotes);
                    quotes.setCat_id(cat_id);
                    quotes.setQuotes(quote);


                    quotesArrayList.add(quotes);
                }

                *//*customAdapterList = new CustomAdapterList(MainActivity.this, quotesArrayList);



                listView.setAdapter(customAdapterList);*//*

            } catch (JSONException e) {
                e.printStackTrace();
            }

        }
    }*/




}
