package com.mi.button_t;

import android.content.DialogInterface;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private Button but;
    private ImageView iv;
    private CheckBox cb;
    private EditText editText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        supportRequestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_main);
        initView();
        but = (Button) findViewById(R.id.but);
        iv = (ImageView) findViewById(R.id.iv);
        iv.setBackgroundResource(R.mipmap.imgs2);
//        //通过方法设置iv的大小的尺寸
//        RelativeLayout.LayoutParams params= (RelativeLayout.LayoutParams) iv.getLayoutParams(); //得到的IV的参数的数据
//        params.width= WindowManager.LayoutParams.WRAP_CONTENT;//设置参数的长度的值为wrap
//        params.height= WindowManager.LayoutParams.WRAP_CONTENT;//设置参数的宽度的值为wrap
//        iv.setLayoutParams(params);//将重新设定的参数的数据加入到设定的IV的尺寸中去

cb.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
    @Override
    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
        if (isChecked) {
//            Toast.makeText(MainActivity.this,"被选中了",Toast.LENGTH_SHORT).show();
            editText.setTypeface(Typeface.defaultFromStyle(Typeface.ITALIC ));
        }
    }
});
        but.setOnClickListener(this);
//        but.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Toast.makeText(MainActivity.this,"按钮被点击",Toast.LENGTH_LONG).show();
//            }
//        });
    }

    private void initView() {
        cb = (CheckBox) findViewById(R.id.cb);
        editText = (EditText) findViewById(R.id.editText);
    }

    public void click(View view)
    {
        switch (view.getId()){
            case R.id.but:
                Toast.makeText(this,"按钮被点击",Toast.LENGTH_LONG).show();
                break;
            case R.id.iv:
                Toast.makeText(this,"图片被点击了",Toast.LENGTH_LONG).show();
                break;
        }
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.but:
                Toast.makeText(this, "按钮被点击lllll", Toast.LENGTH_LONG).show();
                break;
        }
    }
}
