package com.mi.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
private int num=0;
    private TextView tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tv = (TextView) findViewById(R.id.tv);
        if (savedInstanceState != null) {
           int s= savedInstanceState.getInt("num");
            Toast.makeText(MainActivity.this,""+s,Toast.LENGTH_SHORT).show();
        }
    }
    public void click(View view)
    {
        switch (view.getId()) {
            case R.id.but:
                tv.setText(++num+"");
                break;
        }
    }


    /**现场保护的方法
     * 运行的特点
     * 1当程序被系统意外回收运行此方法
     * 2当横竖屏旋转 页面对象销毁前运行此方法
     * 参数 用于存储键值对类型的数据
     * 平且此参数会在页面再次创建的时候自动传递给oncreate,onReatoreinstance方法
     *
     * */@Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt("num",num);
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        int s= savedInstanceState.getInt("num");
        Toast.makeText(MainActivity.this,""+s,Toast.LENGTH_SHORT).show();
    }
    //上面的两种方法的区别在用于一个需要判断其是否为空但是onRestoreInstanceState的方法不需要判断是否为空
}
