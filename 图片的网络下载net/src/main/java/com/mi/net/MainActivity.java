package com.mi.net;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;

public class MainActivity extends AppCompatActivity {

    private ImageView iv1;
    private ImageView iv2;
    private ProgressBar pb1;
    private ProgressBar pb2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }

    private void initView() {
        iv1 = (ImageView) findViewById(R.id.iv1);
        iv2 = (ImageView) findViewById(R.id.iv2);
        pb1 = (ProgressBar) findViewById(R.id.pd1);
        pb2 = (ProgressBar) findViewById(R.id.pd2);
    }

    public void click(View view)
    {
        switch (view.getId()) {
            case R.id.but:

                break;
        }
    }
}
