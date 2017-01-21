package com.mi.my;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;

public class MainActivity extends AppCompatActivity {
    /**
     * 当第一次打开该页面的时候
     * */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        supportRequestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);//取消状态栏的设置
        setContentView(R.layout.activity_main);
        Log.i("tmd","onCreate");
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.i("tmd","onStart");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.i("tmd","onResume");
    }


   /**
    * 当页面部分可见的时候调用的方法  意思就是如果下一个显示的Activity如果是以dialog的形式显现的话这样就是部分可见 因此不会走onstop的方法
    * */ @Override
    protected void onPause() {
        super.onPause();
        Log.i("tmd","onPause");
    }


    /**
     * 当页面完全不可见的时候调用的方法
     * */  @Override
    protected void onStop() {
        super.onStop();
        Log.i("tmd","onStop");
    }


    /**
     * 当页面执行了finish的方法的时候调用的方法
     * */ @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.i("tmd","onDestroy");
    }


    /**
     * 当从新返回到该页面时会走onrestart onstart onresume 注意这里不会走oncreate的方法
     * */   @Override
    protected void onRestart() {
        super.onRestart();
        Log.i("tmd","onRestart");
    }
    public void click(View view) {
        switch (view.getId()) {
            case R.id.but:
                startActivity(new Intent(MainActivity.this,Main2Activity.class));
                break;
        }
    }
}
