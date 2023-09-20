package com.example.ziying_assignment1_1551960.ui.base;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public abstract class BaseFragment extends Fragment {

    protected abstract void initViews();

    protected abstract int getLayoutId();

    // Reference: https://www.bilibili.com/video/BV1tY41187fi?p=6&spm_id_from=pageDriver&vd_source=f5f3d58d9edd57f53b4fc59eb37cacdd
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View contentView = inflater.inflate(getLayoutId(),container,false);
        initViews();
        return contentView;
    }



}
