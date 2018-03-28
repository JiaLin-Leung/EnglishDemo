package com.englishdemo.Activity;

import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.englishdemo.Activity.English_Activity.English_Main;
import com.englishdemo.R;

public class MainActivity extends BaseActivity{

    private Button ecglish_button;
    private Intent intent;
    private TextView all_title_text;

    @Override
    public void initView() {
        all_title_text = findViewById(R.id.all_title_text);
        all_title_text.setText("TBKT_Demo");
        ecglish_button = findViewById(R.id.ecglish_button);
        ecglish_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                intent = new Intent();
                intent.setClass(MainActivity.this, English_Main.class);
                startActivity(intent);
            }
        });
    }

    @Override
    public void initData() {

    }

    @Override
    public int getLayout() {
        return R.layout.activity_main;
    }
}
