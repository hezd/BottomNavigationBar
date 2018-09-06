package com.hezd.navigationbar.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;

import com.hezd.navigationbar.R;

public class MainFragment extends BaseFragment {

    public static MainFragment newInstance(String param1, String param2) {
        MainFragment fragment = new MainFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public int getLayoutId() {
        return R.layout.fragment_main;
    }

    @Override
    public void initViews(View view, @Nullable Bundle savedInstanceState) {

    }

}
