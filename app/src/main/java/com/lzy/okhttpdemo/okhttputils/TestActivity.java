package com.lzy.okhttpdemo.okhttputils;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;

import com.lzy.okhttpdemo.R;
import com.lzy.okhttpdemo.base.BaseActivity;
import com.lzy.okhttpdemo.callback.JsonCallback;
import com.lzy.okhttpdemo.model.ServerModel;
import com.lzy.okhttputils.OkHttpUtils;
import com.lzy.okhttputils.callback.StringCallback;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;
import okhttp3.Call;
import okhttp3.Response;

public class TestActivity extends BaseActivity {

    @Bind(R.id.image) ImageView imageView;
    @Bind(R.id.edit) EditText editText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);
        setTitle("测试页面");
        ButterKnife.bind(this);
    }

    @OnClick(R.id.btn1)
    public void btn1(View view) {
    }

    @OnClick(R.id.btn2)
    public void btn2(View view) {
    }

    @OnClick(R.id.btn3)
    public void btn3(View view) {
    }
}
