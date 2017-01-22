package com.mi.net;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;

import com.mi.net.utils.MyTasks;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

public class Main22Activity extends AppCompatActivity {

    private ImageView iv1;
    private ImageView iv2;
    private ProgressBar pb1;
    private ProgressBar pb2;
    private Button but;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main22);
        initView();
        but.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                /**
                 * 下面这中方式启动的任务下载的话只会一个一个按照顺序进行下载如果我们需要将两个任务同时下载的话这个时候需要的是
                 * */
//                new MyTasks(iv1,pb1,Main22Activity.this).execute("http://imgs.hbsztv.com/2016/1015/20161015120416518.jpg");
//                new MyTasks(iv2,pb2,Main22Activity.this).execute("https://p1.ssl.qhimg.com/t0151320b1d0fc50be8.png");
                Executor executor= Executors.newFixedThreadPool(3);//启动几个下载任务
     new MyTasks(iv1,pb1,Main22Activity.this).executeOnExecutor(executor,"http://imgs.hbsztv.com/2016/1015/20161015120416518.jpg");
                new MyTasks(iv2,pb2,Main22Activity.this).executeOnExecutor(executor,"https://p1.ssl.qhimg.com/t0151320b1d0fc50be8.png");
            }
        });
    }

    private void initView() {
        iv1 = (ImageView) findViewById(R.id.iv1);
        iv2 = (ImageView) findViewById(R.id.iv2);
        pb1 = (ProgressBar) findViewById(R.id.pb11);
        pb2 = (ProgressBar) findViewById(R.id.pb21);

        but = (Button) findViewById(R.id.but);
    }


}
