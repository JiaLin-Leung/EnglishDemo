package com.englishdemo.Activity;

import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.Tools.tools;
import com.google.gson.Gson;
import com.englishdemo.Bean.LoginBean;
import com.englishdemo.Internet.LoadCallBack;
import com.englishdemo.Internet.OkHttpManager;
import com.englishdemo.R;
import com.englishdemo.Tools.Constant_domain;
import com.englishdemo.Tools.Constant_url;
import com.englishdemo.Tools.LogUtils;
import com.englishdemo.Tools.SpUtils;

import java.util.HashMap;
import java.util.Map;

import okhttp3.Call;
import okhttp3.Response;

public class LoginActivity extends BaseActivity {

    private EditText login_ed_username;
    private EditText login_ed_password;
    private Button login_button;
    private String username;
    private String password;
    private OkHttpManager mOkHttpManager;
    private Gson gson = new Gson();
    private Intent intent;

    @Override
    public void initView() {
        login_ed_username = findViewById(R.id.login_ed_username);
        login_ed_password = findViewById(R.id.login_ed_password);
        login_button = findViewById(R.id.login_button);
    }

    @Override
    public void initData() {
        intent = new Intent();
        login_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(fastClick()){
                    username = login_ed_username.getText().toString();
                    password = login_ed_password.getText().toString();
                    int a = Judge_empty(LoginActivity.this,username,password,"用户名","密码");
                    if (a != -1){
                        user_login(username,password);
                    }
                }
            }
        });
    }

    /**
     * 登录逻辑网络操作
     * @param username 用户名
     * @param password 密  码
     */
    private void user_login(String username, String password) {

        /***
         * {
         "username":"15038035398",
         "password":"111111",
         "login_type": 90,
         "version": "6.0.1",
         "name": "865f8521b18fe9b",
         "model": "MI 4LTE",
         "platform": "Android",
         "uuid": "A100005064E391",
         "appversion": "1.0.0"
         }
         */
        Map<String, String> params = new HashMap<String, String>();
        params.put("username",username);
        params.put("password",password);
        params.put("login_type",9+"");
        params.put("version", tools.getAndroidVersion());
        params.put("name", tools.getAndroidName(this));
        params.put("model", tools.getDeviceISN(this));
        params.put("platform", "Android");
        params.put("uuid", tools.getDeviceType(this));
        params.put("appversion", tools.getAppVersion(this));
        mOkHttpManager = OkHttpManager.getInstance();
        mOkHttpManager.postRequest(LoginActivity.this,Constant_domain.BaseUrl + Constant_url.login_url_stu, new LoadCallBack<String>(LoginActivity.this) {

            @Override
            protected void onSuccess(Call call, Response response, String s) {
                LoginBean loginBean = gson.fromJson(s, LoginBean.class);
                LogUtils.showLog("登陆成功!", loginBean.toString());
                LogUtils.showLog("用户token!",loginBean.getTbkt_token());
                LogUtils.showLog("用户ID!",loginBean.getData().getUser_id());
                LogUtils.showLog("用户flag!",loginBean.getData().getFlag());
                SpUtils.save(LoginActivity.this,"token",loginBean.getTbkt_token());
                SpUtils.save(LoginActivity.this,"user_id",loginBean.getData().getUser_id());
                intent.setClass(LoginActivity.this,MainActivity.class);
//                startActivity(intent);
//                LoginActivity.this.finish();
            }

            @Override
            protected void onEror(Call call, int statusCode, Exception e) {
                LogUtils.showLog("登陆失败!错误码---", statusCode+"");
                LogUtils.showLog("登陆失败!错误信息---", e+"");
            }
        },params);
    }

    @Override
    public int getLayout() {
        return R.layout.activity_log;
    }
}
