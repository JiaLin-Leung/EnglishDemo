package com.englishdemo.Activity.English_Activity;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.englishdemo.Activity.BaseActivity;
import com.englishdemo.R;

public class English_StudyWords extends BaseActivity {

    private TextView all_title_text;
    private ImageView all_title_img_back;

    @Override
    public void initView() {
        all_title_text = findViewById(R.id.all_title_text);
        all_title_text.setText("单词学习");
        all_title_img_back = findViewById(R.id.all_title_img_back);
        all_title_img_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                English_StudyWords.this.finish();
            }
        });
    }

    @Override
    public void initData() {

    }

    @Override
    public int getLayout() {
        return R.layout.activity_english_study;
    }
}
