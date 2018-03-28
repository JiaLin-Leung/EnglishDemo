package com.englishdemo.Activity.English_Activity;

import android.content.SharedPreferences;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.Bean.ResponseBean;
import com.englishdemo.Bean.English_Book;
import com.Bean.User;
import com.englishdemo.Activity.BaseActivity;
import com.englishdemo.Adapter.BookAdapter;
import com.englishdemo.Internet.LoadCallBack;
import com.englishdemo.Internet.OkHttpManager;
import com.englishdemo.R;
import com.englishdemo.Tools.Constant_domain;
import com.englishdemo.Tools.Constant_url;
import com.englishdemo.Tools.LogUtils;
import com.englishdemo.Tools.SpUtils;
import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import okhttp3.Call;
import okhttp3.Response;

public class English_change_book_activity extends BaseActivity{

    private static final int GET_INFO_DOWN = 1000;
    private TextView all_title_text;
    private ImageView all_title_img_back;
    private ListView change_book_grade;
    private ListView change_book_books;
    private SharedPreferences sp;
    private OkHttpManager okHttpManager;
    private Gson gson;
    private User user;
    private ArrayList<String> grade = new ArrayList<>();
    private int grade_flag_begin;
    private int grade_flag_end;
    private Map<String, String> params;
    private Map<String, String> params_book_info;
    private English_Book english_book;

    @Override
    public void initView() {
        all_title_text = findViewById(R.id.all_title_text);
        change_book_grade = findViewById(R.id.change_book_grade);
        change_book_books = findViewById(R.id.change_book_books);
        all_title_text.setText("修改教材");
        all_title_img_back = findViewById(R.id.all_title_img_back);
        all_title_img_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                English_change_book_activity.this.finish();
            }
        });
        sp = SpUtils.get(English_change_book_activity.this);
        change_book_books.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, final int i, long l) {
                    LogUtils.showLog("我点击的是---",i+1+"");
                    params_book_info = new HashMap<String, String>();
                    params_book_info.put("book_id",english_book.getData().getBooks().get(i+1).getId());
                    okHttpManager.postRequest(English_change_book_activity.this, Constant_domain.BaseUrl + Constant_url.book_set, new LoadCallBack<String>(English_change_book_activity.this) {

                        @Override
                        protected void onSuccess(Call call, Response response, String s) {

                            ResponseBean responseBean = gson.fromJson(s,ResponseBean.class);
                            if(responseBean.getResponse().equals("ok")){
                                showToask(English_change_book_activity.this,"设置成功!", Toast.LENGTH_LONG);
                                English_change_book_activity.this.finish();
                            }else{
                                showToask(English_change_book_activity.this,"设置失败,请重试!", Toast.LENGTH_LONG);
                            }
                        }
                        @Override
                        protected void onEror(Call call, int statusCode, Exception e) {

                        }
                    },params_book_info);
                }
        });
    }

    @Override
    public void initData() {
        gson = new Gson();
        get_userBaseInfo();
        params = new HashMap<String, String>();
        change_book_grade.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                    params.put("grade_id",i+1+"");
                    params.put("subject_id",91+"");
                    params.put("type",1+"");
                    LogUtils.showLog("选择教材的年级点击条目",i+"");
                    okHttpManager.postRequest(English_change_book_activity.this, Constant_domain.BaseUrl + Constant_url.book_select,
                            new LoadCallBack<String>(English_change_book_activity.this) {

                                @Override
                                protected void onSuccess(Call call, Response response, String s) {

                                    english_book = gson.fromJson(s,English_Book.class);
                                    LogUtils.showLog("获取教材详情成功",english_book.toString());
                                    change_book_books.setAdapter(new BookAdapter(english_book.getData().getBooks(),English_change_book_activity.this));
                                }

                                @Override
                                protected void onEror(Call call, int statusCode, Exception e) {
                                    LogUtils.showLog("获取教材详情失败",e.toString());
                                }
                            },params);
                }
        });
    }

    /**
     * 获取用户基本数据
     */
    private void get_userBaseInfo() {
        okHttpManager = OkHttpManager.getInstance();
        okHttpManager.getRequest(English_change_book_activity.this,Constant_domain.BaseUrl + Constant_url.user_profile, new LoadCallBack<String>(English_change_book_activity.this) {
            @Override
            protected void onSuccess(Call call, Response response, String s) {
                user = gson.fromJson(s,User.class);
                LogUtils.showLog("获取用户基本信息成功",user.toString());
                if(user.getData().getDept_type().equals("1")){
                    grade_flag_begin = 1;
                    grade_flag_end = 6;
                }else{
                    grade_flag_begin = 6;
                    grade_flag_end = 9;
                }
                for(int a = grade_flag_begin;a<=grade_flag_end;a++){
                    grade.add(a+"年级");
                }
                change_book_grade.setAdapter(new ArrayAdapter<String>(English_change_book_activity.this,R.layout.item_text,R.id.text_id,grade));
            }

            @Override
            protected void onEror(Call call, int statusCode, Exception e) {
                LogUtils.showLog("获取用户基本信息失败",e.toString());
            }
        });
    }

//    private Handler handler = new Handler() {
//
//        @Override
//        public void handleMessage(Message msg) {
//            super.handleMessage(msg);
//            switch (msg.what){
//                case GET_INFO_DOWN:
//
//                    break;
//            }
//        }
//    };

    @Override
    public int getLayout() {
        return R.layout.activity_english_change_book;
    }
}
