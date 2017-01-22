package com.mi.net;

import android.app.ProgressDialog;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.os.SystemClock;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class Main2Activity extends AppCompatActivity {

    private ImageView iv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        iv = (ImageView) findViewById(R.id.iv);
    }
    public void click(View view) {
        switch (view.getId()) {
            case R.id.but:
new MyTask().execute("http://imgs.hbsztv.com/2016/1015/20161015120416518.jpg");
                break;
        }
    }

    class MyTask extends AsyncTask<String, Integer, Bitmap> {
private ProgressDialog dialog;
        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            dialog = new ProgressDialog(Main2Activity.this);
            dialog.setMessage("下载中");
            dialog.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
            dialog.show();
        }

        @Override
        protected Bitmap doInBackground(String... params) {
            try {
                HttpURLConnection con= (HttpURLConnection) new URL(params[0]).openConnection();
                con.connect();
                if (con.getResponseCode() == 200) {

                    InputStream is=con.getInputStream();
                    int max=con.getContentLength();
                    byte[] buf=new byte[3];
                    int num=0,current=0;

                    ByteArrayOutputStream bos=new ByteArrayOutputStream();
                    while ((num = is.read(buf)) != -1) {
                        current+=num;
                        bos.write(buf,0,num);
                        publishProgress(max,current);
                    }
                    byte[] os=bos.toByteArray();
                    return BitmapFactory.decodeByteArray(os,0,os.length);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            return null;
        }

        protected void onProgressUpdate(Integer... values) {
           super.onProgressUpdate(values);
            dialog.setMax(values[0]);
            dialog.setProgress(values[1]);
        }

        @Override
        protected void onPostExecute(Bitmap bitmap) {
            super.onPostExecute(bitmap);

            if (bitmap != null) {
                dialog.dismiss();
                iv.setImageBitmap(bitmap);
            }
        }
    }

}
