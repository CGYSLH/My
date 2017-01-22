package com.mi.net.utils;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.mi.net.Main2Activity;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Created by 暗示语 on 2017/1/22.
 */

public class MyTasks extends AsyncTask<String,Integer,Bitmap>{

private  ImageView iv;
    private ProgressBar pb;
    private Context context;
    /**
     * 当需要的
     * */
    public MyTasks(ImageView iv, ProgressBar pb, Context context)
    {
        this.iv=iv;
        this.pb=pb;
        this.context=context;
    }
    @Override
    protected void onPreExecute() {//主线程
        super.onPreExecute();
    }
    @Override
    protected Bitmap doInBackground(String... params) {//在子线程中执行的

        try {
            HttpURLConnection connection= (HttpURLConnection) new URL(params[0]).openConnection();
            connection.connect();
            if (connection.getResponseCode() == 200) {
                InputStream is=connection.getInputStream();
                byte[] buf=new byte[30];//创建缓存的一个读取控件一次读取30字节
                int num=0;
                int total=connection.getContentLength();//得到当前连接的总的长度
                int current=0;//获取当前读取的长度
                ByteArrayOutputStream bos=new ByteArrayOutputStream();//创建用于存储的饭临时空间
                while ((num=is.read(buf)) != -1) {//循环的读取将数据存储到临时的空间中去
                    current+=num;
                    bos.write(buf,0,num);
                    //更新progressbar的进度
                    publishProgress(current,total);
                }
                byte[] bytes=bos.toByteArray();
                return BitmapFactory.decodeByteArray(bytes,0,bytes.length);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    protected void onProgressUpdate(Integer... values) {
        super.onProgressUpdate(values);
        pb.setProgress(values[0]);
        pb.setMax(values[1]);
        if (pb == null) {
            Toast.makeText(context,"为空",Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    protected void onPostExecute(Bitmap bitmap) {
        super.onPostExecute(bitmap);
        if (bitmap != null) {
            iv.setImageBitmap(bitmap);
        }
    }


}
