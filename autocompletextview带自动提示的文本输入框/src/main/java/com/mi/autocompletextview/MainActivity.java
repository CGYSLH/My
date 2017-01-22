package com.mi.autocompletextview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private AutoCompleteTextView actv;
        private List<String> list=new ArrayList<>();
    private ArrayAdapter<String> adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        actv = (AutoCompleteTextView) findViewById(R.id.actv);
        initData();
        initAdapter();
        actv.setOnItemClickListener(new AdapterView.OnItemClickListener() {//监听选择的是那个
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//                Toast.makeText(MainActivity.this,position+"",Toast.LENGTH_SHORT).show();//这只能够获取位置无法获取内容
                Toast.makeText(MainActivity.this,parent.getItemAtPosition(position).toString(),Toast.LENGTH_SHORT).show();//如果哟获取内容可以采用这样的方法
            }
        });
    }

    private void initAdapter() {
        adapter=new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item,list);
        actv.setAdapter(adapter);
    }

    private void initData() {
       String[] text= getResources().getStringArray(R.array.autotext);
      List<String> texts= Arrays.asList(text);
        list.addAll(texts);
    }
}
