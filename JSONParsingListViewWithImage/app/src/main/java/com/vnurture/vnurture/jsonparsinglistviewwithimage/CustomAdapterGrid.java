package com.vnurture.vnurture.jsonparsinglistviewwithimage;

import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;
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

public class CustomAdapterGrid extends BaseAdapter {

    Context context;
    int idQuotes;
    ArrayList<QuotesCatagory> quotesCatagoryArrayList;
    LayoutInflater inflater;

    ArrayList<Quotes> quotesArrayList;

    ListView listView;

    CustomAdapterList customAdapterList;

    int cat_id;
    String quote;



    CustomAdapterGrid(Context context, ArrayList<QuotesCatagory> quotesCatagoryArrayList){
        this.context= context;

        this.quotesCatagoryArrayList = quotesCatagoryArrayList;

    }

    @Override
    public int getCount() {


        return quotesCatagoryArrayList.size();
    }

    @Override
    public Object getItem(int i) {
        return quotesCatagoryArrayList.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    static class ViewHolder {

        TextView nameTextView, idTextView;


    }

    @Override
    public View getView(final int i, View convertView, ViewGroup viewGroup) {

        listView=(ListView) convertView.findViewById(R.id.list_view);

        ViewHolder holder;

        if (convertView == null) {
            holder = new ViewHolder();
            inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.single_row_grid_view, viewGroup, false);


            holder.idTextView = (TextView) convertView.findViewById(R.id.id_text_view);
            holder.nameTextView=(TextView) convertView.findViewById(R.id.name_text_view);

            convertView.setTag(holder);
        }

        else{
            holder = (ViewHolder) convertView.getTag();
        }






        holder.idTextView.setText("Id: "+String.valueOf(quotesCatagoryArrayList.get(i).getId()));
        holder.nameTextView.setText("Name: "+ quotesCatagoryArrayList.get(i).getId());

        holder.nameTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               new MyAsyncTaskList().execute("http://rapidans.esy.es/test/getquotes.php?cat_id="+i);

            }
        });


        return convertView;
    }

    /*static class MyAsyncTaskGrid extends AsyncTask<String,Void,String> {

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
                    quotesCatagory.setName(name);

                    quotesCatagoryArrayList.add(quotesCatagory);
                }

                customAdapterList = new CustomAdapterList(context, quotesArrayList);



                listView.setAdapter(customAdapterList);

            } catch (JSONException e) {
                e.printStackTrace();
            }

        }
    }*/

    class MyAsyncTaskList extends AsyncTask<String,Void,String> {

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

                customAdapterList = new CustomAdapterList(context, quotesArrayList);



                listView.setAdapter(customAdapterList);

            } catch (JSONException e) {
                e.printStackTrace();
            }

        }
    }


    }



