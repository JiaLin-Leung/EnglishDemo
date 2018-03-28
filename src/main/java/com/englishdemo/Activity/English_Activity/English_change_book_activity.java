package com.englishdemo.Activity.English_Activity;

import android.content.SharedPreferences;
import android.view.View;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.englishdemo.Activity.BaseActivity;
import com.englishdemo.Internet.LoadCallBack;
import com.englishdemo.Internet.OkHttpManager;
import com.englishdemo.R;
import com.englishdemo.Tools.Constant_domain;
import com.englishdemo.Tools.Constant_url;
import com.englishdemo.Tools.LogUtils;
import com.englishdemo.Tools.SpUtils;

import okhttp3.Call;
import okhttp3.OkHttpClient;
import okhttp3.Response;

public class English_change_book_activity extends BaseActivity{

    private TextView all_title_text;
    private ImageView all_title_img_back;
    private ListView change_book_grade;
    private ListView change_book_books;
    private SharedPreferences sp;
    private String token;
    private OkHttpManager okHttpManager;

    @Override
    public void initView() {
        all_title_text = findViewById(R.id.all_title_text);
        change_book_grade = findViewById(R.id.change_book_grade);
        change_book_books = findViewById(R.id.change_book_books);
        all_title_text.setText("修改教材");
        all_title_img_back = findViewById(R.id.all_title_img_back);
        sp = SpUtils.get(English_change_book_activity.this);
        token = sp.getString("token","");
    }

    @Override
    public void initData() {
        get_userBaseInfo(token);
        all_title_img_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                English_change_book_activity.this.finish();
            }
        });
    }

    /**
     * 获取用户基本数据
     * @param token
     */
    private void get_userBaseInfo(String token) {
        okHttpManager = OkHttpManager.getInstance();
        okHttpManager.getRequest(English_change_book_activity.this,Constant_domain.BaseUrl + Constant_url.user_profile, new LoadCallBack<String>(English_change_book_activity.this) {
            @Override
            protected void onSuccess(Call call, Response response, String s) {
                LogUtils.showLog("获取用户基本信息",s);
            }

            @Override
            protected void onEror(Call call, int statusCode, Exception e) {

            }
        });
    }

    @Override
    public int getLayout() {
        return R.layout.activity_english_change_book;
    }
}