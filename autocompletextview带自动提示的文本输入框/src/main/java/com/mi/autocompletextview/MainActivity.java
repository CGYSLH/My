package com.mi.autocompletextview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;

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
