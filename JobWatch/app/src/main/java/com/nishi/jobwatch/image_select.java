package com.nishi.jobwatch;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.net.Uri;
import android.os.AsyncTask;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Base64;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.params.BasicHttpParams;
import org.apache.http.params.HttpConnectionParams;
import org.apache.http.params.HttpParams;

import java.io.ByteArrayOutputStream;
import java.util.ArrayList;

public class image_select extends AppCompatActivity implements View.OnClickListener {
    private static final int RESULT_LOAD_IMAGE=1;
    ImageView imageView;
    Button button1,button2;
    private static final String SERVER_ADDRESS="http://10.0.2.2";


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode==RESULT_LOAD_IMAGE && resultCode==RESULT_OK && data!=null)
        {
            Uri selectImage=data.getData();
            imageView.setImageURI(selectImage);

        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image_select);
        imageView =(ImageView)findViewById(R.id.imageView);
        button2=(Button)findViewById(R.id.button2);
        imageView.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId())
        {
            case R.id.imageView:
                Intent galleryintent=new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                startActivityForResult(galleryintent,RESULT_LOAD_IMAGE);
                break;
            case R.id.button2:
                Bitmap image=((BitmapDrawable)imageView.getDrawable()).getBitmap();

                break;
        }
    }
    private class UploadImage extends AsyncTask<Void,Void,Void>
    {
        Bitmap image;
        String name;
        public  UploadImage(Bitmap image,String name)
        {
            this.image=image;
            this.name=name;
        }
        @Override
        protected Void doInBackground(Void... params) {
            ByteArrayOutputStream byteArrayOutputStream=new ByteArrayOutputStream();
            image.compress(Bitmap.CompressFormat.JPEG,100,byteArrayOutputStream);
            String encode= Base64.encodeToString(byteArrayOutputStream.toByteArray(),Base64.DEFAULT);
            ArrayList<NameValuePair> datatosend =new ArrayList<>();
            datatosend.add(new BasicNameValuePair("image",encode));
            datatosend.add(new BasicNameValuePair("name",name));
            HttpParams httpParams=getHttpRequestParams();
            HttpClient client=new DefaultHttpClient(httpParams);
            HttpPost post=new HttpPost(SERVER_ADDRESS +"conn.php ");


            try
            {
                post.setEntity(new UrlEncodedFormEntity(datatosend));
                client.execute(post);



            }
            catch (Exception e)
            {
                e.printStackTrace();
            }
            return null;
        }

        @Override
        protected void onPostExecute(Void aVoid) {
            super.onPostExecute(aVoid);
        }
    }
    private HttpParams getHttpRequestParams()
    {
        HttpParams httpParams=new BasicHttpParams();
        HttpConnectionParams.setConnectionTimeout(httpParams,1000*30);
        HttpConnectionParams.setSoTimeout(httpParams,1000*30);
        return  httpParams;
    }
}
