package com.englishdemo.Activity.English_Activity;

import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.englishdemo.Activity.BaseActivity;
import com.englishdemo.R;

public class English_Main extends BaseActivity {

    private TextView all_title_text;
    private Button words_study;
    private Button change_book;
    private ImageView all_title_img_back;
    private Intent intent;

    @Override
    public void initView() {
        change_book = findViewById(R.id.change_book);
        all_title_text = findViewById(R.id.all_title_text);
        all_title_img_back = findViewById(R.id.all_title_img_back);

        all_title_text.setText("英语主页");
        words_study = findViewById(R.id.words_study);

    }

    @Override
    public void initData() {
        all_title_img_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                English_Main.this.finish();
            }
        });

        words_study.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //TODO 跳转单词学习页面
                intent = new Intent();
                intent.setClass(English_Main.this,English_StudyWords.class);
                startActivity(intent);
            }
        });
    }

    @Override
    public int getLayout() {
        return R.layout.activity_english_main;
    }
}
