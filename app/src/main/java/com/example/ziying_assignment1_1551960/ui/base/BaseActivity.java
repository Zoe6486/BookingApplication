package com.example.ziying_assignment1_1551960.ui.base;

import android.os.Bundle;
import android.view.View;

import androidx.annotation.IdRes;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public abstract class BaseActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayoutId());
        initViews();
    }

    protected abstract void initViews();

    protected abstract int getLayoutId();

    //Reference: https://www.bilibili.com/video/BV1tY41187fi?p=6&spm_id_from=pageDriver&vd_source=f5f3d58d9edd57f53b4fc59eb37cacdd


}
