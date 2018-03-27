package com.tbkt.www.englishdemo.Activity.English_Activity;

import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.tbkt.www.englishdemo.Activity.BaseActivity;
import com.tbkt.www.englishdemo.R;

public class English_Main extends BaseActivity {

    private TextView all_title_text;
    private Button words_study;
    private ImageView all_title_img_back;

    @Override
    public void initView() {
        all_title_text = findViewById(R.id.all_title_text);
        all_title_img_back = findViewById(R.id.all_title_img_back);
        all_title_img_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                English_Main.this.finish();
            }
        });
        all_title_text.setText("英语主页");
        words_study = findViewById(R.id.words_study);
        words_study.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //TODO 跳转单词学习页面

            }
        });
    }

    @Override
    public void initData() {

    }

    @Override
    public int getLayout() {
        return R.layout.activity_english_main;
    }
}
